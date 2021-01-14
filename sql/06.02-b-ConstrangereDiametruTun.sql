ALTER TABLE clase
ADD CONSTRAINT diametru_tun_ck CHECK (tip = 'vl' OR diametru_tun >= 15 OR nr_arme >= 10);