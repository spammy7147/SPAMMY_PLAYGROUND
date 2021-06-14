create table air_board(
	Write_no number(10) primary key,
	email varchar2(50),
	Title varchar2(100),
	Content varchar2(500),
	Savedate date default sysdate,
	Hit number(10) default 0
);
create sequence air_board_seq;    