Drop table if exists catalog;

create table catalog as select * from CSVREAD('~/Downloads/Application/Catalog-app/src/main/resources/init_data.csv');