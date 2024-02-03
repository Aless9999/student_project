drop table if exists st_student_child;
drop table if exists st_student_order;
DROP TABLE IF EXISTS st_passport_office;
DROP TABLE IF EXISTS st_register_office;
DROP TABLE IF EXISTS st_country_struct;
drop table if exists st_street;
drop table if exists st_address;


CREATE TABLE st_street(
	street_code integer not null,
	street_name varchar(300),
	PRIMARY KEY(street_code)
);

create table st_country_struct(
	area_id char(12) not null,
	area_name varchar(200),
	primary key(area_id)
);
create table st_passport_office(
	p_office_id integer not null,
	p_office_area_id char(32) not null,
	p_office_name varchar(200),
	primary key (p_office_id),
	foreign key (p_office_area_id)references
	st_country_struct(area_id)on delete restrict
);

create table st_register_office(
	r_office_id integer not null,
	r_office_area_id char(32) not null,
	r_office_name varchar(200),
	primary key (r_office_id),
	foreign key (r_office_area_id)references
	st_country_struct(area_id)on delete restrict
);




 CREATE TABLE st_address(
	address_id SERIAL,
	post_code varchar(10),
	street varchar(100),
	building varchar(10),
	extension varchar(10),
	apartment varchar(10),
	PRIMARY KEY(address_id)
);

create table st_student_order(
student_order_id serial,
h_sur_name varchar (100) not null,
h_given_name varchar(100)not null,
h_patronymic varchar(100)not null,
h_date_of_birth date not null,
h_post_index varchar (10),
h_street_code integer not null,
h_building varchar (10) not null,
h_extension varchar(10),
h_apartment varchar(10),
h_passport_seria varchar(10)not null,
h_passport_number varchar(10)not null,
h_passport_date date not null,
h_passport_office_id integer not null,
w_sur_name varchar (100) not null,
w_given_name varchar(100)not null,
w_patronymic varchar(100)not null,
w_date_of_birth date not null,
w_post_index varchar (10),
w_street_code integer not null,
w_building varchar (10) not null,
w_extension varchar(10),
w_apartment varchar(10),
w_passport_seria varchar(10)not null,
w_passport_number varchar(10)not null,
w_passport_date date not null,
w_passport_office_id integer not null,
certificate_id varchar(20)not null,
register_office_id integer not null,
marriage_date date not null,
primary key (student_order_id),
foreign key (h_street_code)references st_street(street_code)on delete restrict,
foreign key (w_street_code)references st_street(street_code)on delete restrict,
foreign key (register_office_id)references st_register_office(r_office_id)on delete restrict

);

create table st_student_child(
student_child_id serial,
student_order_id integer not null,
c_sur_name varchar (100) not null,
c_given_name varchar(100)not null,
c_patronymic varchar(100)not null,
c_date_of_birth date not null,
c_post_index varchar (10),
c_street_code integer not null,
c_building varchar (10) not null,
c_extension varchar(10),
c_apartment varchar(10),
c_certificate_number varchar(10),
c_certificate_date date not null,
c_register_office_id integer not null,
primary key (student_child_id),
foreign key (c_street_code)references st_street(street_code)on delete restrict,
foreign key (c_register_office_id)
	references st_register_office(r_office_id)on delete restrict

);


