package com.demo.bo;

import java.util.HashMap;
import java.util.Map;

import com.demo.dao.DepartmentDAO;
import com.demo.exception.DepartmentManagementException;
import com.demo.exception.DepartmentNotFoundException;
import com.demo.vo.DepartmentVO;


public class DepartmentBO {
	DepartmentDAO dao=new DepartmentDAO();
	public boolean adddepartment(DepartmentVO vo) throws DepartmentManagementException{
	boolean flag;
	try {
		flag = dao.addDepartmentDetails(vo);
	} catch (DepartmentManagementException e) {
		throw new DepartmentManagementException("Error when adding department details" + e.getMessage());
	}
	return flag;
}
	public DepartmentVO fetchdepartment_id(int department_id) throws  DepartmentNotFoundException
	{
		DepartmentVO vo=new DepartmentVO();
    vo=dao.fetchDepartmentById(department_id);
    return vo;
    }
	public Map<String, DepartmentVO> fetchDepartmentByName(String department_name)throws DepartmentNotFoundException
	{
		Map<String,DepartmentVO>map=new HashMap<String,DepartmentVO>();
		map=dao.fetchDepartmentByName(department_name);
		return map;
	}

	public boolean updatedepartment(DepartmentVO vo) throws DepartmentManagementException
	{
		boolean flag;
		flag=dao.updateDepartmentDetalis(vo);
		return flag;
		
	}

    }	

