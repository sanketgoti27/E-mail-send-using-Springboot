package com.Rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.Rest.Entites.Employee;

public interface EmpoyeeRepository extends CrudRepository<Employee, Integer> {

	public Employee findById(int id);

}
