DROP TABLE if exists single_table_member_base;


create table single_table_member_base
(
    id                       uuid         not null
        primary key,
    D_TYPE                  varchar(2),
    inn                      varchar(20)  not null,
    ogrn                     varchar(255),
    nationality_country_code varchar(255)
);
