package com.usdj.repository;

import com.usdj.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author gerrydeng
 * @date 2019-07-25 15:08
 * @Description:
 */
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    Employee findByName(String name);
}
