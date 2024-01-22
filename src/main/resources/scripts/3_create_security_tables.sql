USE simplevault;

CREATE TABLE client_logins (
    username VARCHAR(64) COLLATE utf8mb4_general_ci NOT NULL PRIMARY KEY,
    password CHAR(72) NOT NULL,
    client_id INT NOT NULL,
    enabled TINYINT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

CREATE TABLE roles (
    username VARCHAR(64) COLLATE utf8mb4_general_ci NOT NULL,
    `role` VARCHAR(64) COLLATE utf8mb4_general_ci NOT NULL,
    constraint fk_roles_client_logins FOREIGN KEY (username) REFERENCES client_logins(username)
);
CREATE UNIQUE INDEX ix_role_username ON roles (username, `role`);