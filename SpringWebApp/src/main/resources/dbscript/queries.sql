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
add column identity_number varchar(50) not null;
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
room_type_id integer auto_increment primary key,
room_type_name varchar(50) not null
);
-- room type table

-- facility table
create table spring_db.tbl_facility (
facility_id integer auto_increment primary key,
facility_icon varchar(50) not null,
facility_name varchar(50) not null unique
);
-- facility table

-- hotel table
create table spring_db.tbl_hotel (
hotel_id bigint auto_increment primary key,
hotel_name varchar(100) not null unique,
hotel_address varchar(500) not null,
hotel_code varchar(50) not null unique,
primary_contact_number varchar(20) not null unique,
secondary_contact_number varchar(20) not null unique,
city_id  bigint not null,
admin_id bigint not null,
created_date datetime not null,
updated_date datetime not null,
is_active tinyint not null,
no_of_floors integer not null,
constraint tbl_hotel_fk_01 foreign key(city_id) references spring_db.tbl_city(city_id),
constraint tbl_hotel_fk_02 foreign key(admin_id) references spring_db.tbl_admin(admin_id)
);
-- hotel table


-- hotel room type table
create table spring_db.tbl_hotel_room_type (
hotel_id bigint not null,
room_type_id integer not null,
constraint tbl_hotel_room_type_fk_01 foreign key(hotel_id) references spring_db.tbl_hotel(hotel_id),
constraint tbl_hotel_room_type_fk_02 foreign key(room_type_id) references spring_db.tbl_room_type(room_type_id)
);
-- hotel room type table

-- hotel facility table
create table spring_db.tbl_hotel_facility (
hotel_id bigint not null,
facility_id integer not null,
constraint tbl_hotel_facility_fk_01 foreign key(hotel_id) references spring_db.tbl_hotel(hotel_id),
constraint tbl_hotel_facility_fk_02 foreign key(facility_id) references spring_db.tbl_facility(facility_id)
);
-- hotel facility table

-- room table
create table spring_db.tbl_room (
room_id bigint auto_increment primary key,
room_code varchar(50) not null unique,
room_type_id integer not null,
no_of_beds integer not null,
no_of_persons integer not null,
hotel_id bigint not null,
comments varchar(500),
constraint tbl_room_fk_01 foreign key(hotel_id) references spring_db.tbl_hotel(hotel_id),
constraint tbl_room_fk_02 foreign key(room_type_id) references spring_db.tbl_room_type(room_type_id)
);
-- room table

-- designation table
create table spring_db.tbl_designation (
designation_id integer auto_increment primary key,
designation varchar(50) not null unique,
created_by_admin_id bigint,
created_by_superadmin_id bigint,
created_date datetime not null,
constraint tbl_designation_fk_01 foreign key(created_by_admin_id) references spring_db.tbl_admin(admin_id),
constraint tbl_designation_fk_02 foreign key(created_by_superadmin_id) references spring_db.tbl_super_admin(super_admin_id)
);
-- designation table

-- staff table
create table spring_db.tbl_staff (
staff_id bigint auto_increment primary key,
staff_code varchar(50) not null unique,
first_name varchar(100),
last_name varchar(100),
designation_id integer not null,
date_of_birth date not null,
address varchar(500) not null,
date_of_joining date not null,
gender varchar(10) not null,
mobile_number varchar(20) not null unique,
email_id varchar(50) not null unique,
age integer not null,
user_name varchar(50) not null unique,
password varchar(50) not null,
is_active_user tinyint not null,
created_date datetime not null,
modified_date datetime not null,
admin_id bigint not null,
constraint tbl_staff_fk_01 foreign key(admin_id) references spring_db.tbl_admin(admin_id)
);
-- staff table
 
-- blocked room table creation
create table spring_db.tbl_blocked_room (
blocked_id bigint auto_increment primary key,
from_date datetime not null,
to_date datetime not null,
room_status_id bigint not null,
room_id bigint not null,
created_date bigint not null,
is_deleted tinyint not null,
blocked_by_staff_id bigint,
blocked_by_admin_id bigint,
constraint tbl_blocked_room_fk_01 foreign key(room_status_id) references spring_db.tbl_room_status(status_id),
constraint tbl_blocked_room_fk_02 foreign key(room_id) references spring_db.tbl_room(room_id),
constraint tbl_blocked_room_fk_03 foreign key(blocked_by_staff_id) references spring_db.tbl_staff(staff_id),
constraint tbl_blocked_room_fk_04 foreign key(blocked_by_admin_id) references spring_db.tbl_admin(admin_id)
);
-- blocked room table creation

-- booked room table
create table spring_db.tbl_booked_room (
booking_id bigint auto_increment primary key,
booking_code varchar(50) not null unique,
booking_from_date datetime not null,
booking_to_date datetime not null,
room_id bigint not null,
customer_id bigint not null,
check_in_time datetime,
check_out_time datetime,
no_of_persons smallint not null,
no_of_men smallint not null,
no_of_women smallint not null,
booking_flag varchar(50) not null,
booked_date datetime not null,
booked_by_staff_id bigint,
booked_by_admin_id bigint,
constraint tbl_booked_room_fk_01 foreign key(room_id) references spring_db.tbl_room(room_id),
constraint tbl_booked_room_fk_02 foreign key(customer_id) references spring_db.tbl_customer(customer_id),
constraint tbl_booked_room_fk_03 foreign key(booked_by_staff_id) references spring_db.tbl_staff(staff_id),
constraint tbl_booked_room_fk_04 foreign key(booked_by_admin_id) references spring_db.tbl_admin(admin_id)
);
-- booked room table

-- image table
create table spring_db.tbl_image (
image_id bigint auto_increment primary key,
image_path varchar(200) not null,
file_extension varchar(20) not null,
image_size double not null,
mime_type varchar(50) not null,
created_date datetime not null,
updated_date datetime not null,
original_file_name varchar(50) not null,
is_deleted tinyint not null,
image_type varchar(50) not null,
hotel_id bigint,
room_id bigint,
staff_id bigint,
customer_id bigint
);
-- image table

-- payment details
create table spring_db.tbl_payment_details (
payment_id bigint auto_increment primary key,
transaction_number varchar(100) not null unique,
payment_date datetime not null,
paid_amount decimal(19,2),
payment_type varchar(50) not null,
card_number varchar(50),
expiry_date varchar(10),
cgst decimal(19,2),
sgst decimal(19,2),
other_charges decimal(19,2),
room_charges decimal(19,2),
discount_amount decimal(19,2),
food_charges decimal(19,2),
grand_total decimal(19,2),
sub_total decimal(19,2),
booking_id bigint not null,
constraint tbl_payment_details_fk_01 foreign key(booking_id) references spring_db.tbl_booked_room(booking_id)
);
-- payment details

-- payment type table
create table spring_db.tbl_payment_type (
payment_type_id smallint auto_increment primary key,
payment_type varchar(50) not null unique
);
-- payment type table

-- hotel payment type
create table spring_db.tbl_hotel_payment_type (
hotel_id bigint not null,
payment_type_id smallint not null,
constraint tbl_hotel_payment_type_fk_01 foreign key(hotel_id) references spring_db.tbl_hotel(hotel_id),
constraint tbl_hotel_payment_type_fk_02 foreign key(payment_type_id) references spring_db.tbl_payment_type(payment_type_id)
);
-- hotel payment type