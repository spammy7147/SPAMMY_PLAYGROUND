SHOW DATABASES;
use article;

create table article (
                         article_id bigint not null primary key,
                         title varchar(100) not null,
                         content varchar(3000) not null,
                         board_id bigint not null,
                         writer_id bigint not null,
                         created_at datetime not null,
                         modified_at datetime not null
);

SELECT COUNT(1) FROM article;

create index idx_board_id_article_id on article(board_id asc,
                                                article_id desc);