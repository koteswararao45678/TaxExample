/*
 * Creation : Jun 5, 2023
 */
package com.example.tax.TaxApp.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tax.TaxApp.bean.Employee;
import com.example.tax.TaxApp.bean.EmployeeBean;
import com.example.tax.TaxApp.bean.EmployeeTaxDetails;
import com.example.tax.TaxApp.exception.BadRequest;
import com.example.tax.TaxApp.repo.EmpRepo;
import com.example.tax.TaxApp.service.EmployeeTaxService;

@RestController
public class Controller {
	Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    EmpRepo repo;
    
    @Autowired
    EmployeeTaxService employeeService = new EmployeeTaxService();

    @PostMapping("/saveEmployeeDetails")
    public ResponseEntity<?> saveEmployeeDetails(@RequestBody Employee employee) throws BadRequest {
    	LOGGER.info("Employee Controller - saveEmployeeDetails {}", employee);
    	//    	validate user data
    	validatemployee(employee);
        
        System.out.println(employee.getJoiningDate());
        Employee dataSaved = repo.save(employee);
        LOGGER.info("Employee details saved Success fully {}", dataSaved);
        return new ResponseEntity<>(dataSaved, HttpStatus.CREATED);
    }

    private void validatemployee(Employee employee) throws BadRequest {
    	Optional<Employee> bean = Optional.ofNullable(employee);
        if (bean.get().getFirstName().isEmpty()) {
            throw new BadRequest("First name should not be empty");
        }
        if (bean.get().getEmail().isEmpty()) {
            throw new BadRequest("Last name should not be Empty");
        }
//        if (bean.get().getEmpId() <= 0) {
//            throw new BadRequest("Enter valid EmpID");
//        }
//        if (bean.get().getPhoneNo().isEmpty()) {
//            throw new BadRequest("Phone Number Should not be empty");
//        }
        if (bean.get().getSalary() <= 1) {
            throw new BadRequest("Please enter valid salry");
        }
		
	}

	@GetMapping("/calculateEmployeeTax/{id}")
    public ResponseEntity<EmployeeTaxDetails> calEmployeeTax(@PathVariable Long id) throws BadRequest {
		
		LOGGER.info("Employee Controller - calEmployeeTax {}", id);
		
		Employee employeeDetails = employeeService.findById(id).orElseThrow(() -> new BadRequest("Employee not found"));
		// tax method
    	EmployeeTaxDetails taxDetails = employeeService.calculateTax(employeeDetails);
    	
        return new ResponseEntity<>(taxDetails, HttpStatus.OK);
    }
    
    
//    @GetMapping("/koti")
//    public String getMethod() {
//    	
//    	EmployeeTaxDetails taxDetails = taxService.calculateTaxAndCess(emp);
//    	System.out.println(taxDetails);
//    	
//    	return "koti";
//    }

}
