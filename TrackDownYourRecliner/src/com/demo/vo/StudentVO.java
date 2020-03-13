package com.demo.vo;

public class StudentVO {
	private int  student_id;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getStudent_regno() {
		return student_regno;
	}
	public void setStudent_regno(int student_regno) {
		this.student_regno = student_regno;
	}
	@Override
	public String toString() {
		return "StudentVO [student_id=" + student_id + ", student_name=" + student_name + ", student_regno="
				+ student_regno + ", student_email=" + student_email + ", student_phone_no=" + student_phone_no
				+ ", student_gender=" + student_gender + ", getStudent_id()=" + getStudent_id() + ", getStudent_name()="
				+ getStudent_name() + ", getStudent_regno()=" + getStudent_regno() + ", getStudent_email()="
				+ getStudent_email() + ", getStudent_phone_no()=" + getStudent_phone_no() + ", getStudent_gender()="
				+ getStudent_gender() + "]";
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public long getStudent_phone_no() {
		return student_phone_no;
	}
	public void setStudent_phone_no(long student_phone_no) {
		this.student_phone_no = student_phone_no;
	}
	public String getStudent_gender() {
		return student_gender;
	}
	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}
	private String student_name;
	private int student_regno;
	private String student_email;
	private long student_phone_no;
	private String student_gender;
}

