CREATE sequence IF NOT EXISTS entities_id_seq;

CREATE TABLE IF NOT EXISTS entities
(
    id      bigint      NOT NULL DEFAULT entities_id_seq.nextval,
    name    varchar(32) NOT NULL,
    status  integer     NOT NULL
);

ALTER TABLE IF EXISTS entities ADD CONSTRAINT IF NOT EXISTS entities_pkey PRIMARY KEY (id);