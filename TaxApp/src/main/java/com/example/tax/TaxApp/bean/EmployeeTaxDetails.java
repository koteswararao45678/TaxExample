package com.example.tax.TaxApp.bean;


public class EmployeeTaxDetails {
    Long empid;
    private String firstName;
    private String lastName;
    double yearlySalary;
    double taxAmount;
    double cessAmount;
    
    
    
	public Long getEmployeeId() {
		return empid;
	}
	public void setEmployeeId(Long empid) {
		this.empid = empid;
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
	public double getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}
	@Override
	public String toString() {
		return "EmployeeTaxDetails [empid=" + empid + ", firstName=" + firstName + ", lastName="
				+ lastName + ", yearlySalary=" + yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount="
				+ cessAmount + "]";
	}

   
    
}
