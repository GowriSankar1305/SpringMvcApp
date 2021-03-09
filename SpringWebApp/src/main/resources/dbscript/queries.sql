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