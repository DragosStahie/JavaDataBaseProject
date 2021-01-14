CREATE TABLE nave
(nume VARCHAR(20),
 clasa VARCHAR(20),
 anul_lansarii INT,
 CONSTRAINT nave_nume_pk PRIMARY KEY (nume),
 CONSTRAINT nave_clasa_fk FOREIGN KEY (clasa)
		REFERENCES clase (clasa)
);