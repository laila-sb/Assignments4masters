DROP DATABASE IF EXISTS subscriptions;
CREATE DATABASE subscriptions;
USE subscriptions;

CREATE TABLE subscription_info (
                                   id INTEGER NOT NULL PRIMARY KEY,
                                   subName VARCHAR (50) NOT NULL,
                                   subType VARCHAR (50),
                                   membership VARCHAR (100)
);