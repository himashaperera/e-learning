# e-learning

A system which facilitates academic needs of a university due to covid-19 pandemic situation.

Functionalities of the system are as follows;
* adding new courses and lessons to courses.
* upload and download of course material
* adding new users and roles to the system
* enables learners to attempt quizzes
* adding feedback to courses
* adding notices

Backend   -  Spring MVC, Spring JDBC with Oracle SQL Server
Front end - HTML, CSS, JS, Bootstrap

Tools
* Eclipse IDE for Java EE developers  2021-12 version
* Apache Tomcat Server 9.0.55
* Oracle Database Express Edition

Project Set Up

1. Clone the project from Github.
2. Import to eclipse workspace as a maven project.
3. Update the maven project to install all dependecies.
4. Change project complaince level to java 1.8 from: right clicking on project -> properties -> project facets -> select java 1.8 -> click apply and apply and close
5. Download Apache Tomcat Server 9.0 and change the server port to port: 8085
6. Run the DB Script and change username and password feilds of bean named dataSource to your credentials.
7. Change the folder upload location of mentioned as UPLOAD_FOLDER in Constants.java(com.elearning.util package) to a folder location in your computer.
8. Run the project as;
    right click on project -> Run as -> Run on Server -> select Apache Tomcat Server v9.0 at localhost -> add the project to server and click finish.

