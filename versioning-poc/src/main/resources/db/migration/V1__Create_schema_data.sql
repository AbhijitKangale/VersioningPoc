CREATE TABLE managed_db (
    id uuid NOT NULL,
    name character varying(30) NOT NULL,
    user_id integer,
    type character varying(30),
    db_version character varying(30),
    user_id1 character varying(30)
);

ALTER TABLE ONLY managed_db
    ADD CONSTRAINT managed_db_id_pk PRIMARY KEY (id);
    
ALTER TABLE managed_db
    ADD CONSTRAINT uk_db_version UNIQUE (db_version);
    
INSERT INTO managed_db(id, name , user_id, type, db_version, user_id1) VALUES ('123e4567-e89b-12d3-a456-556642440000','personalDb','123','mysql', '5.7', '123');