CREATE TABLE PAIRINGS (
  id            INTEGER NOT NULL,
  PLAYER1       CHAR,
  PLAYER2       CHAR,
  ROUNDS1       INTEGER,
  ROUND2        INTEGER,
  PRIMARY KEY (id)
);

ALTER TABLE PAIRINGS
  ADD CONSTRAINT FKpairingsplayers1 FOREIGN KEY (PLAYER1) REFERENCES PLAYER;
ALTER TABLE PAIRINGS
  ADD CONSTRAINT FKpairingsplayers2 FOREIGN KEY (PLAYER2) REFERENCES PLAYER;