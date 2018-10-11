package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.Address;
import com.example.demo.bean.Student;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;

public class ClassController {

	@Autowired
	StudentMapper studentmapper;
	@Autowired
	AddressMapper addressmapper;
	@Autowired
	ClassMapper calssmapper;
	/*
	@RequestMapping(value="getclass")
	public Student getClass(int id){
		return calssmapper.
	}
*/
}
