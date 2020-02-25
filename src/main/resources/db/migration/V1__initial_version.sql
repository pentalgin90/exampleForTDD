create sequence hibernate_sequence start 1 increment 1;

CREATE TABLE car (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    model varchar(50) NOT NULL,
    manufacturer varchar(50) NOT NULL,
    PRIMARY KEY (id)
);