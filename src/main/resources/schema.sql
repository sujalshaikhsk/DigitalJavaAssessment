create table customers (customer_id varchar(255) not null, first_name varchar(255), gender varchar(255), last_name varchar(255), primary key (customer_id));

create table accounts (account_number bigint not null, account_type varchar(255), customer_id varchar(255) not null, primary key (account_number));

alter table accounts add constraint FKn6x8pdp50os8bq5rbb792upse foreign key (customer_id) references customers;


