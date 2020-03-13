package com.demo.vo;

public class DepartmentVO {
	 private int department_id;
	public int getDepartment_id() {
		return department_id;
	}
	@Override
	public String toString() {
		return "departmentVO [department_id=" + department_id + ", department_name=" + department_name
				+ ", getDepartment_id()=" + getDepartment_id() + ", getDepartment_name()=" + getDepartment_name() + "]";
	}
	public void setDepartment_id(int string) {
		this.department_id = string;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	private String department_name;
	

}


