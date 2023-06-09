/*
 * Creation : Jun 9, 2023
 */
package com.example.tax.TaxApp.bean;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

public class EmployeeBean {

    @NotNull
    private int empId;
    @NotNull
    private String firstName;
    private String lastName;
    private String email;
    private List<String> phoneNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date joiningDate;
    private double salary;
    private double totalTax;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(List<String> phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    @Override
    public String toString() {
        return "EmployeeBean [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNo=" + phoneNo
                + ", joiningDate=" + joiningDate + ", salary=" + salary + ", totalTax=" + totalTax + "]";
    }

}
