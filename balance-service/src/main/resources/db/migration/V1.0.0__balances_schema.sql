CREATE TABLE IF NOT EXISTS balances (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    account_id VARCHAR(36) NOT NULL ,
    value DECIMAL NOT NULL,
);