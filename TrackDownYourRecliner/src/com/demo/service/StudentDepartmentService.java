package com.demo.service;

import com.demo.bo.StudentDepartmentBO;
import com.demo.exception.StudentDepartmentManagementException;
import com.demo.exception.StudentDepartmentNotFoundException;
import com.demo.responce.StudentDepartmentResponceObject;
import com.demo.vo.StudentDepartmentVO;

public class StudentDepartmentService {
	StudentDepartmentBO bo1 = new StudentDepartmentBO();
	StudentDepartmentResponceObject obj1 = new StudentDepartmentResponceObject();

	public StudentDepartmentResponceObject addStudentDepartmentDetails(StudentDepartmentVO vo)
			throws StudentDepartmentManagementException {
		boolean flag;
		try {
			flag = bo1.addStudentDepartmentDetails(vo);
			if (flag)
				obj1.setSuccessMessage("StudentDepartment Details Added Successfully");
			else
				obj1.setFailureMessage("Error When Adding StudentDepartment Details, Reach out Administrator");
		} catch (StudentDepartmentManagementException e) {
			obj1.setFailureMessage("Error When Adding The Student Details" + e.getMessage());
		}
		return obj1;
	}

	public StudentDepartmentResponceObject fetchStudentDepartmentById(int studentdepartment_id)
			throws StudentDepartmentNotFoundException {

		try {
			StudentDepartmentVO vo;
			vo = bo1.fetchStudentDepartmentById(studentdepartment_id);
			obj1.setStudentdepartmentVO(vo);
		} catch (StudentDepartmentNotFoundException e) {
			obj1.setFailureMessage("Fetch Studentdepartment is not in the list" + e.getMessage());
		}
		return obj1;
	}

	public StudentDepartmentResponceObject updatestudentdepartment(StudentDepartmentVO vo)
			throws StudentDepartmentManagementException {
		boolean flag;
		try {
			flag = bo1.updateStudentDepartmentDetalis(vo);
			if (flag)
				obj1.setSuccessMessage("Department details updated Successfully");
			else
				obj1.setFailureMessage("Error When updating department Details, Reach out Administrator");
		} catch (StudentDepartmentManagementException e) {
			obj1.setFailureMessage("Error When updating The department Details" + e.getMessage());
		}
		return obj1;
	}

}
