create table QnAreply(
email varchar(20),
content varchar(300),
write_group number(10),
write_date date default sysdate,
constraint qna_rep_test foreign key(write_group) references QNA(qna_no) on delete cascade
);

ALTER TABLE QNAREPLY
    ADD CONSTRAINT FK_QNA_reply
    FOREIGN KEY (email)
    REFERENCES air_user (email)
    ON DELETE CASCADE;


ALTER TABLE QNAREPLY
    ADD CONSTRAINT FK_QNA_group
    FOREIGN KEY (write_group)
    REFERENCES QNA (qna_no)
    ON DELETE CASCADE;