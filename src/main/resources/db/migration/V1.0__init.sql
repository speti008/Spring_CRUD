CREATE TABLE tt_user
(
    id 		    CHAR(36)     NOT NULL, 
    first_name      VARCHAR(255) NOT NULL,
    last_name       VARCHAR(255) NOT NULL,
    gender          VARCHAR(255) NOT NULL,
    birthday        DATE         NOT NULL,
    email           VARCHAR(255) NOT NULL,
    phone_number    VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);