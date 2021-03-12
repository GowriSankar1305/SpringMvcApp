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