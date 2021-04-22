CREATE TABLE IF NOT EXISTS transactions (
    id VARCHAR(36) NOT NULL PRIMARY KEY ,
    account_id VARCHAR(36) NOT NULL ,
    description VARCHAR(255) NOT NULL ,
    type VARCHAR(7) NOT NULL ,
    value DECIMAL NOT NULL
);