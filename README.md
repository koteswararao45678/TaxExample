# TaxExample
Save api
---------------
localhost:8080/saveEmployeeDetails
{
  "firstName": "Koteswararao",
  "lastName": "Ramanadham",
  "email": "ramanadhamrao@virtusa.com",
  "phoneNumbers": ["902451514","999999999"],
  "joiningDate": "2023-01-01",
  "salary": 1050000
}

Used H2 db to store data
--------------------------------------------------------------------------
to calculate tax for the financial year 2023 to 2024 mar
2) localhost:8080/calculateEmployeeTax/8
 

response
---------
{
    "empId": 7,
    "firstName": "Koteswararao",
    "lastName": "Ramanadham",
    "email": "ramanadhamrao@virtusa.com",
    "phoneNumbers": [
        "902451514",
        "9032195893"
    ],
    "joiningDate": "2023-01-01",
    "salary": 1050000.0
}

2-------------
{
    "firstName": "Koteswararao",
    "lastName": "Ramanadham",
    "yearlySalary": 2100000.0,
    "taxAmount": 282500.0,
    "cessAmount": 0.0,
    "employeeId": 7
}
