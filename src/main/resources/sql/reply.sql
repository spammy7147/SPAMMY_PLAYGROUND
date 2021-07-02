create table air_board_reply(
reply_num number(10),
writer varchar(20),
content varchar(300),
write_group number(10),
write_date date default sysdate,
constraint fk_rep foreign key(write_group) references air_board(write_no) on delete cascade
);

CREATE SEQUENCE air_board_reply_seq
START WITH 1
INCREMENT BY 1;


ALTER TABLE air_board_reply
    ADD CONSTRAINT FK_board_reply
    FOREIGN KEY (Writer)
    REFERENCES air_user (email)
    ON DELETE CASCADE;

ALTER TABLE air_board_reply
    ADD CONSTRAINT FK_board_group
    FOREIGN KEY (Write_group)
    REFERENCES air_board (write_no)
    ON DELETE CASCADE;