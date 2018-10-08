/* 문제 */
DROP TABLE tb_quest 
	CASCADE CONSTRAINTS;

/* 회원정보 */
DROP TABLE tb_user 
	CASCADE CONSTRAINTS;

/* 채점 및 분석 */
DROP TABLE tb_result 
	CASCADE CONSTRAINTS;

/* 오답노트 */
DROP TABLE tb_error 
	CASCADE CONSTRAINTS;

/* 공지사항 */
DROP TABLE tb_notice 
	CASCADE CONSTRAINTS;

/* 문제 */
CREATE TABLE tb_quest (
	qno NUMBER(5) NOT NULL, /* 문제번호 */
	sub VARCHAR2(20), /* 과목번호 */
	quest VARCHAR2(2000), /* 문제+보기 */
	ans NUMBER(1), /* 답 */
	exp VARCHAR2(2000), /* 해설 */
	keywd VARCHAR2(20), /* 키워드 */
	inans VARCHAR2(20) /* 오답률 */
);

CREATE UNIQUE INDEX PK_tb_quest
	ON tb_quest (
		qno ASC
	);

ALTER TABLE tb_quest
	ADD
		CONSTRAINT PK_tb_quest
		PRIMARY KEY (
			qno
		);

/* 회원정보 */
CREATE TABLE tb_user (
	userid VARCHAR2(20) NOT NULL, /* ID */
	pwd VARCHAR2(50), /* 비밀번호 */
	manager NUMBER(5) /* 관리자 */
);

CREATE UNIQUE INDEX PK_tb_user
	ON tb_user (
		userid ASC
	);

ALTER TABLE tb_user
	ADD
		CONSTRAINT PK_tb_user
		PRIMARY KEY (
			userid
		);

/* 채점 및 분석 */
CREATE TABLE tb_result (
	userid VARCHAR2(20) NOT NULL, /* ID */
	COL NUMBER(5), /* 분석번호 */
	sub1 number(3), /* 1과목점수 */
	sub2 number(3), /* 2과목점수 */
	sub3 number(3), /* 3과목점수 */
	sub4 number(3), /* 4과목점수 */
	sub5 number(3), /* 5과목점수 */
	avg number(3), /* 평균점수 */
	testdt VARCHAR2(20) /* 시험일자 */
);

CREATE UNIQUE INDEX PK_tb_result
	ON tb_result (
		userid ASC
	);

ALTER TABLE tb_result
	ADD
		CONSTRAINT PK_tb_result
		PRIMARY KEY (
			userid
		);

/* 오답노트 */
CREATE TABLE tb_error (
	qno NUMBER(5) NOT NULL, /* 문제번호 */
	userid VARCHAR2(20), /* ID */
	e_ans NUMBER(5), /* 푼답 */
	ecount NUMBER(5) /* 틀린횟수 */
);

CREATE UNIQUE INDEX PK_tb_error
	ON tb_error (
		qno ASC
	);

ALTER TABLE tb_error
	ADD
		CONSTRAINT PK_tb_error
		PRIMARY KEY (
			qno
		);

/* 공지사항 */
CREATE TABLE tb_notice (
	nno NUMBER(5) NOT NULL, /* 공지번호 */
	title VARCHAR2(50), /* 제목 */
	cont VARCHAR2(255), /* 내용 */
	regdt VARCHAR2(20), /* 등록일자 */
	userid VARCHAR2(20) /* ID */
);

CREATE UNIQUE INDEX PK_tb_notice
	ON tb_notice (
		nno ASC
	);

ALTER TABLE tb_notice
	ADD
		CONSTRAINT PK_tb_notice
		PRIMARY KEY (
			nno
		);

ALTER TABLE tb_result
	ADD
		CONSTRAINT FK_tb_user_TO_tb_result
		FOREIGN KEY (
			userid
		)
		REFERENCES tb_user (
			userid
		);

ALTER TABLE tb_error
	ADD
		CONSTRAINT FK_tb_quest_TO_tb_error
		FOREIGN KEY (
			qno
		)
		REFERENCES tb_quest (
			qno
		);

ALTER TABLE tb_notice
	ADD
		CONSTRAINT FK_tb_user_TO_tb_notice
		FOREIGN KEY (
			userid
		)
		REFERENCES tb_user (
			userid
		);
		

		
drop sequence quest_esq;
drop sequence notice_seq;
		
create sequence quest_seq_2;
create sequence notice_seq_2;

insert into tb_user values('admin','admin',1)


insert into tb_quest values(quest_seq.nextval, 
1, 
'관계해석에 대한 설명으로 옳지 않은 것은?
① 수학의 프레디킷 해석에 기반을 두고 있다.
② 관계 데이터 모델의 제안자인 코드(Codd)가 관계 데이터베이스에 적용할 수 있도록 설계하여 제안하였다.
③ 튜플 관계해석과 도메인 관계해석이 있다.
④ 원하는 정보와 그 정보를 어떻게 유도하는가를 기술하는 절차적 특성을 가진다.', 
4, 
'4번은 관계대수에 대한 설명입니다.
관계해석- E.F.Codd 코드가 수학의 Predicate프레디켓 calculus 에 기반을 두고 제안했다-비절차적 특성을 지닌다-튜플관계해석과 도메인 관계해석이 있다-계산 수식을 사용해 어떤 데이터를 가져올지 명시@관계해석과 관계대수는 관계 데이터베이스를 처리하는 기능과 능력면에서 동등하다', 
'관계해석',
 0)
 
 
 
insert into tb_quest values(quest_seq.nextval, 
1, 
'색인 순차 파일에 대한 설명으로 옳지 않은 것은?
① 레코드를 참조할 때 색인을 탐색한 후 색인이 가리키는 포인터를 사용하여 직접 참조할 수 있다.
② 레코드를 추가 및 삽입하는 경우, 파일 전체를 복사할 필요가 없다.
③ 인덱스를 저장하기 위한 공간과 오버플로우 처리를 위한 별도의 공간이 필요 없다.
④ 색인 구역은 트랙 색인 구역, 실린더 색인 구역, 마스터 색인 구역으로 구성된다.', 
3, 
'색인 순차 파일은 인덱스를 저장하기 위한 공간과 오버플로우 처리를 위한 별도의 공간이 필요하기 때문에 공간 효율성은 떨어지는 편입니다.', 
'색인 순차 파일',
 0)

insert into tb_quest values(quest_seq.nextval, 
1, 
'뷰(VIEW)에 대한 설명으로 옳지 않은 것은?
① DBA는 보안 측면에서 뷰를 활용할 수 있다.
② 뷰 위에 또 다른 뷰를 정의할 수 있다.
③ 뷰에 대한 삽입, 갱신, 삭제 연산 시 제약 사항이 따르지 않는다.
④ 뷰의 정의는 ALTER문을 이용하여 변경할 수 없다.', 
3, 
'뷰로 구성된 내용에 따라 삽입,삭제, 갱신 연산 제한', 
'뷰',
 0)
select * from tab;
select * from tb_quest;
select * from tb_user;
select * from tb_error;

insert into tb_error values('f',3,2,1);

update tb_error set ecount = ecount+1 where qno = 1
delete from tb_error where qno = 2
delete from tb_error where qno = 3
select * from tb_error where qno = 4
commit