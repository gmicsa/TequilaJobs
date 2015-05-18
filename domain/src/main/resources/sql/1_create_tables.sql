DROP TABLE IF EXISTS JOB;
DROP TABLE IF EXISTS COMPANY;

CREATE TABLE COMPANY (
       id BIGINT NOT NULL AUTO_INCREMENT,
       name VARCHAR(64) NOT NULL,
       PRIMARY KEY (id)
);

ALTER TABLE COMPANY ADD CONSTRAINT UK_COMPANY_NAME UNIQUE (name);

CREATE TABLE JOB (
       id BIGINT NOT NULL AUTO_INCREMENT,
       company_id BIGINT NOT NULL,
       title VARCHAR(128) NOT NULL,
       location VARCHAR(128) NOT NULL,
       domain ENUM('SOFTWARE', 'HARDWARE', 'TELECOM', 'FINANCE', 'HR') NOT NULL,
       description TEXT NOT NULL,
       profile TEXT,
       offer TEXT,
       extra_info TEXT,
       positions_number TINYINT,
       min_experience TINYINT,
       career_level ENUM('ENTRY_LEVEL', 'JUNIOR', 'MIDDLE', 'SENIOR', 'EXPERT'),
       salary_from INT,
       salary_to INT,
       created_at TIMESTAMP NOT NULL DEFAULT NOW(),
       created_by VARCHAR(128) NOT NULL,
       valid_from DATE,
       valid_until DATE,
       state ENUM('OPEN', 'CLOSED', 'DISABLED', 'REMOVED') DEFAULT 'OPEN',
       PRIMARY KEY (id)
);

ALTER TABLE JOB ADD CONSTRAINT FK_JOB_COMPANY FOREIGN KEY (company_id) REFERENCES COMPANY (id);