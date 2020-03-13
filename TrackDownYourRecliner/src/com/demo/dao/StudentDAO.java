package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.StudentManagementException;
import com.demo.exception.StudentNotFoundException;
import com.demo.vo.StudentVO;

public class StudentDAO {
	public boolean addStudentDetails(StudentVO vo) throws StudentManagementException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement stmt = null;
		boolean flag;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO student(student_id,student_name,student_regno,student_email,student_phone_no,student_gender)VALUES (?,?,?,?,?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getStudent_id());
			stmt.setString(2, vo.getStudent_name());
			stmt.setInt(3, vo.getStudent_regno());
			stmt.setString(4, vo.getStudent_email());
			stmt.setLong(5, vo.getStudent_phone_no());
			stmt.setString(6, vo.getStudent_gender());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new StudentManagementException("error when adding Student details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StudentManagementException("error when adding Student details" + e.getMessage());

			}
		}
		return flag;
	}

	public StudentVO fetchStudentById(int student_id) throws StudentNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StudentVO vo = new StudentVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from student where student_id=?";
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, student_id);
            rs=stmt.executeQuery();
	
			while (rs.next()) {
				vo.setStudent_id(rs.getInt("student_id"));
				vo.setStudent_name(rs.getString("student_name"));
				vo.setStudent_regno(rs.getInt("student_regno"));
				vo.setStudent_email(rs.getString("student_email"));
				vo.setStudent_phone_no(rs.getLong("student_phone_no"));
				vo.setStudent_gender(rs.getString("student_gender"));

			}
		} catch (SQLException e) {
			throw new StudentNotFoundException("Error when add the Student Details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StudentNotFoundException("Error when add the Student Details" + e.getMessage());

			}
		}
		return vo;
	}

	public Map<String, StudentVO> fetchStudentByName(String student_Name) throws StudentNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,StudentVO> map = new HashMap<String,StudentVO>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from student where student_name=?";
			ps = connection.prepareStatement(query);

			ps.setString(1, student_Name);
			rs = ps.executeQuery();
			while (rs.next()) {
				StudentVO vo = new StudentVO();

				vo.setStudent_id(rs.getInt("student_id"));
				vo.setStudent_name(rs.getString("student_name"));
				vo.setStudent_regno(rs.getInt("student_regno"));
				vo.setStudent_email(rs.getString("student_email"));
				vo.setStudent_phone_no(rs.getLong("student_phone_no"));
				vo.setStudent_gender(rs.getString("student_gender"));
				map.put(student_Name, vo);
				

			}
		} catch (SQLException e) {
			throw new StudentNotFoundException("Error when add the Student Details" + e.getMessage());
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				throw new StudentNotFoundException("Error when add the Student Details" + e.getMessage());

			}
		}
		return map;

	}

	public boolean updatestudentDetalis(StudentVO vo) throws StudentManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE Student set student_name=?,student_regno=?,student_email=?,student_phone_no=?,student_gender=? WHERE student_id=?";
			stmt = connection.prepareStatement(query);
			
			stmt.setString(1, vo.getStudent_name());
			stmt.setInt(2, vo.getStudent_regno());
			stmt.setString(3, vo.getStudent_email());
			stmt.setLong(4, vo.getStudent_phone_no());
			stmt.setString(5, vo.getStudent_gender());
			stmt.setInt(6, vo.getStudent_id());
			stmt.executeUpdate();
			flag = true;
			System.out.println("Updated the Student Details Successfully...");
		} catch (SQLException e) {
			throw new StudentManagementException("Error	 when updating Student details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StudentManagementException("Error when updating Student details" + e.getMessage());

			}
		}
		return flag;
	}
}
