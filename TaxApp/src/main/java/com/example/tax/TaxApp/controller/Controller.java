/*
 * Creation : Jun 5, 2023
 */
package com.example.tax.TaxApp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tax.TaxApp.bean.Employee;
import com.example.tax.TaxApp.bean.EmployeeBean;
import com.example.tax.TaxApp.exception.BadRequest;
import com.example.tax.TaxApp.repo.EmpRepo;

@RestController
public class Controller {

    @Autowired
    EmpRepo repo;

    @PostMapping("/saveEmployeeDetails")
    public ResponseEntity<?> getFullname(@RequestBody @Validated EmployeeBean employee) throws BadRequest {
        Map<String, Object> respJsonOutput = new LinkedHashMap<String, Object>();
        Optional<EmployeeBean> bean = Optional.ofNullable(employee);
        if (bean.get().getFirstName().isEmpty()) {
            respJsonOutput.clear();
            respJsonOutput.put("status", 400);
            respJsonOutput.put("message", "First name should not be Empty");
            return new ResponseEntity<>(respJsonOutput, HttpStatus.NOT_FOUND);
        }
        if (bean.get().getEmail().isEmpty()) {
            respJsonOutput.clear();
            respJsonOutput.put("status", 400);
            respJsonOutput.put("message", "Last name should not be Empty");
            return new ResponseEntity<>(respJsonOutput, HttpStatus.NOT_FOUND);
        }
        if (bean.get().getEmpId() <= 0) {
            respJsonOutput.clear();
            respJsonOutput.put("status", 400);
            respJsonOutput.put("message", "Enter valid EmpID");
            return new ResponseEntity<>(respJsonOutput, HttpStatus.NOT_FOUND);
        }
        if (bean.get().getPhoneNo().isEmpty()) {
            respJsonOutput.clear();
            respJsonOutput.put("status", 400);
            respJsonOutput.put("message", "Phone Number Should not be empty");
            return new ResponseEntity<>(respJsonOutput, HttpStatus.NOT_FOUND);
        }
        if (bean.get().getSalary() <= 1) {
            respJsonOutput.clear();
            respJsonOutput.put("status", 400);
            respJsonOutput.put("message", "Please enter valid salry");
            return new ResponseEntity<>(respJsonOutput, HttpStatus.NOT_FOUND);
        }

        Employee emp = new Employee();
        emp.setEmail(employee.getEmail());
        emp.setEmpId(employee.getEmpId());
        emp.setFirstName(employee.getFirstName());
        emp.setJoiningDate(employee.getJoiningDate());
        emp.setLastName(employee.getLastName());
        emp.setPhoneNo(employee.getPhoneNo().stream().collect(Collectors.joining(",")));
        emp.setSalary(employee.getSalary());
        System.out.println(emp.getJoiningDate());
        repo.save(emp);
        return new ResponseEntity<EmployeeBean>(HttpStatus.OK);
    }

    @PostMapping("/getTax")
    public EmployeeBean calculateTax(@RequestBody EmployeeBean employee) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(employee.getJoiningDate());
        System.out.println("Converted String: " + strDate);

        Period diff = Period.between(LocalDate.parse(strDate), LocalDate.parse("2024-03-30").plusDays(1));
        System.out.println("Months : " + diff.getMonths());

        Double yearSalary = employee.getSalary() * diff.getMonths();

        double tax = 0;
        double cess = 0;
        if (yearSalary > 250000 && yearSalary <= 500000) {
            tax = (yearSalary - 250000) * 0.05;
        } else if (yearSalary > 500000 && yearSalary <= 1000000)
            tax = (yearSalary - 500000) * 0.2 + 250000 * 0.05;
        else if (yearSalary > 1000000) {
            tax = (yearSalary - 1000000) * 0.3 + 250000 * 0.2 + 250000 * 0.05;
        }

        if (yearSalary > 2800000) {
            cess = 2800000 * 0.02;
        }

        employee.setTotalTax(tax + cess);
        return employee;
    }

}
