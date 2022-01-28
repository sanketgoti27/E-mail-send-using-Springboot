package com.Rest.controler;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Rest.Entites.Employee;
import com.Rest.service.EmployeeService;
import com.Rest.service.MailService;

@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
@RestController
public class TestControler {

	@Autowired
	@Qualifier("mySqlDataSource")
	DataSource dataSource;

	@Autowired
	private MailService mailService;

	@Autowired
	private EmployeeService empService;

	@GetMapping("/allemployee")
	public List<Employee> getEmployee() {

		return this.empService.getAllEmployee();
	}

	@GetMapping("/test1")
	public String getValue() {

		System.out.println(" hello ");

		return "hi";
	}

	@GetMapping("/getemployee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {

		return empService.getEmployeeById(id);
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {

		employee.setId(employee.getId());
		employee.setName(employee.getName());
		employee.setRole(employee.getRole());
		employee.setMail(employee.getMail());

		this.empService.addEmployee(employee);
		this.mailService.sendSimpleMessage("sanketgoti1111@gmail.com", employee.getMail(),
				" Congratulation " + employee.getName(), "your registration id is " + employee.getId());

		return this.empService.addEmployee(employee);
	}

	@GetMapping("/deleteemployee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {

		this.empService.deleteEmployee(id);
	}

	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {

		this.empService.updateEmployee(emp, id);

		return emp;
	}

}
