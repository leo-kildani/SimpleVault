CREATE DATABASE IF NOT EXISTS test_simplevault;

USE test_simplevault;

CREATE TABLE clients AS SELECT * from simplevault.clients;
CREATE TABLE beneficiaries AS SELECT * from simplevault.beneficiaries;
CREATE TABLE accounts AS SELECT * from simplevault.accounts;
CREATE TABLE transactions AS SELECT * from simplevault.transactions;

GRANT ALL PRIVILEGES ON test_simplevault.* TO 'simplevault_user'@'localhost';

FLUSH PRIVILEGES;