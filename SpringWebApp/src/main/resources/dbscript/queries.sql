-- customer table creation : 10-Mar-2021 : Start
create table spring_db.tbl_customer (
customer_id bigint auto_increment primary key,
first_name varchar(200) not null,
last_name varchar(200) not null,
mobile_number varchar(20) not null unique,
email_id varchar(100) not null unique,
address varchar(500) not null,
gender varchar(10) not null,
created_date bigint not null,
modified_date bigint not null,
date_of_birth date not null,
age smallint not null,
user_name varchar(50) not null unique,
password varchar(200) not null,
is_active_user tinyint not null
);
-- customer table creation : 10-Mar-2021 : End

-- customer table columns added : 12-Mar-2021 : Start
alter table spring_db.tbl_customer
add column is_created_from_admin_journey tinyint not null,
add column is_created_from_customer_journey tinyint not null
-- customer table columns added : 12-Mar-2021 : End

-- admin table creation : 12-Mar-2021 : Start
create table spring_db.tbl_admin (
admin_id bigint auto_increment primary key,
first_name varchar(200) not null,
last_name varchar(200) not null,
mobile_number varchar(20) not null unique,
email_id varchar(100) not null unique,
date_of_birth bigint not null,
gender varchar(10) not null,
address varchar(500) not null,
age smallint not null,
user_name varchar(50) not null unique,
password varchar(200) not null,
is_active_user tinyint not null,
created_date bigint not null,
modified_date bigint not null
);
-- admin table creation : 12-Mar-2021 : End

-- super admin table creation : 12-Mar-2021 : Start
create table spring_db.tbl_super_admin (
super_admin_id bigint auto_increment primary key,
super_admin_name varchar(200) not null,
created_date bigint not null,
is_active_user tinyint not null,
user_name varchar(50) not null unique,
password varchar(200) not null,
email_id varchar(100) not null unique,
mobile_number varchar(20) not null unique
);
-- super admin table creation : 12-Mar-2021 : End

-- alter column types : 12-Mar-2021 : Start
alter table spring_db.tbl_admin modify column date_of_birth date;
alter table spring_db.tbl_customer modify column date_of_birth date;
-- alter column types : 12-Mar-2021 : Start

-- tables creation : 21-Mar-2021 : Start

-- country table
create table spring_db.tbl_country (
country_id bigint auto_increment primary key,
country_code varchar(10) not null unique,
country_name varchar(100) not null unique,
phone_code smallint not null
);
-- country table

-- state table 
create table spring_db.tbl_state ( 
state_id bigint auto_increment primary key, 
state_name varchar(100) not null unique, 
country_id bigint not null, 
constraint tbl_state_fk_01 foreign key(country_id) 
references spring_db.tbl_country(country_id) 
);
-- state table

-- city table
create table spring_db.tbl_city	(
city_id bigint auto_increment primary key,
city_name varchar(100) not null,
state_id bigint not null,
constraint tbl_city_fk_01 foreign key(state_id) 
references spring_db.tbl_state(state_id)
);
-- cityt table

-- gowri shankar : 28-Mar-2021 : START

-- customer table alter command
alter table spring_db.tbl_customer
add column identity_type varchar(20) not null,
add column identity_number varcahr(50) not null;
-- customer table alter command

-- room status table
create table spring_db.tbl_room_status (
status_id bigint auto_increment primary key,
status varchar(50) not null,
status_icon varchar(50) not null,
created_date datetime not null,
updated_date datetime not null
);
-- room status table

-- room type table
create table spring_db.tbl_room_type (
room_type_id bigint auto_increment primary key,
room_type_name varchar(50) not null
);
-- room type table

-- facility table
create table spring_db.tbl_facility (
facility_id 
);
-- blocked room table creation
create table spring_db.tbl_blocked_room (
blocked_id bigint auto_increment primary key,
from_date datetime not null,
to_date datetime not null,
room_status_id bigint not null,
room_id bigint not null,
created_date bigint not null,
is_deleted tinyint not null,
blocked_by_staff_id bigint not null,
blocked_by_admin_id bigint not null,
constraint tbl_blocked_room_fk_01(room_status_id) references spring_db.tbl_room_status(status_id),
constraint tbl_blocked_room_fk_02(room_id)
constraint tbl_blocked_room_fk_01(blocked_by_staff_id) 
constraint tbl_blocked_room_fk_01(blocked_by_admin_id) references spring_db.tbl_admin
);
-- blocked room table creation

-- gowri shankar : 28-Mar-2021 : End