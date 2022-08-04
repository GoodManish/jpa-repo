/*
    Hibernate Table DDL: 
    
    create table customer (
       id bigint not null,
        created_date timestamp,
        cust_id bigint not null,
        last_updated_date timestamp,
        threshold_amt bigint not null,
        utilized_threshold_amt bigint not null,
        usr_id integer,
        primary key (id)
    )
	
    create table usr (
       id integer not null,
        last_updated_date timestamp not null,
        user_name varchar(255) not null,
        primary key (id)
    )
	
--- Request JSON ---
{
  "id" : 1,
  "custId" : 999,
  "thresholdAmt" : 50000,
  "utilizedThresholdAmt" : 40000,
  "lastUpdatedDate" : "2022-08-04T21:20:19",
  "createdDate" : "2022-08-04T21:20:19",
  "usr" : {
    "id" : 2,
    "userName" : "Shakti",
    "lastUpdatedDate" : "2022-08-04T21:20:19"
  }
}
    
*/

-- USR needs to be saved before CUSTOMER
INSERT INTO USR (ID,       USER_NAME,  LAST_UPDATED_DATE)
            VALUES(20001,  'Manish', CURRENT_TIMESTAMP() );
INSERT INTO USR (ID,       USER_NAME, LAST_UPDATED_DATE)
            VALUES(20002,   'Deepthi', CURRENT_TIMESTAMP() );
INSERT INTO USR (ID,       USER_NAME, LAST_UPDATED_DATE)
            VALUES(20003,   'Mahendra', CURRENT_TIMESTAMP() );

INSERT INTO CUSTOMER ( ID, CUST_ID, THRESHOLD_AMT, UTILIZED_THRESHOLD_AMT, LAST_UPDATED_DATE, CREATED_DATE, USR_ID)
    VALUES(10001, 19292, 50000, 30000, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 20001);
INSERT INTO CUSTOMER ( ID, CUST_ID, THRESHOLD_AMT, UTILIZED_THRESHOLD_AMT, LAST_UPDATED_DATE, CREATED_DATE, USR_ID)
    VALUES(10002, 29292, 50000, 10000, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 20002);
INSERT INTO CUSTOMER ( ID, CUST_ID, THRESHOLD_AMT, UTILIZED_THRESHOLD_AMT, LAST_UPDATED_DATE, CREATED_DATE, USR_ID)
    VALUES(10003, 39292, 50000, 20000, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 20003);






