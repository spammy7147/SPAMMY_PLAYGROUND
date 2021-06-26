CREATE TABLE accommodation (
    accommodation_id NUMBER PRIMARY KEY,
    user_id NUMBER NOT NULL,
    name VARCHAR2(50) NOT NULL ,
    address VARCHAR2(200) NOT NULL,
    type VARCHAR2(20) NOT NULL,
    max_number_guest NUMBER NOT NULL,
    number_bedroom NUMBER NULL,
    number_bed NUMBER,
    number_bathroom NUMBER NOT NULL,
    contact_number NUMBER NOT NULL,
    price NUMBER NOT NULL,
    description VARCHAR2(1000),
    reg_date TIMESTAMP DEFAULT SYSDATE
);

CREATE SEQUENCE accommodation_seq
    START WITH 1
    INCREMENT by 1
    MAXVALUE 10000
    MINVALUE 1
    NOCYCLE;

ALTER TABLE accommodation
    ADD CONSTRAINT FK_accommodation
        FOREIGN KEY (user_id)
            REFERENCES air_user (user_id)
                ON DELETE CASCADE;