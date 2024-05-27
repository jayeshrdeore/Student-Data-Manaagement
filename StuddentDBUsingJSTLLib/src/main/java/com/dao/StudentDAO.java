package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.util.DBUtility;

public class StudentDAO {
	DBUtility utility;
	
	public StudentDAO() {
		utility = new DBUtility();
	}
	
	//ADD Student
	public int insertStudent(Student student,String url,String username, String password) {
		Connection con = utility.getDBConnection(url, password, password);
		String sql = "insert into studentdb1 values(?,?,?)";
		int res = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, student.getId());
			psmt.setString(2,student.getName());
			psmt.setDouble(3,student.getMarks());
			
			res = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(res>0) {
			return 1;
			
		}else {
			return 0;
		}
	}
	
	//Read all student
	public List<Student> getAllStudents(String url, String username, String password){
		Connection con = utility.getDBConnection(url, username, password);
		String sql = "select * from studentdb1";
		List<Student> list = new ArrayList<Student>();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Student object = new Student();
				object.setId(rs.getInt(1));
				object.setName(rs.getString(2));
				object.setMarks(rs.getDouble(3));
				
				list.add(object);
			}  
		} catch (Exception e) {
			System.out.println(e);
		}
		return list; 
	}
	
	// get student by id
		public Student getStudentById(int id, String url, String username, String password) {

			Connection con = utility.getDBConnection(url, username, password);
			String sql = "SELECT * FROM studentdb1 where id=?";
			Student object = new Student();
			try {
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setInt(1, id);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					object.setId(rs.getInt(1));
					object.setName(rs.getString(2));
					object.setMarks(rs.getDouble(3));
				}
			} catch (Exception e) {
				System.out.println(e);
			}

			return object;
		}

		// delete student by id

		public int deleteStudentById(int id, String url, String username, String password) {
			int i = 0;
			try {
				Connection con = utility.getDBConnection(url, username, password);
				String sql = "delete from studentdb1 where id=?";
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setInt(1, id);

				i = psmt.executeUpdate();
			} catch (

			Exception e) {
				System.out.println(e);
			}

			return i;
		}

		//update student

		public int updateStudent(Student student, String url, String username, String password) {

			Connection con = utility.getDBConnection(url, username, password);
			String sql = "update studentdb1 set name=? , marks=? where id=?";
			int res = 0;
			try {
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setInt(3, student.getId());
				psmt.setString(1, student.getName());
				psmt.setDouble(2, student.getMarks());

				res = psmt.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}
			if (res > 0) {
				return 1;
			} else {
				return 0;
			}

		}


}
