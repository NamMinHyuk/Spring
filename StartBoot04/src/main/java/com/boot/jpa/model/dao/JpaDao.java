package com.boot.jpa.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.model.dto.JpaDto;

public interface JpaDao extends JpaRepository<JpaDto, Integer> {

	public List<JpaDto> findAll(Sort sort); // 메소드 이름 바꾸면 안됌
	
	public JpaDto findByMyno(int myno); // Myno = Integer 말하는 것.
	
	public JpaDto save(JpaDto dto);
	
	public JpaDto saveAndFlush(JpaDto dto);
	
	@Transactional
	public void deleteByMyno(int myno);
	
	
}
