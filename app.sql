-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  lun. 14 mai 2018 à 17:59
-- Version du serveur :  10.1.28-MariaDB
-- Version de PHP :  5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `app`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `login`, `pwd`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `id` int(11) NOT NULL,
  `designation` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `designation`) VALUES
(1, '1e'),
(2, '2e');

-- --------------------------------------------------------

--
-- Structure de la table `concours`
--

CREATE TABLE `concours` (
  `idConcours` int(11) NOT NULL,
  `idEleve` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `nbreReussites` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `concours`
--

INSERT INTO `concours` (`idConcours`, `idEleve`, `date`, `nbreReussites`) VALUES
(2, 2, '2018-05-10', 9),
(3, 2, '2018-05-09', 11),
(4, 3, '2018-05-02', 12),
(5, 4, '2018-05-30', 5),
(6, 4, '2018-06-06', 8);

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

CREATE TABLE `eleve` (
  `id` int(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `genre` varchar(10) NOT NULL,
  `dateNaissance` date NOT NULL,
  `classe` int(11) DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`id`, `nom`, `prenom`, `genre`, `dateNaissance`, `classe`, `login`, `pwd`) VALUES
(1, 'spratty', 'diany', 'm', '2018-05-08', 1, 'eleve1', 'eleve1'),
(2, 'benj', 'smile', 'm', '2018-12-12', 1, 'eleve2', 'eleve2'),
(3, 'mireille', 'mireille', 'f', '2018-05-01', 2, NULL, NULL),
(4, 'dany', 'daniel', 'm', '2018-05-09', 1, 'dany', 'daniel'),
(5, 'benj', 'smile', 'm', '2018-12-12', 2, NULL, NULL),
(6, 'dkiss', 'dkiss', 'm', '2014-12-12', 1, NULL, NULL),
(7, 'pierre', 'pierre', 'm', '2001-10-10', 2, NULL, NULL),
(8, 'spratty', 'diany', 'm', '2018-05-08', 2, NULL, NULL),
(9, 'caleb', 'caleb', 'm', '1996-06-01', 1, 'caleb', 'caleb');

-- --------------------------------------------------------

--
-- Structure de la table `exercice`
--

CREATE TABLE `exercice` (
  `id` int(11) NOT NULL,
  `idConcours` int(11) DEFAULT NULL,
  `idMot` int(11) DEFAULT NULL,
  `resultat` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `exercice`
--

INSERT INTO `exercice` (`id`, `idConcours`, `idMot`, `resultat`) VALUES
(1, 2, 1, 'correct'),
(2, 2, 1, 'correct'),
(3, 2, 1, 'correct'),
(4, 2, 1, 'incorrect'),
(5, 2, 1, 'correct'),
(6, 2, 1, 'correct'),
(7, 2, 1, 'incorrect'),
(8, 2, 1, 'correct'),
(9, 2, 1, 'correct'),
(10, 2, 1, 'correct'),
(11, 2, 1, 'incorrect'),
(12, 2, 1, 'correct');

-- --------------------------------------------------------

--
-- Structure de la table `mot`
--

CREATE TABLE `mot` (
  `id` int(20) NOT NULL,
  `francais` varchar(20) NOT NULL,
  `swahili` varchar(20) NOT NULL,
  `lingala` varchar(20) NOT NULL,
  `anglais` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `mot`
--

INSERT INTO `mot` (`id`, `francais`, `swahili`, `lingala`, `anglais`) VALUES
(1, 'table', 'meza', 'mesa', 'table'),
(2, 'cuisine', 'mafiga', 'makusa', 'kitchen'),
(3, 'machine', 'machine', 'machine', 'machine'),
(4, 'moi', 'miye', 'ngai', 'me');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `concours`
--
ALTER TABLE `concours`
  ADD PRIMARY KEY (`idConcours`),
  ADD KEY `idEleve` (`idEleve`);

--
-- Index pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classe` (`classe`);

--
-- Index pour la table `exercice`
--
ALTER TABLE `exercice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idConcours` (`idConcours`),
  ADD KEY `idMot` (`idMot`);

--
-- Index pour la table `mot`
--
ALTER TABLE `mot`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `concours`
--
ALTER TABLE `concours`
  MODIFY `idConcours` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `eleve`
--
ALTER TABLE `eleve`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `exercice`
--
ALTER TABLE `exercice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `mot`
--
ALTER TABLE `mot`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `concours`
--
ALTER TABLE `concours`
  ADD CONSTRAINT `concours_ibfk_1` FOREIGN KEY (`idEleve`) REFERENCES `eleve` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `eleve_ibfk_1` FOREIGN KEY (`classe`) REFERENCES `classe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `exercice`
--
ALTER TABLE `exercice`
  ADD CONSTRAINT `exercice_ibfk_1` FOREIGN KEY (`idMot`) REFERENCES `mot` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `exercice_ibfk_2` FOREIGN KEY (`idConcours`) REFERENCES `concours` (`idConcours`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
