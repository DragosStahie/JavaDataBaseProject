CREATE TABLE consecinte
(nava VARCHAR(40),
 batalie VARCHAR(40),
 rezultat VARCHAR(20),
 CONSTRAINT consecinte_primary PRIMARY KEY (nava, batalie),
 CONSTRAINT consecinte_nava_fk FOREIGN KEY (nava)
		REFERENCES nave (nume),
 CONSTRAINT consecinte_batalie_fk FOREIGN KEY (batalie)
		REFERENCES batalii (nume)
);