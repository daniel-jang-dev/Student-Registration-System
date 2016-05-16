// create database and tables

CREATE DATABASE students_7;

USE students_7;

CREATE TABLE logins (
	
user_login VARCHAR(15) NOT NULL,
user_password CHAR(30) NOT NULL,
PRIMARY KEY (user_login)
);

CREATE TABLE roles (

user_login VARCHAR(15) NOT NULL,
role_name VARCHAR(15) NOT NULL,
PRIMARY KEY (user_login, role_name)
);

CREATE TABLE student (

student_id INT(11) NOT NULL AUTO_INCREMENT,
student_name VARCHAR(60),
student_email VARCHAR(50),
program_name enum('Physics', 'Mathematics', 'Chemistry'),
student_year INT(10),
student_share TINYINT(1),
PRIMARY KEY (student_id)
);


// insert values

INSERT INTO roles VALUES ('hpotter', 'teacher');
INSERT INTO roles VALUES ('mmouse', 'teacher');
INSERT INTO roles VALUES ('jhutter', 'student');

INSERT INTO logins VALUES ('hpotter', 'sesame');
INSERT INTO logins VALUES ('mmouse', 'sesame');
INSERT INTO logins VALUES ('jhutter', 'sesame');

