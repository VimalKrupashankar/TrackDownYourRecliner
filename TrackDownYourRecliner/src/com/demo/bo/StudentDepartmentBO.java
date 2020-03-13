package com.demo.bo;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.StudentDepartmentDAO;
import com.demo.exception.DepartmentNotFoundException;
import com.demo.exception.StudentDepartmentManagementException;
import com.demo.exception.StudentDepartmentNotFoundException;
import com.demo.vo.StudentDepartmentVO;

public class StudentDepartmentBO {
	StudentDepartmentDAO studentdepartment = new StudentDepartmentDAO();

	public boolean addStudentDepartmentDetails(StudentDepartmentVO vo) throws StudentDepartmentManagementException {
		boolean flag;
		try {
			flag = studentdepartment.addStudentDepartmentDetails(vo);
		} catch (StudentDepartmentManagementException e) {
			throw new StudentDepartmentManagementException(
					"Error when adding Studentdepartment details" + e.getMessage());
		}
		return flag;
	}

	public StudentDepartmentVO fetchStudentDepartmentById(int studentdepartment_id)throws StudentDepartmentNotFoundException {
		StudentDepartmentVO vo = new StudentDepartmentVO();
		vo = studentdepartment.fetchStudentDepartmentById(studentdepartment_id);
		return vo;
	}

	public boolean updateStudentDepartmentDetalis(StudentDepartmentVO vo) throws StudentDepartmentManagementException {
		boolean flag;
		flag = studentdepartment.updateStudentDepartmentDetalis(vo);
		return flag;

	}

}
