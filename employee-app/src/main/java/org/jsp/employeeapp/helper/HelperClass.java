package org.jsp.employeeapp.helper;

import java.util.Scanner;

import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dto.Employee;

public class HelperClass {
	Scanner ip = new Scanner(System.in);
	EmployeeDao dao = new EmployeeDao();
	Employee e = new Employee();

	public void save() {
		System.out.println("Enter Employee Name, Phone, Designation, Salary and Password to Save");
		e.setName(ip.next());
		e.setPhone(ip.nextLong());
		e.setDesignation(ip.next());
		e.setSalary(ip.nextDouble());
		e.setPassword(ip.next());
		e = dao.saveEmployee(e);
		System.out.println("Employee Saved With Id:" + e.getId());
	}

	public void update() {
		System.out.println("Enter Employee Id to Update Record");
		int id = ip.nextInt();
		System.out.println("Enter Employee Name, Phone, Designation, Salary and Password to Update");
		e.setId(id);
		e.setName(ip.next());
		e.setPhone(ip.nextLong());
		e.setDesignation(ip.next());
		e.setSalary(ip.nextDouble());
		e.setPassword(ip.next());
		e = dao.saveEmployee(e);
		if (e != null) {
			System.out.println("Employee Updated Successfully");
		} else {
			System.out.println("Cant update employee or Invalid Id");
		}
	}

	public void verify() {
		System.out.println("Enter employee phone and password to verify");
		long phone = ip.nextLong();
		String password = ip.next();
		Employee e = dao.verifyEmployee(phone, password);
		if (e != null) {
			System.out.println("Employee Verified");
			System.out.println("Id:" + e.getId());
			System.out.println("Name:" + e.getName());
			System.out.println("Phone:" + e.getPhone());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Designation:" + e.getDesignation());
		} else {
			System.out.println("Employee Not Verified Invalid Id Or Password");
		}
	}

	public void findById() {
		System.out.println("Enter Employee Id to Find");
		int id = ip.nextInt();
		Employee e = dao.findById(id);
		if (e != null) {
			System.out.println("Id:" + e.getId());
			System.out.println("Name:" + e.getName());
			System.out.println("Phone:" + e.getPhone());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Designation:" + e.getDesignation());
		} else {
			System.out.println("Employee Not Found or Invalid Id");
		}
	}
	
	public void delete() {
		System.out.println("Enter Product Id To Delete");
		int id=ip.nextInt();
		if(dao.deleteEmployee(id)) {
			System.out.println("Product Deleted");
		}
		else {
			System.out.println("Invalid Id");
		}
	}
}
