DROP TABLE IF EXISTS track;

CREATE TABLE track (
    track_id    INT             AUTO_INCREMENT  PRIMARY KEY,
    name        VARCHAR(255)    NOT NULL,
    description VARCHAR(255)    NOT NULL,
    author      VARCHAR(50)     NOT NULL,
    url         VARCHAR(255)    NOT NULL,
    url_text    VARCHAR(255)    DEFAULT NULL,
    time        TIMESTAMP       NOT NULL,
);

INSERT INTO track(name, description, author, url, url_text, time)
VALUES ('test', 'test desc', 'nvhien', 'http://test.com', 'Test url', current_timestamp);
