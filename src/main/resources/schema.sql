DROP TABLE IF EXISTS entities;

CREATE TABLE entities
(
    id     bigint AUTO_INCREMENT,
    name   varchar(32) NOT NULL,
    status integer     NOT NULL
);

ALTER TABLE entities
    ADD CONSTRAINT entities_pkey PRIMARY KEY (id);
