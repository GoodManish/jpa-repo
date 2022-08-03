/*
    create table customer (
        id integer not null,
        cust_id integer not null,
        threshold_amt integer,
        utilized_threshold_amt integer,
        created_date timestamp,
        last_updated_date timestamp,
        primary key (id)
    );
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






