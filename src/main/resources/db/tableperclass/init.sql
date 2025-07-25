DROP TABLE if exists table_per_class_member_base_entity, table_per_class_physical_person, table_per_class_legal_entity;
create table table_per_class_member_base_entity
(
    id                       uuid         not null
        primary key,
    inn                      varchar(20)  not null
);

create table table_per_class_physical_person
(
    id                       uuid         not null
        primary key,
    inn                      varchar(20)  not null,
    nationality_country_code varchar(255) not null
);

create table table_per_class_legal_entity
(
    id   uuid         not null
        primary key,
    inn  varchar(20)  not null,
    ogrn varchar(255) not null
);
