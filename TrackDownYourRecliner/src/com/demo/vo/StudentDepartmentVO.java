package com.demo.vo;

public class StudentDepartmentVO {
	@Override
	public String toString() {
		return "StudentDepartmentVO [studentdepartment_id=" + studentdepartment_id + ", student_id=" + student_id
				+ ", department_id=" + department_id + ", getStudentdepartment_id()=" + getStudentdepartment_id()
				+ ", getStudent_id()=" + getStudent_id() + ", getDepartment_id()=" + getDepartment_id() + "]";
	}
	public int getStudentdepartment_id() {
		return studentdepartment_id;
	}
	public void setStudentdepartment_id(int studentdepartment_id) {
		this.studentdepartment_id = studentdepartment_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	private int studentdepartment_id;
	private int student_id;
	private int department_id;

}
