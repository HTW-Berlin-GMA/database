create table user (
                      userid integer not null,
                      name varchar(64) not null,
                      password varchar(256) not null);

insert into user (userid, name, password) values (1, 'dokriseum', '123456');

commit;

select * from user;