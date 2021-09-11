drop database order_db;

create schema order_db;
use Order_db;
drop table orderTable;

create table ordertable(
	
	
orderid int auto_increment  NOT NULL primary key,
	
	
buyerid int not null,
	
	
amount decimal(6,2) not null,
	
	dateoforder datetime not null,
	
	address varchar(50) not null,
	
statusValue int not null,
	
check (statusValue in (1,2,3))

);


insert into ordertable (buyerid, amount, dateoforder, address, status) values( 1, 399, '2020/10/02','Jaipur',1);

insert into ordertable (buyerid, amount, dateoforder, address, status) values( 1, 399, now(),'Jaipur',1);


select * from ordertable;