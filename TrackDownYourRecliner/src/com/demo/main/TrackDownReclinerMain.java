package com.demo.main;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.demo.exception.DepartmentManagementException;
import com.demo.exception.DepartmentNotFoundException;
import com.demo.exception.StudentManagementException;
import com.demo.exception.StudentNotFoundException;
import com.demo.responce.DepartmentResponseObject;
import com.demo.responce.StudentResponseObject;
import com.demo.service.TrackDownYourReclinerService;
import com.demo.vo.StudentVO;
import com.demo.vo.DepartmentVO;

public class TrackDownReclinerMain {

	public static void main(String[] args) throws StudentManagementException, StudentNotFoundException {
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Student");
		System.out.println("2. Fetch Student by Student_id");
		System.out.println("3. Fetch Student by Student_name");
		System.out.println("4. Update Student Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();

		switch (menuSelected) {
		case 1:
			addstudent();
			break;
		case 2:
			fetchStudentById();
			break;
		case 3:
			fetchStudentByName();
			break;
		case 4:
			updateStudent();
			break;
		default:
			System.exit(0);
		}
	}

	private static void addstudent() throws StudentManagementException {
		TrackDownYourReclinerService student = new TrackDownYourReclinerService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The student_ID:");
		Integer Student_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The student_Name:");
		String student_name = s.nextLine();
		System.out.println("Please Enter The student_regno:");
		Integer student_regno = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The student_email:");
		String student_email = s.nextLine();
		System.out.println("Please Enter The student_phone_no:");
		Long student_phone_no = Long.parseLong(s.nextLine());
		System.out.println("Please Enter The student_gender:");
		String student_gender = s.nextLine();

		StudentVO vo = new StudentVO();
		vo.setStudent_id(Student_id);
		vo.setStudent_name(student_name);
		vo.setStudent_regno(student_regno);
		vo.setStudent_email(student_email);
		vo.setStudent_phone_no(student_phone_no);
		vo.setStudent_gender(student_gender);
		StudentResponseObject obj = student.addStudent(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchStudentById() throws StudentNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The student ID:");
		Integer student_id = Integer.parseInt(s.nextLine());

		TrackDownYourReclinerService trackDownYourReclinerService = new TrackDownYourReclinerService();
		StudentResponseObject obj = null;
		obj = trackDownYourReclinerService.fetchStudentById(student_id);
		StudentVO vo = new StudentVO();
		vo = obj.getStudentVO();
		if (vo != null) {
			System.out.println(
					"========================================================================================================================================================");
			System.out.println("student_id" + '\t'     + "student_name" + '\t' + "student_regno" + '\t' + " student_email"
					+ '\t' + '\t' + "student_phone_no" + "nstudent_gender");
			System.out.println(
					"=========================================================================================================================================================");
			System.out.println(vo.getStudent_id() + "\t\t" + vo.getStudent_name() + "\t\t" + vo.getStudent_regno()
					+ "\t\t" + vo.getStudent_email() + "\t\t" + vo.getStudent_phone_no() + "\t\t"
					+ vo.getStudent_gender());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}

	private static void fetchStudentByName() throws StudentNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Student Name:");
		String student_name = s.nextLine();

		TrackDownYourReclinerService trackDownYourReclinerService = new TrackDownYourReclinerService();

		StudentResponseObject obj = null;
		obj = trackDownYourReclinerService.fetchStudentByName(student_name);

		Map<String,StudentVO> map = new HashMap<String ,StudentVO>();
		map = obj.getStudentVOMap();
		if (!map.isEmpty() && obj.getFailureMessage() == null) {
			System.out.println(
					"======================================================================================================================================================");
			System.out.println("student_id" + '\t' + "student_name" + '\t' + "student_regno" + '\t' + " student_email"
					+ '\t' + '\t' + "student_phone_no" + "nstudent_gender");
			System.out.println(
					"======================================================================================================================================================");

			System.out.println(map);

		} else if (map.isEmpty()) {
			System.out.println(obj.getFailureMessage());

		}

	}

	private static void updateStudent() throws StudentManagementException {

		TrackDownYourReclinerService studentservice = new TrackDownYourReclinerService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The student_id:");
		Integer Student_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The student_name:");
		String student_name = s.nextLine();
		System.out.println("Please Enter The student_regno:");
		Integer student_regno = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The student_email:");
		String student_email = s.nextLine();
		System.out.println("Please Enter The student_phone_no:");
		Long student_phone_no = Long.parseLong(s.nextLine());
		System.out.println("Please Enter The student_gender:");
		String student_gender = s.nextLine();

		StudentVO vo = new StudentVO();
		vo.setStudent_id(Student_id);
		vo.setStudent_name(student_name);
		vo.setStudent_regno(student_regno);
		vo.setStudent_email(student_email);
		vo.setStudent_phone_no(student_phone_no);
		vo.setStudent_gender(student_gender);
		StudentResponseObject obj = null;
		obj = studentservice.updatestudentDetalis(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
}
