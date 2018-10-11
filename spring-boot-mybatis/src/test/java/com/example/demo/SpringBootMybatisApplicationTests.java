package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.Address;
import com.example.demo.bean.Class;
import com.example.demo.bean.Student;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class SpringBootMybatisApplicationTests {
	
	@Autowired
	ClassMapper classmapper;
	@Autowired
	AddressMapper addressmapper;
	@Autowired
	StudentMapper studentmapper;

	@Test
	public void contextLoads() {
		//this.addclass();
		//this.updateclass();
		//this.deleteclass();
		//this.selectclass();
		//this.addaddress();
		//this.updateaddress();
		//this.deleteaddress();
		//this.selectaddress();
		//this.getstudent();
		//this.deletestudent();
		//this.getstudents();
		//this.addstudent();
		//this.updatestudent();
		//this.addstudent();
		//this.updatestudent();
		this.selectstudentbymap();//根据map中的条件对数据库student表进行查找,返回student的一个实体类 并显示所在的班级id
		//this.deleteaddressbylist();//根据给出的list(存入的是地址的id)对address表中的数据进行删除
	}
	
	public void addclass(){
		Class cla = new Class();
		cla.setId(1);
		cla.setName("one");
		classmapper.addclass(cla);
	}
	public void updateclass(){
		Class cla = new Class();
		cla.setId(1);
		cla.setName("two");
		classmapper.updateclass(cla);
	}
	public void deleteclass(){
		classmapper.deleteclass(1);
	}
	public void selectclass(){
		Class cla=classmapper.selectclassbyid(2);
		System.out.println(cla);
	}
	
	
	public void addaddress(){
		Address add=new Address();
		add.setAdd_id(6);
		add.setAdd_name("6666");
		addressmapper.addaddress(add);
	}
	public void updateaddress(){
		Address add=new Address();
		add.setAdd_id(6);
		add.setAdd_name("7777");
		addressmapper.updateaddress(add);;
	}
	public void deleteaddress(){
		addressmapper.deleteaddress(6);
	}
	public void selectaddress(){
		Address add=addressmapper.selectaddress(4);
		System.out.println(add);
	}
	public void deleteaddressbylist(){
		//Map<String,List<Integer>> map=new HashMap<>();
		List<Integer> list=new ArrayList<>();
		list.add(7);list.add(8);list.add(9);list.add(10);
		//map.put("list", list);
		//addressmapper.deleteaddressbylist(map);
		addressmapper.deleteaddressbylist(list);
	}
	
	public void getstudent(){
		Student s=studentmapper.selectstudent(4);
		System.out.println(s);
	}
	public void deletestudent(){
		studentmapper.deletestudent(5);
	}
	public void getstudents(){
		ArrayList<Student> a=studentmapper.findbyclassid(2);
		System.out.println(a);
	}
    public void addstudent(){
    	Student s= new Student(6, "ccc", 21,new Address(6,"ccch"));
    	Address a= s.getAddress();
    	addressmapper.addaddress(a);
    	studentmapper.addstudent(s);
    }
    public void updatestudent(){
    	Student s= new Student(6, "xxx", 100, new Address(6,"xxxh"));
    	Address a= s.getAddress();
    	addressmapper.updateaddress(a);
    	studentmapper.updatestudent(s);
    }
    public void selectstudentbymap(){
    	Map<String, Object> map=new HashMap<>();
    	map.put("name","cy" );
    	map.put("age", 20);
    	Student s=studentmapper.selectstudentbymap(map);
    	int classid=studentmapper.selectclassidbyid(s.getId());
    	System.out.println(s+",cla_id="+classid);
    }
    
}
