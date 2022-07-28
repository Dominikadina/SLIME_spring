# SLIME_spring
## Simple Laboratory Information Management System

## Team members:
#### Maja Remizowicz
#### Dominika Gacek

## Project description
#### 
The SLIME project was written to assist small laboratories in managing the whole process of sample testing and reporting results to a customer.

### Role description
1. A customer:
-can visit the system through SLIMS portal to register for a sample lab test,
-can track of his registered test report status,
-have a fancy report immediately just after the tests results are in the system. 
2.  Lab Staff:
-can register delivered samples through SLIMS portal, 
-can CRUD the tests reports,
-can CRUD the billing information of a test registered like for example invoice,
3. Admin:
-can manage the whole of system
-can CRUD the customers and lab staffs
-can accept or reject the tests results.

### Description of some database tables:
Customers make many orders
Customers register many samples
Orders have many order items like packages (defined number of tests)
Order item depends of customer sample which will be delivered to test
Customer sample must be registered by lab staff and has one to one relationship with lab sample
Lab sample has the same information as customer sample + extra information for lab needs
Lab sample has many examples to to improve the quality of tests results
Tests are made by a lab staff
Packages, Status, SampleType, Method, Unit are the Enum Models
entryDate, orderDate, testDate are TIMESTAMP type

### Tasks to do:
Create models in Spring Boot:

Create methods in Spring Boot:
-customer management (CRUD)
-user management (CRUD)
-customer sample register (create)
-lab sample register (create)
-example creation (create)
-test creation (create)
-order creation (create)
Create frontend in React, using Bootstrap or Material UI template
-homepage
-navbar with simple menu
-form to register customer sample
-form to register lab sample
-form to register order
-form to add tests results
-page with customers list
-page with registered lab samples
-page with registered tests result for definded customer

### Tasks nice to have:
Finish CRUD method for rest models
Add functionality of registration and login with database
Report page
Dashboard page (for lab staff and customers as a homepage)
Invoice page
Exporting report and invoice to PDF file
Importing test data from .cls file to test form
Add functionality of electronic signature
Add functionality of online payment
Bar code or Qr code printing to skip customer sample register(customer make an order, print the bar 
code or qr code and lable his/her sample to deliver to lab)
