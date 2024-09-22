

DROP DATABASE IF EXISTS subscriptions;
CREATE DATABASE subscriptions;
USE subscriptions;

CREATE TABLE subscription_info (
                                   sub_id INTEGER AUTO_INCREMENT PRIMARY KEY,
                                   sub_name VARCHAR (100) NOT NULL,
                                   sub_type VARCHAR (100),
                                   membership VARCHAR (100)
);


INSERT INTO subscription_info (sub_name , sub_type , membership)
VALUES

    ('Netflix','Entertainment', 'active'),
    ('Amazon Prime', 'Entertainment','not active'),
    ('Fitness First', 'Health', 'active'),
    ('Odd Box', 'Groceries', 'not active'),
    ('Spotify', 'Music', 'active'),
    ('Code Academy', 'Education', 'not active'),
    ('Apple TV+', 'Entertainment', 'active'),
    ('Costco Membership', 'Groceries', 'not active'),
    ('Nike Run Club', 'Health', 'active'),
    ('Good Reads','Entertainment', 'not active');