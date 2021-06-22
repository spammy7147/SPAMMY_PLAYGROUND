create table QnAreply(
email varchar(20),
title varchar(50),
content varchar(300),
write_group number(10),
write_date date default sysdate,
constraint qna_rep_test foreign key(write_group) references QNA(qna_no) on delete cascade
);