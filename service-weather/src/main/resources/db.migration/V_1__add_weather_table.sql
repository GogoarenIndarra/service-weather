
DROP TABLE IF EXISTS weather;

CREATE TABLE weather (
uuid  VARCHAR(250) NOT NULL,
city VARCHAR(250) NOT NULL,
created DATE NOT NULL,
temperature LONG ,
humidity LONG
);