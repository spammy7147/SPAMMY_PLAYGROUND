CREATE TABLE QNA(
  qna_no number(10) PRIMARY KEY,
  id VARCHAR2(20),
  title VARCHAR2(100),
  content VARCHAR2(300),
  save_date date default sysdate,
  hit number(10) default 0,
  image_file_name VARCHAR2(100)
);
CREATE SEQUENCE qna_seq
START WITH 1
INCREMENT BY 1;