package org.jsp.employeeapp.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.employeeapp.dto.Employee;

public class EmployeeDao {
	Session s = new Configuration().configure().buildSessionFactory().openSession();

	public Employee saveEmployee(Employee employee) {
		Transaction t = s.beginTransaction();
		s.save(employee);
		t.commit();
		return employee;
	}

	public Employee updateEmpoyee(Employee emp) {
		Employee db = s.get(Employee.class, emp.getId());
		if (db != null) {
			Transaction t = s.beginTransaction();
			db.setName(emp.getName());
			db.setPhone(emp.getPhone());
			db.setDesignation(emp.getDesignation());
			db.setSalary(emp.getSalary());
			db.setPassword(emp.getPassword());
			t.commit();
			return db;
		}
		return null;
	}

	public Employee findById(int id) {
		return s.get(Employee.class, id);
	}

	public boolean deleteEmployee(int id) {
		Employee e = findById(id);
		if (e != null) {
			s.delete(e);
			Transaction t = s.beginTransaction();
			t.commit();
			return true;
		}
		return false;
	}

	public Employee verifyEmployee(long phone, String password) {
		String hql = "select e from Employee e where e.phone=?1 and e.password=?2";
		Query<Employee> q = s.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
