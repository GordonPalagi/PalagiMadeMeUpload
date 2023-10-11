drop table if exists image;
drop table if exists user;
create table image (
    date_submitted datetime(6),
    time_submitted datetime(6),
    id varchar(36) not null,
    title varchar(50) not null,
    description varchar(255) not null,
    image_bytes varbinary(255) not null,
    primary key (id)
    ) engine=InnoDB;

create table user (
    version integer,
    id varchar(36) not null,
    bio varchar(255),
    name varchar(255) not null,
    primary key (id)
    ) engine=InnoDB;
