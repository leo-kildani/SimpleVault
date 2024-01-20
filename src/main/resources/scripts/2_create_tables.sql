USE simplevault;

DROP TABLE IF EXISTS beneficiaries;
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
    client_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(64),
    last_name VARCHAR(64),
    date_of_birth DATE
);

CREATE TABLE beneficiaries (
    beneficiary_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(64),
    last_name VARCHAR(64),
    date_of_birth DATE,
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

CREATE TABLE accounts (
    account_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    account_type VARCHAR(16),
    balance DECIMAL,
    account_number INT(9),
    routing_number INT(9),
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    CONSTRAINT account_and_routing_numbers_constraing UNIQUE (account_number, routing_number)
);

CREATE TABLE transactions (
    transaction_id BINARY(16) NOT NULL PRIMARY KEY,
    source_account_id INT,
    destination_account_id INT,
    occurred_on DATETIME DEFAULT CURRENT_TIMESTAMP,
    transaction_amount DECIMAL,
    transaction_type VARCHAR(32),
    FOREIGN KEY (source_account_id) REFERENCES accounts(account_id),
    FOREIGN KEY (destination_account_id) REFERENCES accounts(account_id)
);