# TaxExample
Save api
---------------
localhost:8080/saveEmployeeDetails
{
    "empId":"123",
    "firstName":"asdas",
    "lastName":"asd",
    "email":"sadas",
    "phoneNo" : ["9032451514","1236548758"],
    "joiningDate":"2023-01-04",
    "salary":"123"
}

Used H2 db to store data
--------------------------------------------------------------------------
to calculate tax for the financial year 2023 to 2024 mar
2) localhost:8080/getTax 
 {
    "empId":"123",
    "firstName":"asdas",
    "lastName":"asd",
    "email":"sadas",
    "phoneNo" : ["9032451514","1236548758"],
    "joiningDate":"2023-01-04",
    "salary":"60000"
}

response
---------
{
    "empId": 123,
    "firstName": "asdas",
    "lastName": "asd",
    "email": "sadas",
    "phoneNo": [
        "9032451514",
        "1236548758"
    ],
    "joiningDate": "2017-04-04",
    "salary": 60000.0,
    "totalTax": 44500.0

