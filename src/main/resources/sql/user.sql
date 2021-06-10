CREATE TABLE member
(
    member_id     NUMBER             PRIMARY KEY,
    email         VARCHAR2(50)    UNIQUE,
    password      VARCHAR2(50)    NOT NULL,
    name          VARCHAR2(20)    NOT NULL, 
    birth         DATE            NULL,
    phone         NUMBER          NULL,
    regdate       DATE            DEFAULT SYSDATE
    );

CREATE SEQUENCE member_id_seq
  START WITH 1
  INCREMENT by 1
  MAXVALUE 10000
  MINVALUE 1
  NOCYCLE;
  