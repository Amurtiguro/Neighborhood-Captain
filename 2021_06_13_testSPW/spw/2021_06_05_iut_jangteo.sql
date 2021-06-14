-- ���
CREATE TABLE AUCTION_GOODS (
		                             ANUM   VARCHAR2(13)        -- ��� ��ǰ��ȣ
                                    ,ASORT  VARCHAR2(100)       -- ��� ��ǰ ����(3: ���)
		                            ,ATITLE     VARCHAR2(120)   -- ��� ���� ����
		                            ,ALOC   VARCHAR2(100)       -- ��� ���� ����
		                            ,APHOTO VARCHAR2(256)       -- ��� ���� ����
		                            ,AREPHOTO   VARCHAR2(256)   -- ����� ����
		                            ,APRICEMIN  VARCHAR2(50)    -- ��� �ּ� ����
		                            ,AENDTIME   TIMESTAMP       -- ��� ���� ���� �ð�
		                            ,ACONTENTS  VARCHAR2(500)   -- ��� ��ǰ ����
		                            ,ASTATUS    VARCHAR2(100)   -- ��� ��ǰ ����
		                            ,ADELYN     VARCHAR2(1)     -- ���� ����
		                            ,AREGDATE   DATE            -- �����
		                            ,AUPDATE    DATE            -- ������
		                            ,MNUM       VARCHAR2(13)    -- ȸ����ȣ
		                            ,CGNUM  VARCHAR2(13)        -- ī�װ� ��ȣ
                                    );
INSERT INTO AUCTION_GOODS (
		                             ANUM
		                            ,ASORT  -- ������ 3
		                            ,ATITLE 
		                            ,ALOC
		                            ,APHOTO
		                            ,AREPHOTO
		                            ,APRICEMIN
		                            ,AENDTIME
		                            ,ACONTENTS
		                            ,ASTATUS    -- ������ 1
		                            ,ADELYN     -- ������ '��'
		                            ,AREGDATE
		                            ,AUPDATE
		                            ,MNUM
		                            ,CGNUM
								)VALUES(
		                             #{anum}							  		--��Ż�ǰ��ȣ        
		                            ,#{asort}						      		--��ǰ ����(3: ���)
		                            ,#{atitle}						      		--����
		                            ,#{aloc}						      		--����
		                            ,#{aphoto}						      		--����
		                            ,#{arephoto}						  		--����� ����    
		                            ,#{apricemin}					      		--�ּҰ���
		                            ,SYSTIMESTAMP+ TO_NUMBER(#{aendtime})/24	--����ð� 
		                            ,#{acontents}							    --��ǰ����
		                            ,#{astatus}									--��ǰ����
		                            ,#{adelyn}									--��������
		                            ,SYSDATE									--�����
		                            ,SYSDATE								  	--������
		                            ,#{mnum}						   			--ȸ����ȣ
		                            ,#{cgnum}	
                                    );
                                    

 
 
 
 --- ȸ������ ���̺�
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
'��� ������ �д籸 ����Ǳ��� 477', '��������б�', 'X@naver.com',
SYSDATE,SYSDATE,SYSDATE,'N') ;
COMMIT;
------------------------------------------------------------------------------------------------------------
-- ���
CREATE TABLE GENERAL_GOODS(
    MNUM        VARCHAR2(500)   -- ȸ����ȣ
    ,CGNUM	    VARCHAR2(500)   -- ī�װ� �ڵ�
    ,GNUM        VARCHAR2(500)   PRIMARY KEY  -- �Ϲ� ��ǰ��ȣ
    ,GSORT      VARCHAR2(500)   -- ����
    ,GTITLE     VARCHAR2(500)   -- ����
    ,GLOC       VARCHAR2(500)   -- �ŷ�����
    ,GREGCODE   VARCHAR2(500)   -- �������ڵ�
    ,GPHOTO     VARCHAR2(500)   -- ����
    ,GREPHOTO   VARCHAR2(500)   -- �����������
    ,GPRICE     VARCHAR2(500)   -- ����
    ,GCONTENTS   VARCHAR2(500)  -- ����
    ,GSTATUS     VARCHAR2(500)  -- ����
    -- �ý��� ���   
    ,GDELYN     VARCHAR2(3)         -- ��������
    ,GREGDATE   DATE            -- �����
    ,GUPDATE    DATE            -- ������  
);
SELECT * FROM GENERAL_GOODS;
UPDATE GENERAL_GOODS SET CGNUM = 'CG10' WHERE CGNUM='��з�';
COMMIT;
---------------------------------------------------------------------------------------------------------
CREATE TABLE BID_LIST(
    BNUM        VARCHAR2(500)   PRIMARY KEY -- ������ȣ
    ,BPRICE     VARCHAR2(500)              -- ��������
    ,BWINYN     VARCHAR2(500)               -- ��������
    ,BDATE      DATE                -- ������¥
    ,ANUM       VARCHAR2(500)               -- ��Ż�ǰ��ȣ
    ,MNUM       VARCHAR2(500)                    -- ���� ��û�� ȸ����ȣ
);
DROP TABLE BID_LIST;
---------------------------------------------------------------------------------------------------------
-- : '��/��', '��/��/��', '��/��/��', '��' �������ڵ����� JSON���� ��ȯ
CREATE TABLE REG_LIST(
    REGCODE     VARCHAR2(500)
    ,REGNAME    VARCHAR2(500)
    ,REGEXIST   VARCHAR2(500)
    ,REGLATI    VARCHAR2(500)
    ,REGLONG    VARCHAR2(500)
);
SELECT * FROM REG_LIST;

---------------------------------------------------------------------------------------------------------
-- ī�װ�
CREATE TABLE CATEGORY_LIST(
    CGNUM       VARCHAR2(500)
    ,CGNAME     VARCHAR2(500)
);
SELECT * FROM CATEGORY_LIST;
DELETE FROM CATEGORY_LIST;
-- INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG00','��з�');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG01','�м���ȭ');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG02','�����Ƿ�');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG03','�����Ƿ�');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG04','������/����');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG05','����/Ƽ��/���/�ֿ�');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG06','��Ȱ/����/����/��ǰ');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG07','���Ƶ�/���');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG08','������/����');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG09','��Ƽ/�̿�');
INSERT INTO CATEGORY_LIST(CGNUM, CGNAME) VALUES('CG10','��Ÿ');
COMMIT;

SELECT
		        C.CGNUM   AS CGNUM     -- ī�װ� �ڵ�
		       ,C.CGNAME  AS CGNAME    -- ī�װ� �̸�
		FROM
		        CATEGORY_LIST C
		WHERE
		        C.CGNUM = 
---------------------------------------------------------------------------------------------------------
-- ȸ�� history
CREATE TABLE HMEMBER_LIST(
		          HMNUM VARCHAR2(50) PRIMARY KEY --ȸ����ȣ.
		         ,HMID VARCHAR2(50) --���̵�.
		         ,HMPW VARCHAR2(50) --��й�ȣ.
		         ,HMNAME VARCHAR2(50)   --�̸�.
		         ,HMPHONE VARCHAR2(50)  --�ڵ�����ȣ.
		         ,HMADDR0 VARCHAR2(50) --�����ȣ.
		         ,HMADDR1 VARCHAR2(50) --�ּ�1.
		         ,HMADDR2 VARCHAR2(50) --�ּ�2.
		         ,HMEMAIL VARCHAR2(50) --�̸���.
		         ,HMDELYN VARCHAR2(50) --��������.
		         ,HMREGDATE DATE --ȸ�������.
		         ,HMINDATE DATE --�����͵����.
		         ,HMUPDATE DATE --�����ͼ�����.
		         ,HMADMIN VARCHAR2(50)  --�����ڿ���.
);
---------------------------------------------------------------------------------------------------------
-- ���� ���̺�
		CREATE TABLE NOTICE_LIST(
                 NNUM VARCHAR2(500) PRIMARY KEY-- �˸���ȣ.
                ,NMNUM VARCHAR2(500)  -- �˸�����ȸ����ȣ.
                ,NSORT VARCHAR2(500)  -- �˸�����.
                ,NINFO VARCHAR2(500)  -- �˸�����.
                ,NURL VARCHAR2(500)  -- URL.
                ,NDELYN VARCHAR2(3) -- ��������.
                ,NSENDDATE DATE  -- �˸���ϳ�¥.
                ,MNUM VARCHAR2(500)  -- ȸ����ȣ(����)
          );
          
          DROP TABLE NOTICE_LIST;
          
---------------------------------------------------------------------------------------------------------
-- ���ϱ�
CREATE TABLE PICK_LIST(
		         MNUM   VARCHAR2(500) --ȸ����ȣ.
		        ,GNUM   VARCHAR2(500)--�Ϲݻ�ǰ��ȣ.
		        ,PNUM   VARCHAR2(500) --���ȣ.
		        ,PDATE  DATE --���ѳ�¥.
		        ,PDELYN VARCHAR2(3)--��������.
                );
---------------------------------------------------------------------------------------------------------
-- ��� 
	CREATE TABLE COMMENT_LIST (
		        CNUM        VARCHAR2(13) PRIMARY KEY    -- ��� ��ȣ
		       ,CGROUPNUM   VARCHAR2(13)    -- �׷� ��ȣ
               ,CTARGETNUM  VARCHAR2(13)    --   
		       ,CCONTENTS   VARCHAR2(300)    -- ��� ����
		       ,CPNUM       VARCHAR2(13)    -- ��ǰ ��ȣ
		       ,MNUM        VARCHAR2(13)    -- ȸ�� ��ȣ
		       ,CDELYN      VARCHAR2(1)    -- ���� ����
		       ,CINDATE     DATE    -- ��� �ۼ���
               );
DROP TABLE COMMENT_LIST;

CREATE TABLE DEAL_REQ(
		         DNUM VARCHAR2(13)  -- �ŷ���û��ȣ.
		        ,DCONTACT VARCHAR2(200)  -- �ŷ��� ��ȭ��ȣ.
		        ,DDATE DATE         -- �ŷ���û��¥.
		        ,GNUM VARCHAR2(13)  -- �۹�ȣ.
		        ,MNUM VARCHAR2(13)  -- ȸ����ȣ.
                );