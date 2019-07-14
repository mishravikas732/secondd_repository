package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.bean.Student;
import com.sample.util.StudentUtil;

public class StudentDao {
	public static void insertstudent(Student s)
	{
		try {
			Connection conn=StudentUtil.createconnection();
			String sql="insert into login(First_name,Last_name,Email,Mobile,Address,Salary,id) values (?,?,?,?,?,?,?)";
			System.out.println("Connected Established");
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getMobile());
			pst.setString(5, s.getAddress());
			pst.setString(6, s.getSalary());
			pst.setInt(7, s.getId());
			pst.executeUpdate();
			System.out.println("Value inserted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Student> getAllStudent()
	{
		List<Student> list=new ArrayList<Student>();
		try {
			Connection conn=StudentUtil.createconnection();
			String sql="select * from login";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				s.setFname(rs.getString("First_name"));
				s.setLname(rs.getString("Last_name"));
				s.setEmail(rs.getString("Email"));
				s.setAddress(rs.getString("Address"));
				s.setMobile(rs.getString("Mobile"));
				s.setSalary(rs.getString("Salary"));
				s.setId(Integer.parseInt(rs.getString("id")));
				list.add(s);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return list;
	}
	public static Student getStudentById(int id)
	{
		Student student=null;
		try {
			Connection conn=StudentUtil.createconnection();
			System.out.println("connection created for getstudentby id method");
			String sql="select * from login where id=? ";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				student=new Student();
				student.setId(rs.getInt("id"));
				student.setFname(rs.getString("fname"));
				student.setLname(rs.getString("lname"));
				student.setAddress(rs.getString("address"));
				student.setEmail(rs.getString("email"));
				System.out.println("data stored in student object by getStudentById method");
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("object return sucessfully by getStudentBYId method");
		return student;
		
		
		
	}
	public static void updateStudent(Student s)
	{
		try {
			Connection conn=StudentUtil.createconnection();
			String sql="update login set First_name=?,Last_name=?,email=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setInt(4, s.getId());
			pst.executeUpdate();
			
			
		} catch (Exception e) {
		 e.printStackTrace();
		}
		
	}
	
	public static void deleteStudentById(int id)
	{
		try {
			Connection conn=StudentUtil.createconnection();
			String sql="delete from login where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
