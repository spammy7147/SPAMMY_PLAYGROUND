create table persistent (
    user_id number primary key,
    key varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp(6) not null
);

ALTER TABLE persistent
    ADD CONSTRAINT FK_persistent
        FOREIGN KEY (user_id)
            REFERENCES air_user (user_id)
                ON DELETE CASCADE;