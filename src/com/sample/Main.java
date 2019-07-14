package com.sample;
import java.util.List;

import com.sample.bean.Student;
import com.sample.dao.StudentDao;

public class Main {
	
	
	public static void main(String[] args) {
		StudentDao sd=new StudentDao();
		List<Student> list=sd.getAllStudent();
	}

}
