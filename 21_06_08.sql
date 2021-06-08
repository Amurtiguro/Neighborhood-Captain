-- ���
DROP TABLE auction_goods;
CREATE TABLE auction_goods (
    anum       VARCHAR2(13) PRIMARY KEY,        -- ��� ��ǰ��ȣ
    asort      VARCHAR2(100) NOT NULL,       -- ��� ��ǰ ����(3: ���)
    atitle     VARCHAR2(50) NOT NULL,       -- ��� ���� ����
    aloc       VARCHAR2(100) NOT NULL,       -- ��� ���� ����
    aphoto     VARCHAR2(256),       -- ��� ���� ����
    arephoto   VARCHAR2(256),       -- ����� ����
    apricemin  VARCHAR2(50),        -- ��� �ּ� ����
    aendtime   TIMESTAMP NOT NULL,           -- ��� ���� ���� �ð�
    acontents  VARCHAR2(500) NOT NULL,       -- ��� ��ǰ ����
    astatus    VARCHAR2(15) NOT NULL,        -- ��� ��ǰ ����
    adelyn     VARCHAR2(1) NOT NULL,         -- ���� ����
    aregdate   DATE NOT NULL,                -- �����
    aupdate    DATE NOT NULL,                -- ������
    mnum       VARCHAR2(13) NOT NULL,        -- ȸ����ȣ
    cgnum      VARCHAR2(13) NOT NULL        -- ī�װ� ��ȣ
);
INSERT INTO auction_goods (
        anum,
        asort,  -- ������ 3
        atitle,
        aloc,
        aphoto,
        arephoto,
        apricemin,
        aendtime,
        acontents,
        astatus,    -- ������ 1
        adelyn,     -- ������ '��'
        aregdate,
        aupdate,
        mnum,
        cgnum
    )
VALUES (
                                   #{anum}                                  --��Ż�ǰ��ȣ        
                                  ,#{asort}                                 --��ǰ ����(3: ���)
                                  ,#{atitle}                                --����
                                  ,#{aloc}                                  --����
                                  ,#{aphoto}                                --����
                                  ,#{arephoto}                              --����� ����    
                                  ,#{apricemin}                             --�ּҰ���
                                  ,SYSTIMESTAMP+ TO_NUMBER(#{aendtime})/24  --����ð� 
                                  ,#{acontents}                             --��ǰ����
                                  ,#{astatus}                               --��ǰ����
                                  ,#{adelyn}                                --��������
                                  ,SYSDATE                                  --�����
                                  ,SYSDATE                                  --������
                                  ,#{mnum}                                  --ȸ����ȣ
                                  ,#{cgnum}   
                                    );
                                    

 
 --- ȸ������ ���̺�
DROP TABLE MEMBER_LIST;
CREATE TABLE MEMBER_LIST(
      MNUM   VARCHAR2(13)    PRIMARY KEY    -- ȸ�� ��ȣ
     ,MID    VARCHAR2(20)    NOT NULL       -- ȸ�� ���̵�
     ,MPW    VARCHAR2(256)   NOT NULL       -- ȸ�� ��й�ȣ
     ,MNAME  VARCHAR2(30)    NOT NULL       -- ȸ�� �̸�
     ,MPHONE VARCHAR2(13)    NOT NULL       -- ȸ�� �ڵ��� ��ȣ
     ,MADDR0 VARCHAR2(6)     NOT NULL       -- ȸ�� �ּ�(�����ȣ)
     ,MADDR1 VARCHAR2(200)   NOT NULL       -- ȸ�� �ּ�
     ,MADDR2 VARCHAR2(100)   NOT NULL       -- ȸ�� �� �ּ�
     ,MEMAIL VARCHAR2(256)   NOT NULL       -- ȸ�� �̸��� �ּ�
     ,MREGDATE   DATE        NOT NULL       -- ȸ�� �����
     ,MINDATE    DATE                       -- ������ �����
     ,MUPDATE    DATE                       -- ������ ������
     ,MADMIN VARCHAR2(1)     NOT NULL       -- ������ ����
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
'��� ������ �д籸 ����Ǳ��� 477', '��������б�', 'X@naver.com',
SYSDATE,SYSDATE,SYSDATE,'N') ;
COMMIT;
------------------------------------------------------------------------------------------------------------
-- ���
DROP TABLE GENERAL_GOODS;
CREATE TABLE GENERAL_GOODS(
    MNUM        VARCHAR2(13)   -- ȸ����ȣ
    ,CGNUM       VARCHAR2(50)   -- ī�װ� �ڵ�
    ,GNUM        VARCHAR2(256)   PRIMARY KEY  -- �Ϲ� ��ǰ��ȣ
    ,GSORT      VARCHAR2(500)   -- ����
    ,GTITLE     VARCHAR2(50)   -- ����
    ,GLOC       VARCHAR2(50)   -- �ŷ�����
    ,GREGCODE   VARCHAR2(10)   -- �������ڵ�
    ,GPHOTO     VARCHAR2(500)   -- ����
    ,GREPHOTO   VARCHAR2(500)   -- �����������
    ,GPRICE     VARCHAR2(10)   -- ����
    ,GCONTENTS   VARCHAR2(300)  -- ����
    ,GSTATUS     VARCHAR2(100)  -- ����
    -- �ý��� ���   
    ,GDELYN     VARCHAR2(3)         -- ��������
    ,GREGDATE   DATE            -- �����
    ,GUPDATE    DATE            -- ������  
);
SELECT * FROM GENERAL_GOODS;
UPDATE GENERAL_GOODS SET CGNUM = 'CG10' WHERE CGNUM='��з�';
COMMIT;
---------------------------------------------------------------------------------------------------------
DROP TABLE BID_LIST;
CREATE TABLE BID_LIST(
    BNUM        VARCHAR2(13)   PRIMARY KEY  -- ������ȣ
    ,BPRICE     VARCHAR2(10)                -- ��������
    ,BWINYN     VARCHAR2(1)                 -- ��������
    ,BDATE      DATE                        -- ������¥
    ,ANUM       VARCHAR2(13)                -- ��Ż�ǰ��ȣ
    ,MNUM       VARCHAR2(13)                -- ���� ��û�� ȸ����ȣ
);
---------------------------------------------------------------------------------------------------------
-- : '��/��', '��/��/��', '��/��/��', '��' �������ڵ����� JSON���� ��ȯ
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
-- ī�װ�
DROP TABLE CATEGORY_LIST;
CREATE TABLE CATEGORY_LIST(
    CGNUM       VARCHAR2(32)
    ,CGNAME     VARCHAR2(32)
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
              ;
---------------------------------------------------------------------------------------------------------
-- ȸ�� history
DROP TABLE HMEMBER_LIST;
CREATE TABLE HMEMBER_LIST(
                HMNUM VARCHAR2(20) PRIMARY KEY  --ȸ����ȣ.
               ,HMID VARCHAR2(20)               --���̵�.
               ,HMPW VARCHAR2(256)              --��й�ȣ.
               ,HMNAME VARCHAR2(30)             --�̸�.
               ,HMPHONE VARCHAR2(13)            --�ڵ�����ȣ.
               ,HMADDR0 VARCHAR2(6)             --�����ȣ.
               ,HMADDR1 VARCHAR2(200)           --�ּ�1.
               ,HMADDR2 VARCHAR2(100)           --�ּ�2.
               ,HMEMAIL VARCHAR2(256)           --�̸���.
               ,HMDELYN VARCHAR2(1)             --��������.
               ,HMREGDATE DATE                  --ȸ�������.
               ,HMINDATE DATE                   --�����͵����.
               ,HMUPDATE DATE                   --�����ͼ�����.
               ,HMADMIN VARCHAR2(1)            --�����ڿ���.
);
---------------------------------------------------------------------------------------------------------
-- ���� ���̺�
DROP TABLE NOTICE_LIST;
CREATE TABLE NOTICE_LIST(
            NNUM VARCHAR2(13) PRIMARY KEY-- �˸���ȣ.
            ,NMNUM VARCHAR2(13)  -- �˸�����ȸ����ȣ.
            ,NSORT VARCHAR2(10)  -- �˸�����.
            ,NINFO VARCHAR2(10)  -- �˸�����.
            ,NURL VARCHAR2(500)  -- URL.
            ,NDELYN VARCHAR2(1) -- ��������.
            ,NSENDDATE DATE  -- �˸���ϳ�¥.
            ,MNUM VARCHAR2(13)  -- ȸ����ȣ(����)
            );
          
---------------------------------------------------------------------------------------------------------
-- ���ϱ�
DROP TABLE PICK_LIST;
CREATE TABLE PICK_LIST(
               MNUM   VARCHAR2(13) --ȸ����ȣ.
              ,GNUM   VARCHAR2(500)--�Ϲݻ�ǰ��ȣ.
              ,PNUM   VARCHAR2(500) --���ȣ.
              ,PDATE  DATE --���ѳ�¥.
              ,PDELYN VARCHAR2(1)--��������.
                );
---------------------------------------------------------------------------------------------------------
-- ��� 
DROP TABLE COMMENT_LIST;
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
               
DROP TABLE DEAL_REQ;
CREATE TABLE DEAL_REQ ( 
dnum VARCHAR2(13)  -- �ŷ���û��ȣ.
,   dcontact VARCHAR2(13)  -- �ŷ��� ��ȭ��ȣ.
,   ddate DATE         -- �ŷ���û��¥.
,   gnum VARCHAR2(13)  -- �۹�ȣ.
,   mnum VARCHAR2(13)  -- ȸ����ȣ.
);
                
-----------------------------------
COMMIT;