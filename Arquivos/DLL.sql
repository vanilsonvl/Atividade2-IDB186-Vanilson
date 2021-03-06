USE IDB1862;

CREATE TABLE CLIENT(
	CLI_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    CLI_NAME VARCHAR(30),
    CLI_PHONE VARCHAR(10)
);

CREATE TABLE DEALERSHIP(
	DEA_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    DEA_NAME VARCHAR(30),
    DEA_USERNAME VARCHAR(10),
    DEA_PASSWORD VARCHAR(20),
    CONSTRAINT DEA_USERNAME_UK UNIQUE KEY(DEA_USERNAME)
);

CREATE TABLE CAR(
	CAR_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    CLI_ID BIGINT,
    DEA_ID BIGINT,
    CAR_PRICE DECIMAL(7,2),
    CAR_MODEL VARCHAR(20),
    CAR_MANUFACTURER VARCHAR(20),
	FOREIGN KEY CLIENT_FK (CLI_ID) REFERENCES CLIENT (CLI_ID) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY DEALER_FK (DEA_ID) REFERENCES DEALERSHIP (DEA_ID) ON DELETE RESTRICT ON UPDATE CASCADE
);
#DESC DEALERSHIP;
#SELECT * FROM dealership;
#DROP TABLE CAR;
#DROP TABLE CLIENT;