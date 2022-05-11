Drop table if exists inventory;

create table inventory as select * from CSVREAD('~/Downloads/Application/Inventory-app/src/main/resources/init_data.csv');
