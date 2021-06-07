DROP TABLE HMEMBER_LIST;

CREATE TABLE HMEMBER_LIST(
    EJ_HMNUM VARCHAR2(13) NOT NULL -- 히스토리 번호
	, EJ_MNUM VARCHAR2(20) PRIMARY KEY -- 회원번호
	, EJ_MID VARCHAR2(20) NOT NULL --  아이디
	, EJ_MPW VARCHAR2(256) NOT NULL --  비밀번호
    , EJ_MNAME VARCHAR2(30) NOT NULL -- 이름
    , EJ_MPHONE VARCHAR2(13) NOT NULL --핸드폰 번호
    , EJ_MADDR0 VARCHAR2(6) NOT NULL --  우편번호
    , EJ_MADDR1 VARCHAR2(200) NOT NULL --  주소
    , EJ_MADDR2 VARCHAR2(100) NOT NULL --  상세주소
    , EJ_MEMAIL VARCHAR2(256) NOT NULL -- 이메일
    , EJ_MDELYN VARCHAR2(1) NOT NULL --  삭제여부
    , EJ_MREGDATE DATE NOT NULL --  회원 등록일
    , EJ_MINDATE DATE  --  데이터 등록일
    , EJ_MUPDATE DATE  -- 데이터 수정일
    , EJ_MADMIN VARCHAR2(1) NOT NULL --  관리자 여부
	);
    


CREATE TABLE REG_DB(
    EJ_REGCODE VARCHAR2(10) NOT NULL
    ,EJ_REGNAME VARCHAR2(150) 
    ,EJ_REGEXIST VARCHAR2(6)
    );

CREATE TABLE GENERAL_GOODS(
    EJ_GNUM VARCHAR2(13) NOT NULL
    ,EJ_GSORT VARCHAR2(1) NOT NULL 
    ,EJ_GTITLE VARCHAR2(120)
    ,EJ_GLOC VARCHAR2(100)
    ,EJ_GPHOTO VARCHAR2(256)
    ,EJ_GPRICE VARCHAR2(10)
    ,EJ_GCONTENTS VARCHAR2(3000)
    ,EJ_GSTATUS VARCHAR2(1) NOT NULL
    ,EJ_GDELYN VARCHAR2(1) NOT NULL
    ,EJ_GREGDATE DATE
    ,EJ_GUPDATE DATE
    ,EJ_GROUPSIZE VARCHAR2(1)
    ,EJ_PAGESIZE VARCHAR2(1)
    ,EJ_CURPAGE VARCHAR2(1)
    ,EJ_TOTALCOUNT VARCHAR2(1)
    ,EJ_MNUM VARCHAR2(13) NOT NULL
    ,EJ_CGNUM VARCHAR2(4) NOT NULL
    );
DROP TABLE CATEGORY_LIST;

CREATE TABLE CATEGORY_LIST1(
    EJ_DNUM VARCHAR2(13) NOT NULL
    ,EJ_DDATE DATE
    ,EJ_MNUM VARCHAR2(13) -- FK
    ,EJ_GNUM VARCHAR2(13)  -- FK
    );
    
 CREATE TABLE CATEGORY_LIST2(
    EJ_CGNUM VARCHAR2(4) NOT NULL
    ,EJ_CGNAME VARCHAR2(60)
    );
    
CREATE TABLE PICK_LIST(
    EJ_PNUM VARCHAR(13) NOT NULL
    ,EJ_PDATE DATE
    ,EJ_PDELYN VARCHAR2(1) NOT NULL
    ,EJ_GNUM VARCHAR2(13) NOT NULL --FK
    ,EJ_MNUM VARCHAR2(13) NOT NULL  --FK
    ,EJ_ANUM VARCHAR2(13) NOT NULL  --FK
    );

CREATE TABLE MEMBER_LIST(
    EJ_MNUM VARCHAR2(13) PRIMARY KEY -- 히스토리 번호
	, EJ_MID VARCHAR2(20) NOT NULL --  아이디
	, EJ_MPW VARCHAR2(256) NOT NULL --  비밀번호
    , EJ_MNAME VARCHAR2(30) NOT NULL -- 이름
    , EJ_MPHONE VARCHAR2(13) NOT NULL --핸드폰 번호
    , EJ_MADDR0 VARCHAR2(6) NOT NULL --  우편번호
    , EJ_MADDR1 VARCHAR2(200) NOT NULL --  주소
    , EJ_MADDR2 VARCHAR2(100) NOT NULL --  상세주소
    , EJ_MEMAIL VARCHAR2(256) NOT NULL -- 이메일
    , EJ_MDELYN VARCHAR2(1) NOT NULL --  삭제여부
    , EJ_MREGDATE DATE NOT NULL --  회원 등록일
    , EJ_MINDATE DATE  --  데이터 등록일
    , EJ_MUPDATE DATE  -- 데이터 수정일
    , EJ_MADMIN VARCHAR2(1) NOT NULL --  관리자 여부
	);
    

SELECT * FROM HMEMBER_LIST;
SELECT * FROM REG_DB;
SELECT * FROM GENERAL_GOODS;
SELECT * FROM CATEGORY_LIST1;
SELECT * FROM CATEGORY_LIST2;
SELECT * FROM PICK_LIST;
SELECT * FROM MEMBER_LIST;

COMMIT;