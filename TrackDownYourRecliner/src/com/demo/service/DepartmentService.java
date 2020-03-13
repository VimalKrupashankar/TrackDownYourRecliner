package com.demo.service;



import java.util.HashMap;
import java.util.Map;

import com.demo.bo.DepartmentBO;
import com.demo.exception.DepartmentManagementException;
import com.demo.exception.DepartmentNotFoundException;
import com.demo.responce.DepartmentResponseObject;
import com.demo.vo.DepartmentVO;

public class DepartmentService {

	DepartmentBO bo2 = new DepartmentBO();
	DepartmentResponseObject obj2 = new DepartmentResponseObject();

	public DepartmentResponseObject adddepartment(DepartmentVO vo) throws DepartmentManagementException {
		boolean flag;
		try {
			flag = bo2.adddepartment(vo);
			if (flag)
				obj2.setSuccessMessage("Department Added Successfully");
			else
				obj2.setFailureMessage("Error When Adding Department Details, Reach out Administrator");
		} catch (DepartmentManagementException e) {
			obj2.setFailureMessage("Error When Adding The Department Details" + e.getMessage());
		}
		return obj2;
	}

	public DepartmentResponseObject fetchDepartmentById(int department_id) throws DepartmentNotFoundException {
		try {
			DepartmentVO vo;
			vo = bo2.fetchdepartment_id(department_id);
			obj2.setDepartmentVo(vo);
		} catch (DepartmentNotFoundException e) {
			obj2.setFailureMessage("Error When Fetching The department Details" + e.getMessage());
		}
		return obj2;
	}

	public DepartmentResponseObject fetchDepartmentByName(String department_name) throws DepartmentNotFoundException {

		try {
			Map<String,DepartmentVO> map=new HashMap<String,DepartmentVO>();
			map=bo2.fetchDepartmentByName(department_name);
			obj2.setDepartmentVoMap(map);
		} catch (DepartmentNotFoundException e) {
			obj2.setFailureMessage("Error When Fetching The department Details" + e.getMessage());
		}
		return obj2;
	}

	public  DepartmentResponseObject updatedepartment(DepartmentVO vo) throws DepartmentManagementException {
		boolean flag;
		try {
			flag = bo2.updatedepartment(vo);
			if (flag)
				obj2.setSuccessMessage("Department details updated Successfully");
			else
				obj2.setFailureMessage("Error When updating department Details, Reach out Administrator");
		} catch (DepartmentManagementException e) {
			obj2.setFailureMessage("Error When updating The department Details" + e.getMessage());
		}
		return obj2;
	}

}
