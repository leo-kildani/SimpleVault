USE simplevault;

CREATE TABLE client_logins (
    username VARCHAR(64) COLLATE utf8mb4_general_ci NOT NULL PRIMARY KEY,
    password CHAR(72) NOT NULL,
    client_id INT,
    enabled TINYINT DEFAULT 1,
    FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

CREATE TABLE client_roles (
    role_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64) COLLATE utf8mb4_general_ci NOT NULL,
    `role` VARCHAR(64) COLLATE utf8mb4_general_ci NOT NULL,
    constraint fk_roles_logins FOREIGN KEY (username) REFERENCES client_logins(username)
);
CREATE UNIQUE INDEX ix_role_username ON client_roles (username, `role`);