DROP DATABASE IF EXISTS subscriptions;
CREATE DATABASE subscriptions;
USE subscriptions;

CREATE TABLE subscription_info (
                                   sub_id INTEGER NOT NULL PRIMARY KEY,
                                   sub_name VARCHAR (50) NOT NULL,
                                   sub_type VARCHAR (50),
                                   membership VARCHAR (100)
);