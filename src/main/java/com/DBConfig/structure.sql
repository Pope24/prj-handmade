USE [master]
GO
ALTER DATABASE handmade SET  SINGLE_USER WITH ROLLBACK IMMEDIATE
GO

USE [master]
GO

DROP DATABASE handmade
GO

create database handmade;
use handmade;
create table products (
	id int identity(1, 1) primary key,
	name nchar(200) not null,
	price bigint,
	amount int,
	description nchar,
	p_type int,
	p_brand int,
	isActived bit,
	id_user int,
	create_on datetime
	constraint FK_Product_User foreign key (id_user) references users(id_user)
)
create table image_product (
	id int identity(1,1) primary key,
	link_image char(1000),
	id_product int,
	constraint fk_id_image_item foreign key(id_product) references products(id),
)
create table users(
	id_user int identity(1, 1) primary key,
	full_name nchar(50) not null,
	phone_number char(11) not null unique,
	email char(100) not null unique,
	identity_card char(20) not null unique,
	address nchar(200),
	gender tinyint,
	avatar nchar(1000),
	created_on datetime
)
create table account(
	id_user int primary key,
	username char(50) not null unique,
	password char(100) not null,
	is_actived bit not null,
	acc_role int not null,
	constraint fk_id_user_account foreign key(id_user) references users(id_user),
)
create table reviews (
	id int identity(1, 1) primary key,
	content nchar,
	created_on datetime,
	id_user int,
	id_product int,
	constraint fk_id_item_review foreign key(id_product) references products(id),
	constraint fk_id_user_reviews foreign key(id_user) references users(id_user)
)
create table vouchers (
	id int identity(1,1) primary key,
	name nchar(200),
	effective_to datetime,
	effective_from datetime,
	per_discount int,
	content nchar,
	quantity int,
	created_on datetime
)
create table order_product (
	id int identity(1,1) primary key,
	order_date datetime,
	order_status nchar(50),
	payment_status nchar(50),
	total_money decimal(12, 0),
	city nchar(200),
	district nchar(200),
	ward nchar(200),
	number_apartment nchar(200),
	order_note nchar(1000),
	id_user int,
	id_voucher int,
	constraint fk_id_user_order foreign key(id_user) references users(id_user),
	constraint fk_id_voucher_order foreign key(id_voucher) references vouchers(id)
)
create table order_detail (
	id int identity(1,1) primary key,
	quantity int,
	id_order int,
	id_product int,
	CONSTRAINT fk_id_item_detail_order FOREIGN KEY(id_product) REFERENCES products(id),
	CONSTRAINT fk_id_order_detail_order FOREIGN KEY(id_order) REFERENCES order_product(id)
)