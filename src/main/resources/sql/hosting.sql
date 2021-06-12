CREATE TABLE hosting_temp
(
    hosting_id    NUMBER          PRIMARY KEY,
    user_id       NUMBER          NOT NULL,
    address       VARCHAR2(50)    NOT NULL,
    type          VARCHAR2(20)    NOT NULL,
    phone         NUMBER          NULL,
    regdate       DATE            DEFAULT SYSDATE
);

CREATE SEQUENCE hosting_temp
    START WITH 1
    INCREMENT by 1
    MAXVALUE 10000
    MINVALUE 1
    NOCYCLE;
