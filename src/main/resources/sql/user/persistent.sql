create table persistent (
    user_id number primary key,
    key varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp(6) not null
);

