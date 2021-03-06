# Expense Reimbursement System (ERS) 

## Project Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used
* Java version 1.8
* PostgreSQL version 13
* JDBC version 9.4.1208
* AWS RDS
* HTML version 5
* Log4j version 1.2.17
* JUnit version 5.7.0
* Mockito version 3.11.2

## Features
List of features ready:
* Ready-for-deploy .war back-end project for [front-end application](https://github.com/maustrauk/revature-project-ERS-fe).
* Controller level for processing requests from endpoints: 
  * /project1/login.user
  * /project1/signup.user
  * /project1/edit.user
  * /project1/empl.user-list
  * /project1/by-user-id.reimb-list
  * /project1/add.reimb-list
  * /project1/by-manager-id.reimb-list
  * /project1/update.reimb-list
* Service level for achieving business logic in operations with front-end and database.
* Data Access Object (DAO) level for data transactions between application and its database.
* User password encoding.
* Receipt image upload in `.jpg` format.

## Getting Started
1. Prepare your database for work with the back-end through AWS RDS service.
2. To upload this project you need to clone this repository using `git clone https://github.com/maustrauk/revature-ERS.git`. 
3. Add `database.properties` file to `src/main/resources`. It should include:

```
URL=jdbc:postgresql://{your DB URL}:{DB port}/{DB name}
USERNAME={DB user name}
PASSWORD={DB user password}
```

4. Add this project to your Java IDE.
5. Update Maven dependencies in the project.
6. Run As "Run on Server" cloned project in your Java IDE.
7. Make sure do download and install [front-end](https://github.com/maustrauk/revature-project-ERS-fe).


## Usage
After launching this application you should see `INFO: Server startup in [...] milliseconds`.\
You can use [Postman API](https://www.postman.com/) to check if you can reach featured endpoints using your `localhost:8080`:\
![Postman screenshot](/project_1_readme_1.jpg?raw=true)

## License
MIT License


