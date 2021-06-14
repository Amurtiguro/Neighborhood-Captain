-- 경매
CREATE TABLE AUCTION_GOODS (
		                             ANUM   VARCHAR2(13)        -- 경매 상품번호
                                    ,ASORT  VARCHAR2(100)       -- 경매 상품 구분(3: 경매)
		                            ,ATITLE     VARCHAR2(120)   -- 경매 물건 제목
		                            ,ALOC   VARCHAR2(100)       -- 경매 물건 지역
		                            ,APHOTO VARCHAR2(256)       -- 경매 물건 사진
		                            ,AREPHOTO   VARCHAR2(256)   -- 썸네일 사진
		                            ,APRICEMIN  VARCHAR2(50)    -- 경매 최소 가격
		                            ,AENDTIME   TIMESTAMP       -- 경매 물건 종료 시간
		                            ,ACONTENTS  VARCHAR2(500)   -- 경매 상품 내용
		                            ,ASTATUS    VARCHAR2(100)   -- 경매 상품 상태
		                            ,ADELYN     VARCHAR2(1)     -- 삭제 여부
		                            ,AREGDATE   DATE            -- 등록일
		                            ,AUPDATE    DATE            -- 수정일
		                            ,MNUM       VARCHAR2(13)    -- 회원번호
		                            ,CGNUM  VARCHAR2(13)        -- 카테고리 번호
                                    );
INSERT INTO AUCTION_GOODS (
		                             ANUM
		                            ,ASORT  -- 고정값 3
		                            ,ATITLE 
		                            ,ALOC
		                            ,APHOTO
		                            ,AREPHOTO
		                            ,APRICEMIN
		                            ,AENDTIME
		                            ,ACONTENTS
		                            ,ASTATUS    -- 고정값 1
		                            ,ADELYN     -- 고정값 '엔'
		                            ,AREGDATE
		                            ,AUPDATE
		                            ,MNUM
		                            ,CGNUM
								)VALUES(
		                             #{anum}							  		--경매상품번호        
		                            ,#{asort}						      		--상품 구분(3: 경매)
		                            ,#{atitle}						      		--제목
		                            ,#{aloc}						      		--지역
		                            ,#{aphoto}						      		--사진
		                            ,#{arephoto}						  		--썸네일 사진    
		                            ,#{apricemin}					      		--최소가격
		                            ,SYSTIMESTAMP+ TO_NUMBER(#{aendtime})/24	--종료시간 
		                            ,#{acontents}							    --상품내용
		                            ,#{astatus}									--상품상태
		                            ,#{adelyn}									--삭제여부
		                            ,SYSDATE									--등록일
		                            ,SYSDATE								  	--수정일
		                            ,#{mnum}						   			--회원번호
		                            ,#{cgnum}	
                                    );
                                    

 
 
 
 --- 회원가입 테이블
CREATE TABLE MEMBER_LIST(
      MNUM   VARCHAR2(13)    PRIMARY KEY
     ,MID    VARCHAR2(20)
     ,MPW    VARCHAR2(256)
     ,MNAME  VARCHAR2(30)
     ,MPHONE VARCHAR2(13) 
     ,MADDR0 VARCHAR2(200)
     ,MADDR1 VARCHAR2(200)
     ,MADDR2 VARCHAR2(200)
     ,MEMAIL VARCHAR2(256)
     ,MREGDATE   DATE
     ,MINDATE    DATE
     ,MUPDATE    DATE
     ,MADMIN VARCHAR2(30)
 );
 
 DROP TABLE MEMBER_LIST;
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
CREATE TABLE GENERAL_GOODS(
    MNUM        VARCHAR2(500)   -- 회원번호
    ,CGNUM	    VARCHAR2(500)   -- 카테고리 코드
    ,GNUM        VARCHAR2(500)   PRIMARY KEY  -- 일반 상품번호
    ,GSORT      VARCHAR2(500)   -- 구분
    ,GTITLE     VARCHAR2(500)   -- 제목
    ,GLOC       VARCHAR2(500)   -- 거래지역
    ,GREGCODE   VARCHAR2(500)   -- 법정동코드
    ,GPHOTO     VARCHAR2(500)   -- 사진
    ,GREPHOTO   VARCHAR2(500)   -- 리사이즈사진
    ,GPRICE     VARCHAR2(500)   -- 가격
    ,GCONTENTS   VARCHAR2(500)  -- 설명
    ,GSTATUS     VARCHAR2(500)  -- 상태
    -- 시스템 요소   
    ,GDELYN     VARCHAR2(3)         -- 삭제여부
    ,GREGDATE   DATE            -- 등록일
    ,GUPDATE    DATE            -- 수정일  
);
SELECT * FROM GENERAL_GOODS;
UPDATE GENERAL_GOODS SET CGNUM = 'CG10' WHERE CGNUM='대분류';
COMMIT;
---------------------------------------------------------------------------------------------------------
CREATE TABLE BID_LIST(
    BNUM        VARCHAR2(500)   PRIMARY KEY -- 입찰번호
    ,BPRICE     VARCHAR2(500)              -- 입찰가격
    ,BWINYN     VARCHAR2(500)               -- 낙찰여부
    ,BDATE      DATE                -- 입찰날짜
    ,ANUM       VARCHAR2(500)               -- 경매상품번호
    ,MNUM       VARCHAR2(500)                    -- 입찰 신청한 회원번호
);
DROP TABLE BID_LIST;
---------------------------------------------------------------------------------------------------------
-- : '시/도', '시/군/구', '읍/면/동', '리' 법정동코드목록을 JSON으로 반환
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
CREATE TABLE CATEGORY_LIST(
    CGNUM       VARCHAR2(500)
    ,CGNAME     VARCHAR2(500)
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
---------------------------------------------------------------------------------------------------------
-- 회원 history
CREATE TABLE HMEMBER_LIST(
		          HMNUM VARCHAR2(50) PRIMARY KEY --회원번호.
		         ,HMID VARCHAR2(50) --아이디.
		         ,HMPW VARCHAR2(50) --비밀번호.
		         ,HMNAME VARCHAR2(50)   --이름.
		         ,HMPHONE VARCHAR2(50)  --핸드폰번호.
		         ,HMADDR0 VARCHAR2(50) --우편번호.
		         ,HMADDR1 VARCHAR2(50) --주소1.
		         ,HMADDR2 VARCHAR2(50) --주소2.
		         ,HMEMAIL VARCHAR2(50) --이메일.
		         ,HMDELYN VARCHAR2(50) --삭제여부.
		         ,HMREGDATE DATE --회원등록일.
		         ,HMINDATE DATE --데이터등록일.
		         ,HMUPDATE DATE --데이터수정일.
		         ,HMADMIN VARCHAR2(50)  --관리자여부.
);
---------------------------------------------------------------------------------------------------------
-- 공지 테이블
		CREATE TABLE NOTICE_LIST(
                 NNUM VARCHAR2(500) PRIMARY KEY-- 알림번호.
                ,NMNUM VARCHAR2(500)  -- 알림보낸회원번호.
                ,NSORT VARCHAR2(500)  -- 알림구분.
                ,NINFO VARCHAR2(500)  -- 알림정보.
                ,NURL VARCHAR2(500)  -- URL.
                ,NDELYN VARCHAR2(3) -- 삭제여부.
                ,NSENDDATE DATE  -- 알림등록날짜.
                ,MNUM VARCHAR2(500)  -- 회원번호(상대방)
          );
          
          DROP TABLE NOTICE_LIST;
          
---------------------------------------------------------------------------------------------------------
-- 찜하기
CREATE TABLE PICK_LIST(
		         MNUM   VARCHAR2(500) --회원번호.
		        ,GNUM   VARCHAR2(500)--일반상품번호.
		        ,PNUM   VARCHAR2(500) --찜번호.
		        ,PDATE  DATE --찜한날짜.
		        ,PDELYN VARCHAR2(3)--삭제여부.
                );
---------------------------------------------------------------------------------------------------------
-- 댓글 
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
DROP TABLE COMMENT_LIST;

CREATE TABLE DEAL_REQ(
		         DNUM VARCHAR2(13)  -- 거래신청번호.
		        ,DCONTACT VARCHAR2(200)  -- 거래할 전화번호.
		        ,DDATE DATE         -- 거래신청날짜.
		        ,GNUM VARCHAR2(13)  -- 글번호.
		        ,MNUM VARCHAR2(13)  -- 회원번호.
                );