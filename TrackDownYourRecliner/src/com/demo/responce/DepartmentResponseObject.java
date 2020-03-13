package com.demo.responce;


import java.util.Map;

import com.demo.vo.DepartmentVO;

public class DepartmentResponseObject {
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	public Map<String, DepartmentVO> getDepartmentVoMap() {
		return departmentVoMap;
	}
	public void setDepartmentVoMap(Map<String, DepartmentVO> departmentVoMap) {
		this.departmentVoMap = departmentVoMap;
	}
	public DepartmentVO getDepartmentVo() {
		return departmentVo;
	}
	public void setDepartmentVo(DepartmentVO departmentVo) {
		this.departmentVo = departmentVo;
	}
	String successMessage;
	String failureMessage;
	Map<String, DepartmentVO> departmentVoMap;
	DepartmentVO departmentVo;
	

}
