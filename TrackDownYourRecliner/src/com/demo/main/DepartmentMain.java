package com.demo.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.demo.exception.DepartmentManagementException;
import com.demo.exception.DepartmentNotFoundException;
import com.demo.responce.DepartmentResponseObject;
import com.demo.service.DepartmentService;
import com.demo.vo.DepartmentVO;

public class DepartmentMain {
	public static void main(String[] args)
			throws DepartmentManagementException, DepartmentNotFoundException {
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Department");
		System.out.println("2. Fetch Department by Department_id");
		System.out.println("3. Fetch Department by Department_name");
		System.out.println("4. Update Department Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			adddepartment();
			break;
		case 2:
			fetchDepartmentById();
			break;
		case 3:
			fetchDepartmentByName();
			break;
		case 4:
			updatedepartment();
			break;
		default:
			System.exit(0);
		}
	}

	

	private static void adddepartment() throws DepartmentManagementException {
		DepartmentService department = new DepartmentService();
		Scanner s = new Scanner(System.in); 
		boolean flag;
		System.out.println("Please Enter The department_id:");
		Integer department_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The department_Name:");
		String department_Name = s.nextLine();
		DepartmentVO vo = new DepartmentVO();
		vo.setDepartment_id(department_id);
		vo.setDepartment_name(department_Name);
		DepartmentResponseObject obj = department.adddepartment(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchDepartmentById() throws DepartmentNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The department ID:");
		Integer department_id = Integer.parseInt(s.nextLine());

		DepartmentService department = new DepartmentService();
		DepartmentResponseObject obj = null;
		obj = department.fetchDepartmentById(department_id);
		DepartmentVO vo = new DepartmentVO();
		vo = obj.getDepartmentVo();
		if (vo != null) {
			System.out.println(
					"========================================================================================================================================================");
			System.out.println("department_id" + '\t' + "department_name");
			System.out.println(
					"=========================================================================================================================================================");
			System.out.println(vo.getDepartment_id() + "\t\t" + vo.getDepartment_name());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}

	private static void fetchDepartmentByName() throws DepartmentNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The department Name:");
		String department_Name = s.nextLine();

		DepartmentService departmentService = new DepartmentService();
		DepartmentResponseObject obj = null;
		obj = departmentService.fetchDepartmentByName(department_Name);
		Map<String ,DepartmentVO> map = new HashMap<String ,DepartmentVO>();
		map = obj.getDepartmentVoMap();
		if (map!=null) {
			System.out.println(
					"========================================================================================================================================================");
			System.out.println("department_id" + '\t' + "department_Name");
			System.out.println(
					"=========================================================================================================================================================");

			System.out.println(map);
		} else  {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void updatedepartment() throws DepartmentManagementException {

		DepartmentService department = new DepartmentService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The department_id:");
		Integer department_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The department_name:");
		String department_name = s.nextLine();

		DepartmentVO vo = new DepartmentVO();
		vo.setDepartment_id(department_id);
		vo.setDepartment_name(department_name);

		DepartmentResponseObject obj = null;
		obj = department.updatedepartment(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}

}
