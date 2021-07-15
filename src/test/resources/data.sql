-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (1, '홍길동','spammy0@gmail.com',now(),now());

-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (2, '김뽀삐','spammy1@gmail.com',now(),now());

-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (3, '김길동','spammy2@gmail.com',now(),now());

-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (4, '덕배','spammy3@gmail.com',now(),now());

-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (5, '김춘배','spammy4@gmail.com',now(),now());

-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (6, '갑수','spammy5@gmail.com',now(),now());

insert into publisher (`id`,`name`) values (1, '인텔리제이');

insert into book(`id`, `name`, `publisher_id`,`deleted`,`status`) values (1,'JPA CASCADE 공부', 1, false, 100);

insert into book(`id`, `name`, `publisher_id`,`deleted`,`status`) values (2,'JPA 공부중!!!', 1, false, 200);

insert into book(`id`, `name`, `publisher_id`,`deleted`,`status`) values (3,'JPA DELETE 현업사용?', 1, true, 100);

