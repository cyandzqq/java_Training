package com.capgemini.lessys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lessys.bean.Apply;
import com.capgemini.lessys.mapper.ApplyMapper;

@Service
public class ApplyService {

	@Autowired
	ApplyMapper applymapper;
	
	    //添加申请表
	    public void addApply(Apply apply){
	    	applymapper.addApply(apply);
	    }
	    
	    //判断一个申请表是否可以入库()
	    public boolean getApplyByStuAndLesId(int stuId,int lesId){
	    	Apply app=applymapper.getApplyByStuLesId(stuId, lesId);
	    	if(app==null){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
	
	    //老师根据自身id获取需要审批申请表
		public List<Apply> getApplyByTeacherId(int id){
			List<Apply> list=applymapper.getApplyByTeacher(id);
			return list;
		}
		
		//主任根据自身id获取需要审批申请表
		public List<Apply> getApplyByMasterId(int id){
			List<Apply> list=applymapper.getApplyByMaster(id);
			return list;
		}
		
		//根据给的map查找申请表
		public List<Apply> getApplyByMap(Map<String, Object> map){
			List<Apply> list=applymapper.getApplyByMap(map);
			return list;
		}
		
		//返回现在的申请表的总数
		public int getcount(){
			int i =applymapper.getcount();
			return i;
		}
		
		//老师对表单进行处理
		public void setStateOne(int id,int i){
			applymapper.setStateOne(id, i);
		}
		
		//主任对表单进行处理
	    public void setStateTwo(int id,int i){
			applymapper.setStateTwo(id, i);
		}
}
