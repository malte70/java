CREATE DATABASE itc_java_konto;
USE itc_java_konto;
CREATE USER itc@localhost;
GRANT ALL PRIVILEGES ON `itc\_%`.* TO itc@localhost IDENTIFIED BY "9767";
CREATE TABLE buchungen (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	kontonr VARCHAR(9) NOT NULL,
	betrag INT NOT NULL,
	datum DATETIME NOT NULL
);
CREATE TABLE konten (
	id VARCHAR(25) NOT NULL PRIMARY KEY,
	inhaber VARCHAR(120) NOT NULL,
	zinssatz INT NOT NULL DEFAULT 5
);
