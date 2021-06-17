CREATE TABLE hosting
(
    hosting_id    NUMBER          PRIMARY KEY,
    user_id       NUMBER          NOT NULL, -- FK
    address       VARCHAR2(50)    NOT NULL,
    type          VARCHAR2(20)    NOT NULL,
    phone         NUMBER          NULL,
    reg_date       DATE            DEFAULT SYSDATE
);

CREATE SEQUENCE hosting_temp
    START WITH 1
    INCREMENT by 1
    MAXVALUE 10000
    MINVALUE 1
    NOCYCLE;
