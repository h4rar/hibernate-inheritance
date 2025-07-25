DROP TABLE if exists joined_table_legal_member_base, joined_table_physical_persons, joined_table_legal_entity;

create table joined_table_legal_member_base
(
    id  uuid        not null
        primary key,
    inn varchar(20) not null
);

create table joined_table_physical_persons
(
    id                       uuid         not null
        primary key
        constraint physical_persons_id_fk
            references joined_table_legal_member_base,
    nationality_country_code varchar(255) not null
);

create table joined_table_legal_entity
(
    id   uuid         not null
        primary key
        constraint legal_entity_details_id_fk
            references joined_table_legal_member_base,
    ogrn varchar(255) not null
);
