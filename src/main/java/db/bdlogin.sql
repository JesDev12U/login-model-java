create database login;
use login;

create table users(
	id int primary key auto_increment,
    username varchar(50),
    password_usr varchar(50)
);

insert into users values (default, "admin", "admin");