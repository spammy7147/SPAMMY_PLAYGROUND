CREATE TABLE air_user_photo(
    user_id NUMBER PRIMARY KEY,
    photo_URL VARCHAR2(1000) NOT NULL,
    reg_date TIMESTAMP DEFAULT SYSDATE
);
ALTER TABLE air_user_photo
    ADD CONSTRAINT FK_user_photo
        FOREIGN KEY (user_id)
            REFERENCES air_user (user_id)
                ON DELETE CASCADE;