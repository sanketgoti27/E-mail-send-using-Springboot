package com.Rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rest.Entites.Employee;
import com.Rest.dao.EmpoyeeRepository;

@Service
public class EmployeeService {

	Employee employee = null;

	@Autowired
	private EmpoyeeRepository employeReposiotry;

	public List<Employee> getAllEmployee() {

		List<Employee> list = (List<Employee>) this.employeReposiotry.findAll();
		return list;
	}

	public Employee getEmployeeById(int id) {

		employee = this.employeReposiotry.findById(id);

		return employee;
	}

	public Employee addEmployee(Employee emp) {

		Employee result = employeReposiotry.save(emp);

		return result;
	}

	public void deleteEmployee(int id) {

		employeReposiotry.deleteById(id);
		System.out.println("Deleted that id ");
	}

	public void updateEmployee(Employee emp, int id) {

		emp.setId(id);
		employeReposiotry.save(emp);

	}

}
