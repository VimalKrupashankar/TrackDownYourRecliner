package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.exception.StudentDepartmentManagementException;
import com.demo.exception.StudentDepartmentNotFoundException;
import com.demo.vo.StudentDepartmentVO;

public class StudentDepartmentDAO {
	public boolean addStudentDepartmentDetails(StudentDepartmentVO vo) throws StudentDepartmentManagementException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement stmt = null;
		boolean flag;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO studentdepartment(studentdepartment_id,student_id,department_id)VALUES(?,?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getStudentdepartment_id());
			stmt.setInt(2, vo.getStudent_id());
			stmt.setInt(3, vo.getDepartment_id());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new StudentDepartmentManagementException(
					"error when adding StudentDepartment details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StudentDepartmentManagementException(
						"error when adding StudentDepartment details" + e.getMessage());

			}
		}
		return flag;
	}

	public boolean updateStudentDepartmentDetalis(StudentDepartmentVO vo) throws StudentDepartmentManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE studentdepartment set student_id=? ,department_id=? WHERE studentdepartment_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getStudent_id());
			stmt.setInt(2, vo.getDepartment_id());
			stmt.setInt(3, vo.getStudentdepartment_id());
			 stmt.executeUpdate();
			System.out.println("Updated the StudentDepartment Details Successfully...");
		} catch (SQLException e) {
			throw new StudentDepartmentManagementException("error when updating StudentDepartment details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StudentDepartmentManagementException("error when updating StudentDepartment details" + e.getMessage());

			}
		}
		return flag;
	}

	public StudentDepartmentVO fetchStudentDepartmentById(int studentdepartment_id) throws StudentDepartmentNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StudentDepartmentVO vo = new StudentDepartmentVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from studentdepartment where studentdepartment_id=?";
            stmt=connection.prepareStatement(query);
            stmt.setInt(1, studentdepartment_id);
		    rs=stmt.executeQuery();
			while (rs.next()) {

				vo.setStudentdepartment_id( rs.getInt("studentdepartment_id"));
				vo.setStudent_id(rs.getInt("student_id"));
				vo.setDepartment_id(rs.getInt("department_id"));
			}
		} catch (SQLException e) {
			throw new StudentDepartmentNotFoundException("Error when add the Studentdepartment Details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StudentDepartmentNotFoundException("Error when add the Studentdepartment Details" + e.getMessage());

			}
		}
		return vo;
	}

}
