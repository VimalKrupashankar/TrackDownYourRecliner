package com.demo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.exception.StudentDepartmentManagementException;
import com.demo.exception.StudentDepartmentNotFoundException;
import com.demo.responce.StudentDepartmentResponceObject;
import com.demo.service.StudentDepartmentService;
import com.demo.vo.StudentDepartmentVO;

public class StudentDepartmentMain {

	public static void main(String[] args)
			throws StudentDepartmentManagementException, StudentDepartmentNotFoundException {
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Student_Department");
		System.out.println("2. Fetch Student_Department by Student_Department_id");
		System.out.println("3. Update Student_Department Details");
		System.out.println("4. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addStudentDepartmentDetails();
			break;
		case 2:
			fetchStudentDepartmentById();
			break;
		case 3:
			updateStudentDepartmentDetalis();
			break;
		default:
			System.exit(0);
		}
	}

	private static void addStudentDepartmentDetails() throws StudentDepartmentManagementException {
		StudentDepartmentService studentdepartment = new StudentDepartmentService();
		Scanner s = new Scanner(System.in); 
		boolean flag;
		System.out.println("Please Enter The studentdepartment_id:");
		Integer studentDepartment_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The student_id:");
		Integer Student_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The department_id:");
		Integer department_id = Integer.parseInt(s.nextLine());
		StudentDepartmentVO vo = new StudentDepartmentVO();
		vo.setStudentdepartment_id(studentDepartment_id);
		vo.setStudent_id(Student_id);
		vo.setDepartment_id(department_id);
		StudentDepartmentResponceObject obj = studentdepartment.addStudentDepartmentDetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchStudentDepartmentById() throws StudentDepartmentNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The  studentdepartment_id:");
		Integer student_department_id = Integer.parseInt(s.nextLine());

		StudentDepartmentService studentdepartment = new StudentDepartmentService();
		StudentDepartmentResponceObject obj = studentdepartment.fetchStudentDepartmentById(student_department_id);
		StudentDepartmentVO vo;
		vo = obj.getStudentdepartmentVO();
		if (vo != null) {
			System.out.println(
					"========================================================================================================================================================");
			System.out.println("studentdepartment_id" + '\t' + "student_id" + '\t' + "department_id");
			System.out.println(
					"=========================================================================================================================================================");
			System.out.println(
					vo.getStudentdepartment_id()        + "\t\t" + vo.getStudent_id()     +"\t\t" + vo.getDepartment_id());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}

	private static void updateStudentDepartmentDetalis() throws StudentDepartmentManagementException {

		StudentDepartmentService department = new StudentDepartmentService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Student_Department_id:");
		Integer Student_Department_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The student_id:");
		Integer Student_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The department_id:");
		Integer department_id = Integer.parseInt(s.nextLine());

		StudentDepartmentVO vo = new StudentDepartmentVO();
		vo.setStudentdepartment_id(Student_Department_id);
		vo.setStudent_id(Student_id);
		vo.setDepartment_id(department_id);

		StudentDepartmentResponceObject obj = null;
		obj = department.updatestudentdepartment(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}

}
