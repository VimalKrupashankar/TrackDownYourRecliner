package com.demo.bo;


import java.util.HashMap;
import java.util.Map;

import com.demo.dao.StudentDAO;
import com.demo.exception.StudentManagementException;
import com.demo.exception.StudentNotFoundException;
import com.demo.vo.DepartmentVO;
import com.demo.vo.StudentVO;

public class TrackDownYourReclinerBO {

	StudentDAO dao = new StudentDAO();
	

	public boolean addStudentDetails(StudentVO vo) throws StudentManagementException {
		boolean flag;
		try {
			flag = dao.addStudentDetails(vo);
			
		} catch (StudentManagementException e) {
			throw new StudentManagementException("Error when adding student details" + e.getMessage());
		}
		return flag;
	}

	public StudentVO fetchStudentById(int student_id) throws StudentNotFoundException {
		StudentVO vo = new StudentVO();
		vo = dao.fetchStudentById(student_id);
		return vo;
	}

	public Map<String,StudentVO> fetchStudentByStudent_name(String Student_name) throws  StudentNotFoundException {

		Map<String,StudentVO> map=new HashMap<String,StudentVO>();
		map=dao.fetchStudentByName(Student_name);
		
		return map;
	}

	public boolean updatestudentDetalis(StudentVO vo) throws StudentManagementException {
		boolean flag;
		flag = dao.updatestudentDetalis(vo);
		return flag;

	}
}
