/*
 * Creation : Jun 9, 2023
 */
package com.example.tax.TaxApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tax.TaxApp.bean.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
