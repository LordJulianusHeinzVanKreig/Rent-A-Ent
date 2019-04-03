-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 03. Apr 2019 um 14:11
-- Server-Version: 10.1.36-MariaDB
-- PHP-Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `rent-a-ent_database`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `customer`
--

CREATE TABLE `customer` (
  `firstName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `houseNumber` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `zipCode` int(11) NOT NULL,
  `street` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phoneNumber` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ducks`
--

CREATE TABLE `ducks` (
  `age` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `temperament` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `gender` int(11) NOT NULL,
  `ducktypeID` int(11) NOT NULL,
  `locationID` int(11) NOT NULL,
  `customerID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ducktype`
--

CREATE TABLE `ducktype` (
  `breedTime` date NOT NULL,
  `region` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `maxAge` int(11) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `ducktype`
--

INSERT INTO `ducktype` (`breedTime`, `region`, `maxAge`, `ID`) VALUES
('0000-00-00', 'Oberpfalz', 12, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `location`
--

CREATE TABLE `location` (
  `street` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `zipCode` int(11) NOT NULL,
  `houseNumber` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ID` int(11) NOT NULL,
  `LeaderID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `worker`
--

CREATE TABLE `worker` (
  `firstName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `houseNumber` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `zipCode` int(11) NOT NULL,
  `street` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phoneNumber` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ID` int(11) NOT NULL,
  `locationID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `ducks`
--
ALTER TABLE `ducks`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `ducktype`
--
ALTER TABLE `ducktype`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT für Tabelle `location`
--
ALTER TABLE `location`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `worker`
--
ALTER TABLE `worker`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `ducks` (`customerID`);

--
-- Constraints der Tabelle `ducks`
--
ALTER TABLE `ducks`
  ADD CONSTRAINT `ducks_ibfk_1` FOREIGN KEY (`ducktypeID`) REFERENCES `ducktype` (`ID`);

--
-- Constraints der Tabelle `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `ducks` (`locationID`);

--
-- Constraints der Tabelle `worker`
--
ALTER TABLE `worker`
  ADD CONSTRAINT `worker_ibfk_1` FOREIGN KEY (`locationID`) REFERENCES `location` (`ID`),
  ADD CONSTRAINT `worker_ibfk_2` FOREIGN KEY (`ID`) REFERENCES `location` (`LeaderID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
