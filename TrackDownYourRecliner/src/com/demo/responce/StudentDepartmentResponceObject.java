package com.demo.responce;

import java.util.Map;

import com.demo.vo.StudentDepartmentVO;


public class StudentDepartmentResponceObject {
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
	public Map<Integer, StudentDepartmentVO> getStudentdepartmentVOMap() {
		return studentdepartmentVOMap;
	}
	public void setStudentdepartmentVOMap(Map<Integer, StudentDepartmentVO> studentdepartmentVOMap) {
		this.studentdepartmentVOMap = studentdepartmentVOMap;
	}
	public StudentDepartmentVO getStudentdepartmentVO() {
		return studentdepartmentVO;
	}
	public void setStudentdepartmentVO(StudentDepartmentVO studentdepartmentVO) {
		this.studentdepartmentVO = studentdepartmentVO;
	}
	String successMessage;
	String failureMessage;
	Map<Integer, StudentDepartmentVO> studentdepartmentVOMap;
	StudentDepartmentVO studentdepartmentVO;
}
