# DigitalJavaAssessment
sujalshaikhsk/DigitalJavaAssessment Project


Technologies:
------------
 -> Java 11
 -> Springboot
 -> H2 database
 -> JPA

Customer Entity:
---------------
 -> Customer Id
 -> Title
 -> First name
 -> Last Name
 -> Gender
 
Account Entity:
--------------
 -> Account Number
 -> BSB
 -> Name
 -> Balance
 -> Customer {foreign key}
 
 
JWT based Authentication added:
------------------------------
Only [customers] related apis need authentication.  

Token API: http://localhost:8082/api/token

payload->

  {
   "username" : "sujal",
   "id": 12345,
   "role": "admin"
  }
 
APIs:
----
1. Fetch Account details of a customer: http://localhost:8082/api/customers/getAccountDetails/00123285
2. Fetch customer Details: http://localhost:8082/api/customers
3. Fetch Account by account number: http://localhost:8082/api/accounts/12345
4. Save/Update Customer Details: http://localhost:8082/api/customers
 
 Payload ->

{
  "customerid": "001234128",
  "title": "Ms",
  "firstname": "sujal",
  "lastname": "shaikh",
  "gender": "male"
}

5. Fetch Account details: http://localhost:8082/api/accounts/12345
6. Save/update account details: http://localhost:8082/api/accounts

Payload ->
 
 {
    "accountno": "56789",
    "bsb": "923100",
    "name": "SM",
    "balance": 2000.2
  }
