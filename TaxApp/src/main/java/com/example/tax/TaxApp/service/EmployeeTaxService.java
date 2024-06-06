package com.example.tax.TaxApp.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tax.TaxApp.bean.Employee;
import com.example.tax.TaxApp.bean.EmployeeTaxDetails;
import com.example.tax.TaxApp.controller.Controller;
import com.example.tax.TaxApp.repo.EmpRepo;

@Service
public class EmployeeTaxService {
	
	static Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private EmpRepo empRepo;

	public  EmployeeTaxDetails calculateTax(Employee employee) {
		// TODO Auto-generated method stub
		LOGGER.info("Employee Service-  calculateTax - {}", employee);
		
		EmployeeTaxDetails employeeTaxDetails =  new EmployeeTaxDetails();
		employeeTaxDetails.setEmployeeId(employee.getEmpId());
		employeeTaxDetails.setFirstName(employee.getFirstName());
		employeeTaxDetails.setLastName(employee.getLastName());
	
        LocalDate startYear = LocalDate.of(employee.getJoiningDate().getYear(), Month.MARCH, 1);
        
        
        if (employee.getJoiningDate().isBefore(startYear)) {
        	
            startYear = startYear.minusYears(1);
        }
        
        LocalDate endYear = startYear.plusYears(1).minusDays(1);

        long noOfMonths;
        if (employee.getJoiningDate().isAfter(endYear)) {
        	employeeTaxDetails.setCessAmount(0);
        	employeeTaxDetails.setTaxAmount(0d);
        	employeeTaxDetails.setYearlySalary(0d);
        	return employeeTaxDetails;
        }

        if (employee.getJoiningDate().isBefore(startYear)) {
        	noOfMonths = 12;
        } else {
        	noOfMonths = ChronoUnit.MONTHS.between(employee.getJoiningDate().withDayOfMonth(1), endYear.withDayOfMonth(1)) + 1;
        }

        double yearlySalary = employee.getSalary() * noOfMonths;
        employeeTaxDetails.setYearlySalary(yearlySalary);
        
        
        employeeTaxDetails.setTaxAmount(calculateTaxAmount(yearlySalary));
        
        employeeTaxDetails.setCessAmount(calculateCessAmount(yearlySalary));

        return employeeTaxDetails;
    }
	
	public  double calculateTaxAmount(double yearlySalary) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Employee Service-  calculateTax");
        double taxAmount = 0;
        if (yearlySalary > 1000000) {
        	
            taxAmount += (yearlySalary - 1000000) * 0.2;
            yearlySalary = 1000000;
            
            
        }
        if (yearlySalary > 500000) {
        	
            taxAmount += (yearlySalary - 500000) * 0.1;
            yearlySalary = 500000;
            
        }
        if (yearlySalary > 250000) {
        	
            taxAmount += (yearlySalary - 250000) * 0.05;
            
        }
        return taxAmount;
    }
	
	public static double calculateCessAmount(double yearlySalary) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Employee Service-  calculateTax");
        if (yearlySalary > 2500000) {
            return (yearlySalary - 2500000) * 0.02;
        }
        return 0;
    }

	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		
		return empRepo.findById(id);
	}
	
	
}
