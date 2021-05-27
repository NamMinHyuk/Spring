package com.file.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.file.updown.util.FileValidator;
import com.file.updown.util.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result ) {
		fileValidator.validate(uploadFile, result); // 객체 검증 result로 에러 찾는다.
		
		if(result.hasErrors()) { // 에러가 있으면 upload.jsp view로 간다.
			return "upload";
		}
		
		MultipartFile file = uploadFile.getMpfile(); // 업로드한 파일
		String name = file.getOriginalFilename(); // 파일의 원래 이름
		
		UploadFile fileObj = new UploadFile(); // dto에 넣기
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null; //(input,output) stream 초기화
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream(); 
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage"); // 실제경로에 + resources/sotrage  
			System.out.println("업로드 될 실제 경로 : " + path);
			
			File storage = new File(path); //storage가 없으면 폴더 생성
			if(!storage.exists()) {
				storage.mkdirs();
			}
			
			File newFile = new File(path + "/" + name); // 새파일이 없으면 생성 
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newFile); 
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			while((read = inputStream.read(b)) != -1) {  // 마지막까지 들어오면 -1을 return 해줌
				outputStream.write(b, 0, read); //실제 파일 업로드 부분
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		model.addAttribute("fileObj", fileObj);
		
		return "download";
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		byte[] down = null; // byte 배열 초기화
		
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage"); // 실제경로에 + resources/sotrage
			File file = new File(path + "/" + name); 
			
			down = FileCopyUtils.copyToByteArray(file); 
			
			String filename = new String(file.getName().getBytes(), "8859_1"); // file encoding 설정
			
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\""); // file download 설정
			response.setContentLength(down.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return down;
	}
}
