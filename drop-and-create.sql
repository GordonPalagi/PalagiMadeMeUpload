drop table if exists image;
drop table if exists user;
create table image (
    date_submitted datetime(6),
    time_submitted datetime(6),
    id varchar(36) not null,
    title varchar(50) not null,
    description varchar(255) not null,
    image varbinary(255) not null,
    primary key (id)
) engine=InnoDB;

create table user (
    id varchar(36) not null,
    name varchar(255) not null,
    primary key (id)
) engine=InnoDB;
