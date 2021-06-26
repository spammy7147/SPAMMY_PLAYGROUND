CREATE TABLE accommodation_photo(
    accommodation_id NUMBER PRIMARY KEY,
    photo_URL VARCHAR2(1000) NOT NULL,
    reg_date TIMESTAMP DEFAULT SYSDATE
);
ALTER TABLE accommodation_photo
    ADD CONSTRAINT FK_accommodation_photo
        FOREIGN KEY (accommodation_id)
            REFERENCES accommodation (accommodation_id)
                ON DELETE CASCADE;