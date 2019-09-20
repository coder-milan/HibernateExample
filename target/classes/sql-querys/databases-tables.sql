create database School;

use School;

create table students(id bigint(15) not null auto_increment,
name varchar(100) not null,
grade varchar(100) not null,
phone varchar(20),
primary key (id)
);


create table student_login(
id bigint(15) not null auto_increment,
username varchar(100) not null,
password varchar(100) not null,
created_at datetime not null,
updated_at datetime ,
last_signed_on datetime,
student_id bigint(15) not null,
primary key (id),
foreign key (student_id) references students(id)
);

show tables;