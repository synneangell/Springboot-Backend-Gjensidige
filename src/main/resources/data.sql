DROP TABLE IF EXISTS kunder;

CREATE TABLE kunder (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  fornavn VARCHAR(250) NOT NULL,
  etternavn VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

INSERT INTO kunder (fornavn, etternavn, email) VALUES
  ('Per', 'Olsen', 'perolsen@gmail.com'),
  ('Lise', 'Jensen', 'lisejsn@hotmail.com'),
  ('Kari', 'Frantsen', 'karif@gmail.com');