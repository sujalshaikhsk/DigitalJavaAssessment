# DigitalJavaAssessment
sujalshaikhsk/DigitalJavaAssessment Project


Technologies:
------------
 -> Springboot
 -> H2 database
 -> JPA

Customer Entity:
---------------
 -> Customer Id
 -> First name
 -> Last Name
 -> Gender
 
Account Entity:
--------------
 -> Account Number
 -> Account Type
 -> Customer {foreign key}
 
 
APIs:
----
1. Fetch customer Details: http://localhost:8082/api/customers
2. Fetch Account by account number: http://localhost:8082/api/accounts/12345
