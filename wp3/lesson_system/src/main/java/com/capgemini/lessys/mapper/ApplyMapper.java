package com.capgemini.lessys.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.capgemini.lessys.bean.Apply;

@Mapper
public interface ApplyMapper {

	void addApply(Apply apply);//添加申请表
	void setStateOne(@Param("id")int id,@Param("i")int i);//将特定id的申请表的老师审批改为i
	void setStateTwo(@Param("id")int id,@Param("i")int i);//将特定id的申请表的主任审批改为i
	List<Apply> getApplyByMap(Map<String, Object> map);//根据给出的map 查找返回一个申请表的list
	List<Apply> getApplyByTeacher(int id);//通过老师id找到返回其需要审批的申请表的list
	List<Apply> getApplyByMaster(int id);//通过主任id找到返回其需要审批的申请表的list
	int getcount();//获取表单个数
	Apply getApplyByStuLesId(@Param("stuId")int stuId,@Param("lesId")int lesId);//获取有效的申请(两个审批状态(state)不为-1)
	
}
