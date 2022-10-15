create Database userinfo;
use userinfo;


create table userInfo(
	userId varchar(13) not null,
	userName varchar(5) not null,
    userPw varchar(15) not null,
    userAddr varchar(20),
    singUpDate timestamp,
    primary key (userId)
);

-- alter table userInfo add 추가할 컬럼


insert into userInfo values('1000bang', '천병재', 'asdf123', '부산시 수영구', now());
insert into userInfo values('ji_euni', '이지은', 'asd1234', '부산시 북구', now());

select * from userInfo;
