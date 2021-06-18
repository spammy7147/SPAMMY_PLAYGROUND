CREATE TABLE air_user
(
    user_id       NUMBER          PRIMARY KEY,
    email         VARCHAR2(50)    UNIQUE NOT NULL ,
    password      VARCHAR2(200)    NOT NULL,
    name          VARCHAR2(20)    NOT NULL, 
    birth         DATE            NULL,
    phone         NUMBER          NULL,
    isAccountLocked NUMBER(1,0),
    reg_date       TIMESTAMP      DEFAULT SYSDATE
    );

CREATE SEQUENCE air_user_seq
  START WITH 1
  INCREMENT by 1
  MAXVALUE 10000
  MINVALUE 1
  NOCYCLE;


ALTER TABLE air_role
    ADD CONSTRAINT FK_role
        FOREIGN KEY (user_id)
            REFERENCES air_user (user_id);

ALTER TABLE hosting
    ADD CONSTRAINT FK_hosting
        FOREIGN KEY (user_id)
            REFERENCES air_user (user_id);