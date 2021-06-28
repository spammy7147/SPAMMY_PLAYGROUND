CREATE TABLE reservation (
    reservation_id NUMBER PRIMARY KEY,
   accommodation_id NUMBER NOT NULL,
   user_id NUMBER NOT NULL,
   number_guest NUMBER NOT NULL,
   check_in TIMESTAMP NOT NULL,
   check_out TIMESTAMP NOT NULL,
   reg_date TIMESTAMP DEFAULT SYSDATE
);
CREATE SEQUENCE reservation_seq
    START WITH 1
    INCREMENT by 1
    MAXVALUE 10000
    MINVALUE 1
    NOCYCLE;

ALTER TABLE reservation
    ADD CONSTRAINT FK_reservation_user
        FOREIGN KEY (user_id)
            REFERENCES air_user (user_id)
                ON DELETE CASCADE;

ALTER TABLE reservation
    ADD CONSTRAINT FK_reservation_accommodation
        FOREIGN KEY (accommodation_id)
            REFERENCES accommodation (accommodation_id)
                ON DELETE CASCADE;