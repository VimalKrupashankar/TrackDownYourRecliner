package com.demo.responce;

import java.util.Map;

import com.demo.vo.StudentDepartmentVO;
import com.demo.vo.StudentVO;

public class StudentResponseObject {
	String successMessage;
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
	public Map<String, StudentVO> getStudentVOMap() {
		return studentVOMap;
	}
	public void setStudentVOMap(Map<String, StudentVO> studentVOMap) {
		this.studentVOMap = studentVOMap;
	}
	public StudentVO getStudentVO() {
		return studentVO;
	}
	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	String failureMessage;
	Map<String, StudentVO> studentVOMap;
	StudentVO studentVO;
}
