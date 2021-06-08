-- 경매
DROP TABLE auction_goods;
CREATE TABLE auction_goods (
    anum       VARCHAR2(13) PRIMARY KEY,        -- 경매 상품번호
    asort      VARCHAR2(100) NOT NULL,       -- 경매 상품 구분(3: 경매)
    atitle     VARCHAR2(50) NOT NULL,       -- 경매 물건 제목
    aloc       VARCHAR2(100) NOT NULL,       -- 경매 물건 지역
    aphoto     VARCHAR2(256),       -- 경매 물건 사진
    arephoto   VARCHAR2(256),       -- 썸네일 사진
    apricemin  VARCHAR2(50),        -- 경매 최소 가격
    aendtime   TIMESTAMP NOT NULL,           -- 경매 물건 종료 시간
    acontents  VARCHAR2(500) NOT NULL,       -- 경매 상품 내용
    astatus    VARCHAR2(15) NOT NULL,        -- 경매 상품 상태
    adelyn     VARCHAR2(1) NOT NULL,         -- 삭제 여부
    aregdate   DATE NOT NULL,                -- 등록일
    aupdate    DATE NOT NULL,                -- 수정일
    mnum       VARCHAR2(13) NOT NULL,        -- 회원번호
    cgnum      VARCHAR2(13) NOT NULL        -- 카테고리 번호
);
INSERT INTO auction_goods (
        anum,
        asort,  -- 고정값 3
        atitle,
        aloc,
        aphoto,
        arephoto,
        apricemin,
        aendtime,
        acontents,
        astatus,    -- 고정값 1
        adelyn,     -- 고정값 '엔'
        aregdate,
        aupdate,
        mnum,
        cgnum
    )
VALUES (
                                   #{anum}                                  --경매상품번호        
                                  ,#{asort}                                 --상품 구분(3: 경매)
                                  ,#{atitle}                                --제목
                                  ,#{aloc}                                  --지역
                                  ,#{aphoto}                                --사진
                                  ,#{arephoto}                              --썸네일 사진    
                                  ,#{apricemin}                             --최소가격
                                  ,SYSTIMESTAMP+ TO_NUMBER(#{aendtime})/24  --종료시간 
                                  ,#{acontents}                             --상품내용
                                  ,#{astatus}                               --상품상태
                                  ,#{adelyn}                                --삭제여부
                                  ,SYSDATE                                  --등록일
                                  ,SYSDATE                                  --수정일
                                  ,#{mnum}                                  --회원번호
                                  ,#{cgnum}   
                                    );
                                    

 
 --- 회원가입 테이블
DROP TABLE MEMBER_LIST;
CREATE TABLE MEMBER_LIST(
      MNUM   VARCHAR2(13)    PRIMARY KEY    -- 회원 번호
     ,MID    VARCHAR2(20)    NOT NULL       -- 회원 아이디
     ,MPW    VARCHAR2(256)   NOT NULL       -- 회원 비밀번호
     ,MNAME  VARCHAR2(30)    NOT NULL       -- 회원 이름
     ,MPHONE VARCHAR2(13)    NOT NULL       -- 회원 핸드폰 번호
     ,MADDR0 VARCHAR2(6)     NOT NULL       -- 회원 주소(우편번호)
     ,MADDR1 VARCHAR2(200)   NOT NULL       -- 회원 주소
     ,MADDR2 VARCHAR2(100)   NOT NULL       -- 회원 상세 주소
     ,MEMAIL VARCHAR2(256)   NOT NULL       -- 회원 이메일 주소
     ,MREGDATE   DATE        NOT NULL       -- 회원 등록일
     ,MINDATE    DATE                       -- 데이터 등록일
     ,MUPDATE    DATE                       -- 데이터 수정일
     ,MADMIN VARCHAR2(1)     NOT NULL       -- 관리자 여부
 );
 
select * from member_list;
COMMIT;
 
INSERT INTO MEMBER_LIST(
        MNUM
        ,MID
        ,MPW
        ,MNAME
        ,MPHONE
        ,MADDR0
        ,MADDR1
        ,MADDR2
        ,MEMAIL
        ,MREGDATE
        ,MINDATE
        ,MUPDATE
        ,MADMIN
        )
      VALUES
      (
      #{MNUM},#{MID},#{MPW},#{MNAME},#{MPHONE},#{MADDR0},#{MADDR1},
      #{MADDR2},#{MEMAIL},SYSDATE,SYSDATE,SYSDATE,'N'
      );
        
INSERT INTO MEMBER_LIST 
VALUES ( 'M202106050001', 'DD','DD', 'DD', '11-11-11', '13480', 
'경기 성남시 분당구 대왕판교로 477', '낙생고등학교', 'X@naver.com',
SYSDATE,SYSDATE,SYSDATE,'N') ;
COMMIT;
------------------------------------------------------------------------------------------------------------
-- 경매
DROP TABLE GENERAL_GOODS;
CREATE TABLE GENERAL_GOODS(
    MNUM        VARCHAR2(13)   -- 회원번호
    ,CGNUM       VARCHAR2(50)   -- 카테고리 코드
    ,GNUM        VARCHAR2(256)   PRIMARY KEY  -- 일반 상품번호
    ,GSORT      VARCHAR2(500)   -- 구분
    ,GTITLE     VARCHAR2(50)   -- 제목
    ,GLOC       VARCHAR2(50)   -- 거래지역
    ,GREGCODE   VARCHAR2(10)   -- 법정동코드
    ,GPHOTO     VARCHAR2(500)   -- 사진
    ,GREPHOTO   VARCHAR2(500)   -- 리사이즈사진
    ,GPRICE     VARCHAR2(10)   -- 가격
    ,GCONTENTS   VARCHAR2(300)  -- 설명
    ,GSTATUS     VARCHAR2(100)  -- 상태
    -- 시스템 요소   
    ,GDELYN     VARCHAR2(3)         -- 삭제여부
    ,GREGDATE   DATE            -- 등록일
    ,GUPDATE    DATE            -- 수정일  
);
SELECT * FROM GENERAL_GOODS;
UPDATE GENERAL_GOODS SET CGNUM = 'CG10' WHERE CGNUM='대분류';
COMMIT;
---------------------------------------------------------------------------------------------------------
DROP TABLE BID_LIST;
CREATE TABLE BID_LIST(
    BNUM        VARCHAR2(13)   PRIMARY KEY  -- 입찰번호
    ,BPRICE     VARCHAR2(10)                -- 입찰가격
    ,BWINYN     VARCHAR2(1)                 -- 낙찰여부
    ,BDATE      DATE                        -- 입찰날짜
    ,ANUM       VARCHAR2(13)                -- 경매상품번호
    ,MNUM       VARCHAR2(13)                -- 입찰 신청한 회원번호
);
---------------------------------------------------------------------------------------------------------
-- : '시/도', '시/군/구', '읍/면/동', '리' 법정동코드목록을 JSON으로 반환
DROP TABLE REG_LIST;
CREATE TABLE REG_LIST(
    REGCODE     VARCHAR2(500)
    ,REGNAME    VARCHAR2(500)
    ,REGEXIST   VARCHAR2(500)
    ,REGLATI    VARCHAR2(500)
    ,REGLONG    VARCHAR2(500)
);
SELECT * FROM REG_LIST;

---------------------------------------------------------------------------------------------------------
-- 카테고리
DROP TABLE CATEGORY_LIST;
CREATE TABLE CATEGORY_LIST(
    CGNUM       VARCHAR2(32)
    ,CGNAME     VARCHAR2(32)
);
SELECT * FROM CATEGORY_LIST;
DELETE FROM CATEGORY_LIST;
-- INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG00','대분류');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG01','패션잡화');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG02','여성의류');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG03','남성의류');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG04','디지털/가전');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG05','도서/티켓/취미/애완');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG06','생활/문구/가전/식품');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG07','유아동/출산');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG08','스포츠/레저');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG09','뷰티/미용');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG10','기타');
COMMIT;

SELECT
              C.CGNUM   AS CGNUM     -- 카테고리 코드
             ,C.CGNAME  AS CGNAME    -- 카테고리 이름
      FROM
              CATEGORY_LIST C
      WHERE
              C.CGNUM = 
              ;
---------------------------------------------------------------------------------------------------------
-- 회원 history
DROP TABLE HMEMBER_LIST;
CREATE TABLE HMEMBER_LIST(
                HMNUM VARCHAR2(20) PRIMARY KEY  --회원번호.
               ,HMID VARCHAR2(20)               --아이디.
               ,HMPW VARCHAR2(256)              --비밀번호.
               ,HMNAME VARCHAR2(30)             --이름.
               ,HMPHONE VARCHAR2(13)            --핸드폰번호.
               ,HMADDR0 VARCHAR2(6)             --우편번호.
               ,HMADDR1 VARCHAR2(200)           --주소1.
               ,HMADDR2 VARCHAR2(100)           --주소2.
               ,HMEMAIL VARCHAR2(256)           --이메일.
               ,HMDELYN VARCHAR2(1)             --삭제여부.
               ,HMREGDATE DATE                  --회원등록일.
               ,HMINDATE DATE                   --데이터등록일.
               ,HMUPDATE DATE                   --데이터수정일.
               ,HMADMIN VARCHAR2(1)            --관리자여부.
);
---------------------------------------------------------------------------------------------------------
-- 공지 테이블
DROP TABLE NOTICE_LIST;
CREATE TABLE NOTICE_LIST(
            NNUM VARCHAR2(13) PRIMARY KEY-- 알림번호.
            ,NMNUM VARCHAR2(13)  -- 알림보낸회원번호.
            ,NSORT VARCHAR2(10)  -- 알림구분.
            ,NINFO VARCHAR2(10)  -- 알림정보.
            ,NURL VARCHAR2(500)  -- URL.
            ,NDELYN VARCHAR2(1) -- 삭제여부.
            ,NSENDDATE DATE  -- 알림등록날짜.
            ,MNUM VARCHAR2(13)  -- 회원번호(상대방)
            );
          
---------------------------------------------------------------------------------------------------------
-- 찜하기
DROP TABLE PICK_LIST;
CREATE TABLE PICK_LIST(
               MNUM   VARCHAR2(13) --회원번호.
              ,GNUM   VARCHAR2(500)--일반상품번호.
              ,PNUM   VARCHAR2(500) --찜번호.
              ,PDATE  DATE --찜한날짜.
              ,PDELYN VARCHAR2(1)--삭제여부.
                );
---------------------------------------------------------------------------------------------------------
-- 댓글 
DROP TABLE COMMENT_LIST;
CREATE TABLE COMMENT_LIST (
              CNUM        VARCHAR2(13) PRIMARY KEY    -- 댓글 번호
             ,CGROUPNUM   VARCHAR2(13)    -- 그룹 번호
               ,CTARGETNUM  VARCHAR2(13)    --   
             ,CCONTENTS   VARCHAR2(300)    -- 댓글 내용
             ,CPNUM       VARCHAR2(13)    -- 상품 번호
             ,MNUM        VARCHAR2(13)    -- 회원 번호
             ,CDELYN      VARCHAR2(1)    -- 삭제 여부
             ,CINDATE     DATE    -- 댓글 작성일
               );
               
DROP TABLE DEAL_REQ;
CREATE TABLE DEAL_REQ ( 
dnum VARCHAR2(13)  -- 거래신청번호.
,   dcontact VARCHAR2(13)  -- 거래할 전화번호.
,   ddate DATE         -- 거래신청날짜.
,   gnum VARCHAR2(13)  -- 글번호.
,   mnum VARCHAR2(13)  -- 회원번호.
);
                
-----------------------------------
COMMIT;