DELIMITER $$

CREATE PROCEDURE perechiClase()
BEGIN
	SELECT DISTINCT CONCAT(CONCAT(clase2.clasa,' - '),clase1.clasa) AS PERECHE ,clase1.tip AS TIP1,clase2.tip AS TIP2,clase1.tara
	FROM clase clase1 JOIN clase clase2 ON clase1.tara=clase2.tara
	WHERE clase1.tip!=clase2.tip AND clase1.clasa<clase2.clasa;
    
END $$

DELIMITER ;
