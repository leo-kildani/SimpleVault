-- create_schema.sql

-- Connection details
SET @db_name = 'simplevault';
SET @username = 'simplevault_user';
SET @password = 'simplevault_password';

-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS simplevault;

-- Use the created database
USE simplevault;

-- Create a new user for the 'simplevault' schema
CREATE USER 'simplevault_user'@'localhost' IDENTIFIED BY 'simplevault_password';

-- Grant privileges to the user for the 'simplevault' schema
GRANT ALL PRIVILEGES
    ON simplevault.*
    TO 'simplevault_user'@'localhost';

-- Flush privileges to apply changes
FLUSH PRIVILEGES;