package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {

	@Autowired
	private MYBoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "boardlist";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		
		return "insertform";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(MYBoardDto dto) {
		
		if(biz.insert(dto) > 0) {
			return "redirect:list.do";
		}
		return "redirect:insertform.do";
	}
}
