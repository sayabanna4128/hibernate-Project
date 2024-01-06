package org.jsp.employeeapp.controller;

import java.util.Scanner;

import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.helper.HelperClass;

public class EmployeeApp {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		HelperClass h1 = new HelperClass();
		while (true) {
			System.out.println("1.Save Employee\n2.Update Employee\n3.Find Employee By Id");
			System.out.println("4.Delete Employee By ID");
			System.out.println("5.Verify Employee By phone and password");
			System.out.println("6.EXIT");
			int choice = ip.nextInt();
			switch (choice) {
			case 1:
				h1.save();
				break;
			case 2:
				h1.update();
				break;
			case 3:
				h1.findById();
				break;
			case 4:
				h1.delete();
				break;
			case 5:
				h1.verify();
				break;
			case 6:
				System.out.println("Thanks");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}