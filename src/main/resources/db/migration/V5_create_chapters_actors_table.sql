CREATE TABLE IF NOT EXISTS `CHAPTERS_ACTORS`(
  `CHAPTER_ID`  BIGINT(20)    NOT NULL,
  `ACTOR_ID`  BIGINT(20)    NOT NULL,
  PRIMARY KEY (`CHAPTER_ID`, `ACTOR_ID`),
  CONSTRAINT `CATEGORIES_TV_SHOWS_IBFK_1`
  FOREIGN KEY (CHAPTER_ID) REFERENCES CHAPTERS (ID),
  CONSTRAINT `CATEGORIES_TV_SHOWS_IBFK_2`
  FOREIGN KEY (ACTOR_ID) REFERENCES ACTORS (ID)
);