package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Class;

@Mapper
public interface ClassMapper {

	void addclass(Class cla);
	void updateclass(Class cla);
	void deleteclass(int id);
	Class selectclassbyid(int id);
}
