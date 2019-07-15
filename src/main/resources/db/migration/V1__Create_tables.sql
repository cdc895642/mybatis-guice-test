drop table if exists USERS;
create table USERS (
    user_id varchar(80) not null,
    user_name varchar(80) not null,
balance int not null,
    constraint pk_user primary key (user_id)
);