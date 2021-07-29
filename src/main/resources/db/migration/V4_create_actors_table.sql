CREATE TABLE IF NOT EXISTS ACTORS
(
  ID             BIGINT(20)    NOT NULL AUTO_INCREMENT,
  NAME         VARCHAR(256)  NOT NULL,
  BIRTH_YEAR         YEAR(4)      NOT NULL,
  PRIMARY KEY (ID)
);

INSERT INTO ACTORS VALUES
    (1, 'Sergio', 2001),
    (2, 'Jose', 1998),
    (3, 'Ana', 1989),
    (4, 'Rosa', 2005),
    (5, 'Miguel', 1972);