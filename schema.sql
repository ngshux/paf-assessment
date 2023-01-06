drop database if exists eshop;
create database eshop;
use eshop;

create table customers(
	name varchar(32) not null,
	address varchar(128) not null,
    email varchar(128) not null,
    
    primary key(name)
);

insert into customers (name, address, email)
values 
('fred',' 201 Cobblestone Lane',' fredflintstone@bedrock.com'),
('sherlock',' 221B Baker Street, London',' sherlock@consultingdetective.org'),
('spongebob',' 124 Conch Street, Bikini Bottom',' spongebob@yahoo.com'),
('jessica',' 698 Candlewood Land, Cabot Cove',' fletcher@gmail.com'),
('dursley',' 4 Privet Drive, Little Whinging, Surrey',' dursley@gmail.com')
;

create table orders(
    order_id char(8) not null,
    delivery_id varchar(128),
    customer_name varchar(32) not null,
    order_date date not null, 
    status text not null, 
    
	primary key(order_id),
    constraint fk_customer_name
		foreign key(customer_name) references customers(name)
);

create table lineitems (
    lineitem_id int auto_increment not null,
    item text not null,
    quantity int default '1',
    order_id char(8) not null,
    
    primary key(lineitem_id),
	constraint fk_item_id
        foreign key(order_id) references orders(order_id)
);

create table order_status(
    order_id char(8) not null,
    delivery_id varchar(128),
    status text not null,
    status_update date not null,

    primary key(order_id),
    constraint fk_order_id
		foreign key(order_id) references orders(order_id)
);