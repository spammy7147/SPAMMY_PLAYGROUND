CREATE TABLE reservation (
    reservation_id NUMBER PRIMARY KEY,
   hosting_id NUMBER NOT NULL,
   user_id NUMBER NOT NULL,
   number_guest NUMBER NOT NULL,
   check_in TIMESTAMP NOT NULL,
   check_out TIMESTAMP NOT NULL,
   reg_date TIMESTAMP DEFAULT SYSDATE
);
ALTER TABLE reservation
    ADD CONSTRAINT FK_reservation_user
        FOREIGN KEY (user_id)
            REFERENCES air_user (user_id)
                ON DELETE CASCADE;

ALTER TABLE reservation
    ADD CONSTRAINT FK_reservation_accommodation
        FOREIGN KEY (user_id)
            REFERENCES accommodation (accommodation_id)
                ON DELETE CASCADE;