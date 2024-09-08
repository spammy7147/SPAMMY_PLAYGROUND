CREATE TABLE accommodation_temp (
   user_id NUMBER PRIMARY KEY ,
   name VARCHAR2(50),
   address VARCHAR2(200),
   type VARCHAR2(20),
   max_number_guest NUMBER,
   number_bedroom NUMBER,
   number_bed NUMBER,
   number_bathroom NUMBER,
   contact_number NUMBER,
   price NUMBER,
   description VARCHAR2(1000)
);

ALTER TABLE accommodation_temp
    ADD CONSTRAINT FK_accommodation_temp
        FOREIGN KEY (user_id)
            REFERENCES air_user (user_id)
                ON DELETE CASCADE;