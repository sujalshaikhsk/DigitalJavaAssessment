create table customers (customer_id varchar(255) not null, title varchar(255), first_name varchar(255), gender varchar(255), last_name varchar(255), primary key (customer_id));

create table accounts (account_no varchar(255) not null, balance double, bsb varchar(255), name varchar(255), customer_id varchar(255) not null, primary key (account_no));

alter table accounts add constraint FKn6x8pdp50os8bq5rbb792upse foreign key (customer_id) references customers;