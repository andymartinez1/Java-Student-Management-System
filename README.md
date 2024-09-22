This is a Student Management System using Sprint Boot 3 and Java 17. It uses Thymeleaf as a templating engine for server side rendering.

To try, create a database in MySQL using the following snippet:
- CREATE database student_management;

In the src > main > resources > applications.properties file, add the following properties:
- spring.datasource.url=jdbc:mysql://localhost:3306/student_management
- spring.datasource.username=root *NOTE:* Username is typically root. If not, use the username you used to set up MySQL 
- spring.datasource.password=***** *NOTE:* Replace the ***** with your MySQL password

There is no Postman collection provided as all functions can be tested within the views. After running the application, please open up a browser and type in the following URL:
http://localhost:8080/students

You can now add a new student by clicking the "Add New Student" link in the nav bar:
![image](https://github.com/user-attachments/assets/ae3b39f2-0fe1-4fee-888b-f6870c3f406f)

Fields are validated to make sure they are not empty and the email field contains a valid email address.

Click on the "Students" link to view, edit or delete a student entry.
