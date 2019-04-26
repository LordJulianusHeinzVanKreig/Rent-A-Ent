-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 23. Apr 2019 um 14:43
-- Server-Version: 10.1.38-MariaDB
-- PHP-Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `rentaent`
--
CREATE DATABASE IF NOT EXISTS `rentaent` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `rentaent`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `firstName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `houseNumber` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `zipCode` int(11) NOT NULL,
  `street` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phoneNumber` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `customer`
--

INSERT INTO `customer` (`firstName`, `lastName`, `houseNumber`, `zipCode`, `street`, `phoneNumber`, `ID`) VALUES
('Merlin', 'Fritzl', '123', 1234, 'Heislstrass', '12345', 3),
('Ivan', 'Fritzl', '123', 1234, 'Heislstrass', '12345', 4);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ducks`
--

DROP TABLE IF EXISTS `ducks`;
CREATE TABLE `ducks` (
  `age` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `temperament` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `gender` tinyint(1) NOT NULL DEFAULT '0',
  `ducktypeID` int(11) NOT NULL,
  `locationID` int(11) DEFAULT NULL,
  `customerID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `ducks`
--

INSERT INTO `ducks` (`age`, `name`, `description`, `temperament`, `ID`, `gender`, `ducktypeID`, `locationID`, `customerID`) VALUES
(2, 'Dagobert', 'Hat geld', 12, 1, 0, 1, 1, 4),
(30000, 'Quaekling', 'Quackt oft', 0, 2, 0, 1, 1, 3),
(5, 'Track', 'Furzt viel', 10, 9, 1, 1, 1, 4),
(2, 'Siggi Soße', 'ballert', 2, 10, 1, 3, 1, 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ducktype`
--

DROP TABLE IF EXISTS `ducktype`;
CREATE TABLE `ducktype` (
  `breedTime` int(11) NOT NULL,
  `region` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `maxAge` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `ducktype`
--

INSERT INTO `ducktype` (`breedTime`, `region`, `maxAge`, `ID`, `Name`) VALUES
(0, 'Oberpfalz', 12, 1, 'Sehr gemeine Hausente'),
(1234, 'Erzgebirge Aue', 12345, 2, 'Heinz'),
(17, 'Erzgebirge Aue', 3, 3, 'Guntersente');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `street` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `zipCode` int(11) NOT NULL,
  `houseNumber` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ID` int(11) NOT NULL,
  `LeaderID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `location`
--

INSERT INTO `location` (`street`, `zipCode`, `houseNumber`, `ID`, `LeaderID`) VALUES
('Zwiebelstraße', 22, '0', 1, 2),
('Kecksemmelstraße', 99999, '1002', 2, 6);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `worker`
--

DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `firstName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `houseNumber` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `zipCode` int(11) NOT NULL,
  `street` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phoneNumber` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ID` int(11) NOT NULL,
  `locationID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `worker`
--

INSERT INTO `worker` (`firstName`, `lastName`, `houseNumber`, `zipCode`, `street`, `phoneNumber`, `ID`, `locationID`) VALUES
('Gruebi', 'Arbeitstier', '22', 1, 'Entenweg', '1234', 1, 1),
('Dechant', 'Herrscher', '2b', 8876, 'Jennerweg', '2', 2, 1),
('Gunter', 'Zwiebel', '234', 1234, 'elfstraße', '234', 3, 1),
('Kevin', 'Cool', '21', 93059, 'KCStraße', '123', 4, 1),
('Domi', 'Zerstörer', '33', 8483, 'Zerstörerstraße', '2344', 5, 1),
('Fritz', 'VanDick', '34', 8888, 'achtstraße', '08002222222', 6, 2);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `ducks`
--
ALTER TABLE `ducks`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ducktypeID` (`ducktypeID`),
  ADD KEY `locationID` (`locationID`),
  ADD KEY `customerID` (`customerID`);

--
-- Indizes für die Tabelle `ducktype`
--
ALTER TABLE `ducktype`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `LeaderID` (`LeaderID`);

--
-- Indizes für die Tabelle `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `locationID` (`locationID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `ducks`
--
ALTER TABLE `ducks`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT für Tabelle `ducktype`
--
ALTER TABLE `ducktype`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `location`
--
ALTER TABLE `location`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `worker`
--
ALTER TABLE `worker`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `ducks`
--
ALTER TABLE `ducks`
  ADD CONSTRAINT `ducks_ibfk_1` FOREIGN KEY (`ducktypeID`) REFERENCES `ducktype` (`ID`),
  ADD CONSTRAINT `ducks_ibfk_2` FOREIGN KEY (`customerID`) REFERENCES `customer` (`ID`),
  ADD CONSTRAINT `ducks_ibfk_3` FOREIGN KEY (`locationID`) REFERENCES `location` (`ID`);

--
-- Constraints der Tabelle `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`LeaderID`) REFERENCES `worker` (`ID`);

--
-- Constraints der Tabelle `worker`
--
ALTER TABLE `worker`
  ADD CONSTRAINT `worker_ibfk_1` FOREIGN KEY (`locationID`) REFERENCES `location` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
