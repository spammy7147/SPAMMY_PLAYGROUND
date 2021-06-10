  CREATE TABLE house
(
    house_id    NUMBER          NULL PRIMARY KEY, 
    region      VARCHAR2(20)    NULL, 
    name        VARCHAR2(20)    NULL, 
    price       NUMBER          NULL, 
    content     VARCHAR2(20)    NULL, 
    hit         NUMBER          NULL 
);

 
CREATE SEQUENCE house_SEQ
START WITH 1
INCREMENT BY 1;