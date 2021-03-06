CREATE TABLE "user"(
                     USER_ID BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                     USERNAME VARCHAR(16) NOT NULL UNIQUE,
                     PASSWORD VARCHAR(32) NOT NULL,
                     ROLE NUMERIC(1) NOT NULL
);
-- ROLE 1 => ADMIN
-- ROLE 2 => DOCTOR

CREATE TABLE HOSPITAL(
                      HOSPITAL_ID BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                      NAME VARCHAR(64) NOT NULL UNIQUE,
                      DETAILS VARCHAR(250),
                      ADDRESS VARCHAR(64),
                      PHONE_NUMBER VARCHAR(24),
                      LNG DOUBLE PRECISION NOT NULL,
                      LAT DOUBLE PRECISION NOT NULL
);

CREATE TABLE QUARANTINE_CENTER(
                                  CENTER_ID BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                  NAME VARCHAR(64) NOT NULL UNIQUE,
                                  DETAILS VARCHAR(250),
                                  ADDRESS VARCHAR(64),
                                  PHONE_NUMBER VARCHAR(24),
                                  LNG DOUBLE PRECISION NOT NULL,
                                  LAT DOUBLE PRECISION NOT NULL
);

CREATE TABLE INFECTED_CITIZEN(
    NATIONAL_NUMBER BIGINT PRIMARY KEY,
    FIRST_NAME VARCHAR(20) NOT NULL,
    LAST_NAME VARCHAR(20) NOT NULL,
    LNG DOUBLE PRECISION,
    LAT DOUBLE PRECISION,
    PHONE_NUMBER VARCHAR(24) NOT NULL,
    EMAIL VARCHAR(50),
    STATUS NUMERIC(1),
    CENTER_ID BIGINT,
    HOSPITAL_ID BIGINT
);
-- status is defined as following
-- status 1 => sick
-- status 2 => healed
-- status 3 => dead

CREATE TABLE QUESTION(
    QUESTION_ID BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    QUESTION_TEXT VARCHAR
);

CREATE TABLE ANSWER(
    ANSWER_ID BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    QUESTION_ID BIGINT NOT NULL,
    NATIONAL_NUMBER BIGINT NOT NULL,
    ANSWER VARCHAR(100) NOT NULL
);


ALTER TABLE ANSWER ADD FOREIGN KEY (NATIONAL_NUMBER) REFERENCES INFECTED_CITIZEN(NATIONAL_NUMBER);
ALTER TABLE ANSWER ADD FOREIGN KEY (QUESTION_ID) REFERENCES QUESTION(QUESTION_ID);

ALTER TABLE INFECTED_CITIZEN ADD FOREIGN KEY (CENTER_ID) REFERENCES QUARANTINE_CENTER(CENTER_ID);
ALTER TABLE INFECTED_CITIZEN ADD FOREIGN KEY (HOSPITAL_ID) REFERENCES HOSPITAL(HOSPITAL_ID);
