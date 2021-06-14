SELECT  
				 MNUM                           AS MNUM     
				,CGNUM                          AS CGNUM    
				,GNUM                           AS GNUM     
				,GSORT                          AS GSORT    
				,GTITLE                         AS GTITLE   
				,GLOC                           AS GLOC     
				,GREGCODE                       AS GREGCODE 
				,GPHOTO                         AS GPHOTO   
				,GPRICE                         AS GPRICE   
				,GCONTENTS                      AS GCONTENTS
				,GSTATUS                        AS GSTATUS  
				,GDELYN                         AS GDELYN   
				,TO_CHAR(GREGDATE, 'YYYY-MM-DD')AS GREGDATE
				,TO_CHAR(GUPDATE, 'YYYY-MM-DD') AS GUPDATE
		FROM GENERAL_GOODS;
        
CREATE TABLE GENERAL_GOOD(
                 GNUM                           VARCHAR2(13) PRIMARY KEY
                ,GSORT                          VARCHAR2(2) NOT NULL
				,GTITLE                         VARCHAR2(120) NULL  
				,GLOC                           VARCHAR2(100) NULL     
				,GREGCODE                       VARCHAR2() NOT NULL 
				,GREPHOTO                       VARCHAR2(256) NULL   
				,GPRICE                         VARCHAR2(10) NULL   
				,GCONTENTS                      VARCHAR2(3000) NULL
				,GSTATUS                        VARCHAR2(1) NOT NULL  
				,GDELYN                         VARCHAR2(1) NOT NULL   
				,GREGDATE                       DATE
				,GUPDATE                        DATE
);
