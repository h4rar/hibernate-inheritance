DROP TABLE if exists mapped_super_class_physical_person, mapped_super_class_legal_entity;

create table mapped_super_class_physical_person
(
    id                       uuid         not null
        primary key,
    inn                      varchar(20)  not null,
    nationality_country_code varchar(255) not null
);
create table mapped_super_class_legal_entity
(
    id   uuid         not null
        primary key,
    inn  varchar(20)  not null,
    ogrn varchar(255) not null
);
