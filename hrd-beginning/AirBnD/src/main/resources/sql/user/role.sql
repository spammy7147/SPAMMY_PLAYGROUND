CREATE TABLE air_role
(
    user_id       NUMBER          NOT NULL, --FK
    role          VARCHAR(20)     NOT NULL
);

ALTER TABLE air_role
    ADD CONSTRAINT FK_role
        FOREIGN KEY (user_id)
            REFERENCES air_user (user_id)
                ON DELETE CASCADE;
