DROP TABLE IF EXISTS tbl_stock_value;

CREATE TABLE tbl_stock_value(
  seq INT AUTO_INCREMENT  PRIMARY KEY
  ,close                NUMERIC(6,2) NOT NULL 
  ,high                 NUMERIC(7,3) NOT NULL
  ,low                  NUMERIC(6,2) NOT NULL
  ,open                 NUMERIC(7,3) NOT NULL
  ,symbol               VARCHAR(6) NOT NULL
  ,volume               INTEGER  NOT NULL
  ,id                   VARCHAR(17) NOT NULL
  ,key                  VARCHAR(6) NOT NULL
  ,subkey               VARCHAR(30)
  ,date                 DATE  NOT NULL
  ,updated              INTEGER  NOT NULL
  ,changeOverTime       NUMERIC(21,19) NOT NULL
  ,marketChangeOverTime NUMERIC(21,19) NOT NULL
  ,uOpen                NUMERIC(7,3) NOT NULL
  ,uClose               NUMERIC(6,2) NOT NULL
  ,uHigh                NUMERIC(7,3) NOT NULL
  ,uLow                 NUMERIC(6,2) NOT NULL
  ,uVolume              INTEGER  NOT NULL
  ,fOpen                NUMERIC(7,3) NOT NULL
  ,fClose               NUMERIC(6,2) NOT NULL
  ,fHigh                NUMERIC(7,3) NOT NULL
  ,fLow                 NUMERIC(6,2) NOT NULL
  ,fVolume              INTEGER  NOT NULL
  ,label                VARCHAR(12)  NOT NULL
  ,change               NUMERIC(19,17) NOT NULL
  ,changePercent        NUMERIC(7,4) NOT NULL
);