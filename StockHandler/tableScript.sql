drop database stockhandler;

create database stockhandler;
use stockhandler;

create table rol(
id int not null auto_increment primary key,
description varchar(20) not null,
rol_status boolean
);

create table credentials(
id int not null auto_increment primary key,
username varchar(25) not null,
password varchar(100) not null
);

create table user (
id int not null auto_increment primary key,
first_name varchar(25) not null,
last_name varchar(30) not null,
fecha_entrada date,
user_status boolean,
rol_id int not null,
cr_id int not null,
foreign key (rol_id) references rol(id),
foreign key (cr_id) references credentials(id)
);