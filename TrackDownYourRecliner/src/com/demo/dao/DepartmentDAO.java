package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.DepartmentManagementException;
import com.demo.exception.DepartmentNotFoundException;
import com.demo.vo.DepartmentVO;

public class DepartmentDAO {
	public boolean addDepartmentDetails(DepartmentVO vo) throws DepartmentManagementException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement stmt = null;
		boolean flag;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO department(department_id,department_name)VALUES (?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getDepartment_id());
			stmt.setString(2, vo.getDepartment_name());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e)

		{
			throw new DepartmentManagementException("error when adding Department details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DepartmentManagementException("error when adding Department details" + e.getMessage());

			}
		}
		return flag;
	}

	public DepartmentVO fetchDepartmentById(int department_id) throws DepartmentNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DepartmentVO vo = new DepartmentVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from department where department_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, department_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));

			}
		} catch (SQLException e) {
			throw new DepartmentNotFoundException("Error when add the department Details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DepartmentNotFoundException("Error when add the department Details" + e.getMessage());

			}
		}
		return vo;
	}

	public Map<String, DepartmentVO> fetchDepartmentByName(String department_Name) throws DepartmentNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,DepartmentVO> map = new HashMap<String,DepartmentVO>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from department where department_name=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, department_Name);
			rs = ps.executeQuery();
			while (rs.next()) {
				DepartmentVO vo1 = new DepartmentVO();
				vo1.setDepartment_id(rs.getInt("department_id"));
				vo1.setDepartment_name(rs.getString("department_name"));
				map.put(department_Name, vo1);
				
			}
		} catch (SQLException e) {
			throw new DepartmentNotFoundException("Error when add the department Details" + e.getMessage());
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				throw new DepartmentNotFoundException("Error when add the department Details" + e.getMessage());

			}
		}
		return map;
	
	}

	public boolean updateDepartmentDetalis(DepartmentVO vo) throws DepartmentManagementException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/project";
		Connection connection = null;
		PreparedStatement stmt = null;
		boolean flag;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE department set department_name=? WHERE department_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, vo.getDepartment_name());
			stmt.setInt(2, vo.getDepartment_id());
			stmt.executeUpdate();
			flag = true;
			System.out.println("Updated the department Details Successfully...");
		} catch (SQLException e) {
			throw new DepartmentManagementException("error when updating Department details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DepartmentManagementException("error when updating Department details" + e.getMessage());

			}
		}
		return flag;
	}
}
