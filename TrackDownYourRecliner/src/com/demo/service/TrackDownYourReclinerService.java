package com.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.bo.TrackDownYourReclinerBO;
import com.demo.exception.StudentManagementException;
import com.demo.exception.StudentNotFoundException;
import com.demo.responce.StudentResponseObject;
import com.demo.vo.StudentVO;

public class TrackDownYourReclinerService {

	TrackDownYourReclinerBO bo1 = new TrackDownYourReclinerBO();
	StudentResponseObject obj1 = new StudentResponseObject();

	public StudentResponseObject addStudent(StudentVO vo) throws StudentManagementException {
		boolean flag;
		try {
			flag = bo1.addStudentDetails(vo);

			if (flag)
				obj1.setSuccessMessage("Student Added Successfully");
			else
				obj1.setFailureMessage("Error When Adding Student Details, Reach out Administrator");
		} catch (StudentManagementException e) {
			obj1.setFailureMessage("Error When Adding The Student Details" + e.getMessage());
		}
		return obj1;
	}

	public StudentResponseObject fetchStudentById(int student_id) throws StudentNotFoundException {

		try {
			StudentVO vo;
			vo = bo1.fetchStudentById(student_id);
			obj1.setStudentVO(vo);
		} catch (StudentNotFoundException e) {
			obj1.setFailureMessage("Error When Fetching The Student Details" + e.getMessage());
		}
		return obj1;
	}

	public StudentResponseObject fetchStudentByName(String student_name) throws StudentNotFoundException {

		try {
			Map<String, StudentVO> map = new HashMap<String, StudentVO>();
			map = bo1.fetchStudentByStudent_name(student_name);

			obj1.setStudentVOMap(map);

		} catch (StudentNotFoundException e) {
			obj1.setFailureMessage("Error When Fetching The Student Details" + e.getMessage());
		}
		return obj1;
	}

	public StudentResponseObject updatestudentDetalis(StudentVO vo) throws StudentManagementException {
		boolean flag;
		try {
			flag = bo1.updatestudentDetalis(vo);
			if (flag)
				obj1.setSuccessMessage("Student details updated Successfully");
			else
				obj1.setFailureMessage("Error When updating Student Details, Reach out Administrator");
		} catch (StudentManagementException e) {
			obj1.setFailureMessage("Error When updating The Student Details" + e.getMessage());
		}
		return obj1;

	}
}
