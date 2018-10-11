package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Address;

@Mapper
public interface AddressMapper {

	void addaddress(Address add);
	void deleteaddress(int id);
	void updateaddress(Address add);
	Address selectaddress(int id);
	//void deleteaddressbylist(Map<String, List<Integer> > map);
	void deleteaddressbylist(List<Integer> list);
}
