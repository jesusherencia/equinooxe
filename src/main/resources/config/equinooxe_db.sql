-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 12 Février 2017 à 22:13
-- Version du serveur :  5.6.21
-- Version de PHP :  5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `equinooxe`
--

-- --------------------------------------------------------

--
-- Structure de la table `agent_user`
--

CREATE TABLE IF NOT EXISTS `agent_user` (
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `authority`
--

CREATE TABLE IF NOT EXISTS `authority` (
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `authority`
--

INSERT INTO `authority` (`name`) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `batiment`
--

CREATE TABLE IF NOT EXISTS `batiment` (
`id` bigint(20) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `is_archived` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `description` longtext,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `clean_request`
--

CREATE TABLE IF NOT EXISTS `clean_request` (
`id` bigint(20) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `is_archived` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `deadline_date` datetime DEFAULT NULL,
  `done_at` datetime DEFAULT NULL,
  `instructions` longtext,
  `start_at` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `agent_id` bigint(20) DEFAULT NULL,
  `espace_id` bigint(20) DEFAULT NULL,
  `manager_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `clean_task`
--

CREATE TABLE IF NOT EXISTS `clean_task` (
`id` bigint(20) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `is_archived` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` longtext,
  `done` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `clean_request_id` bigint(20) DEFAULT NULL,
  `tache_definition_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `databasechangelog`
--

CREATE TABLE IF NOT EXISTS `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `databasechangelog`
--

INSERT INTO `databasechangelog` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`) VALUES
('1486933008723-1', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:17', 1, 'EXECUTED', '7:4ce0cdb5b73772e8c3ffed46c6712fe9', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-2', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:17', 2, 'EXECUTED', '7:75c9d1d107c6df8c8f8b7234cf4dab07', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-3', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:17', 3, 'EXECUTED', '7:b0bc44136313b591944f5efe3fbc2ebb', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-4', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:17', 4, 'EXECUTED', '7:5938ef09700a1ad16430b1c5ee1574ad', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-5', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:17', 5, 'EXECUTED', '7:8c0f361b7fdc53d5e50345a0190c1ce4', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-6', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:17', 6, 'EXECUTED', '7:2d5c6b61c2f74d0cb1721a78d7f7f25d', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-7', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:17', 7, 'EXECUTED', '7:af8d1c04c4530048011c46830d5e6fc7', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-8', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:17', 8, 'EXECUTED', '7:94392c989e563ddcc4e7a9cfa83eeb13', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-9', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:17', 9, 'EXECUTED', '7:93c70a8d087c7af9503028a62a88bc57', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-10', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 10, 'EXECUTED', '7:0cb8679fe0162eb920f6033fcfcdffb4', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-11', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 11, 'EXECUTED', '7:a68f9c3b16e05ede45ce632a5974eae8', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-12', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 12, 'EXECUTED', '7:42799e7babee592a60b4332fd3d109b6', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-13', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 13, 'EXECUTED', '7:7b81c6cdf11349b20a3b8c9ff5056c6d', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-14', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 14, 'EXECUTED', '7:05ba773787522f764b72707282ec4630', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-15', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 15, 'EXECUTED', '7:3415a68031aea169489c7917648fa189', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-16', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 16, 'EXECUTED', '7:ecccee751aade7c0ae264c3432734f04', 'addPrimaryKey', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-17', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 17, 'EXECUTED', '7:3540d0f1dd839bbca54511bb48384dab', 'addPrimaryKey', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-18', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 18, 'EXECUTED', '7:d92a688bd21f2366f47f9b1ee9cba917', 'addPrimaryKey', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-19', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 19, 'EXECUTED', '7:ebdd3d38eab797bc9926f94575198373', 'addPrimaryKey', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-20', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 20, 'EXECUTED', '7:8dd64f24058dc8e60c467b1d49be2a7d', 'addPrimaryKey', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-21', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 21, 'EXECUTED', '7:9298a4d3ad8b1bec686b94553e1162ab', 'addPrimaryKey', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-22', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 22, 'EXECUTED', '7:d0d16459f4e555559e501d9ac5720cf6', 'addUniqueConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-23', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 23, 'EXECUTED', '7:65517c2adee1c230e5b26034f5a2062f', 'addUniqueConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-24', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 24, 'EXECUTED', '7:7c5e1c36fd0ff9b6092efc33da0174b2', 'addUniqueConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-25', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 25, 'EXECUTED', '7:36f79dbdc6c50a3195ad349972609389', 'addUniqueConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-26', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 26, 'EXECUTED', '7:50d3ab4e501723154db0a83f1115f1b3', 'addUniqueConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-27', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 27, 'EXECUTED', '7:bcc0da208523fa73eb32b1792283e5b1', 'addUniqueConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-28', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 28, 'EXECUTED', '7:685b64e5aa4c54ccd21d39c095191a66', 'addUniqueConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-29', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 29, 'EXECUTED', '7:d42fa37ec6fc26903045db6d3289a016', 'addUniqueConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-30', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 30, 'EXECUTED', '7:747d2d33c41973fc0f9b2a1ab1711740', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-31', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 31, 'EXECUTED', '7:0f65057a6bfc47a226f6c0e4857ada17', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-32', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 32, 'EXECUTED', '7:ad0343797e548582ca57d7d932c18c36', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-33', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 33, 'EXECUTED', '7:f46472a3af6e57bf8de8facad09bdcfe', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-34', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 34, 'EXECUTED', '7:d3c551fda6694ec172f56587a33687de', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-35', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 35, 'EXECUTED', '7:5527a587a1950282935f1c057cfc323f', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-36', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 36, 'EXECUTED', '7:dbee63db832db60a37a6a3ffb4ee4c9b', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-37', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 37, 'EXECUTED', '7:ac04deff2648e57201725d7674b59205', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-38', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 38, 'EXECUTED', '7:536761422be31d847ba484d5bd4c0f02', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-39', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 39, 'EXECUTED', '7:99b2309f70f6b4692a642ae6d2ba47b9', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-40', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 40, 'EXECUTED', '7:1b5552b874989b9c59c82ee0a60847cf', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-41', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 41, 'EXECUTED', '7:a6b555f2d08adfa5413e089c42d61c15', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-42', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 42, 'EXECUTED', '7:173318cce97f74ff51695cb31e106abb', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1486933008723-43', 'mboullouz (generated)', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-02-12 21:57:18', 43, 'EXECUTED', '7:b7bbd7874d31d8dd80cc1368d70cb851', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `databasechangeloglock`
--

CREATE TABLE IF NOT EXISTS `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `databasechangeloglock`
--

INSERT INTO `databasechangeloglock` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `espace`
--

CREATE TABLE IF NOT EXISTS `espace` (
`id` bigint(20) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `is_archived` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` longtext,
  `nom` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `etage_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etage`
--

CREATE TABLE IF NOT EXISTS `etage` (
`id` bigint(20) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `is_archived` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` longtext,
  `nom` varchar(255) DEFAULT NULL,
  `batiment_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `manager_utilisateur`
--

CREATE TABLE IF NOT EXISTS `manager_utilisateur` (
  `phone_interne` varchar(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
`id` bigint(20) NOT NULL,
  `add_at` datetime DEFAULT NULL,
  `message` longtext,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `persistent_audit_event`
--

CREATE TABLE IF NOT EXISTS `persistent_audit_event` (
`event_id` bigint(20) NOT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `principal` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `persistent_audit_event`
--

INSERT INTO `persistent_audit_event` (`event_id`, `event_date`, `event_type`, `principal`) VALUES
(1, '2017-02-12 22:05:29', 'AUTHENTICATION_SUCCESS', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `persistent_audit_evt_data`
--

CREATE TABLE IF NOT EXISTS `persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `persistent_audit_evt_data`
--

INSERT INTO `persistent_audit_evt_data` (`event_id`, `value`, `name`) VALUES
(1, '0:0:0:0:0:0:0:1', 'remoteAddress'),
(1, '8w2L9K_65mwQR4z944gpCiympG17zWn95fxY_pZp', 'sessionId');

-- --------------------------------------------------------

--
-- Structure de la table `persistent_token`
--

CREATE TABLE IF NOT EXISTS `persistent_token` (
  `series` varchar(255) NOT NULL,
  `ip_address` varchar(39) DEFAULT NULL,
  `token_date` date DEFAULT NULL,
  `token_value` varchar(255) NOT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `persistent_token`
--

INSERT INTO `persistent_token` (`series`, `ip_address`, `token_date`, `token_value`, `user_agent`, `user_id`) VALUES
('UXJ1v6dlj8E6BqTwJEKK7A==', '0:0:0:0:0:0:0:1', '2017-02-12', '/yHuvTw+YRH8JWkVcAR3Eg==', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', 2);

-- --------------------------------------------------------

--
-- Structure de la table `tache_definition`
--

CREATE TABLE IF NOT EXISTS `tache_definition` (
`id` bigint(20) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `is_archived` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` longtext,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_type` varchar(31) NOT NULL,
`id` bigint(20) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `is_archived` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `civilite` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `lang_key` varchar(5) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) DEFAULT NULL,
  `reset_date` datetime DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`user_type`, `id`, `created_by`, `created_date`, `is_archived`, `is_deleted`, `last_modified_by`, `last_modified_date`, `activated`, `activation_key`, `civilite`, `email`, `first_name`, `lang_key`, `last_name`, `login`, `password_hash`, `reset_date`, `reset_key`) VALUES
('MANAGER', 2, 'anonymousUser', '2017-02-12 22:03:17', b'0', b'0', 'anonymousUser', '2017-02-12 22:03:17', b'1', '49592928532452156164', 'Mr', 'admin@admin.com', 'SUPER M', 'en', 'Manager', 'admin', '$2a$10$aNZLbR8m1Dq6ZKwssC7GmOrKsF9cMGJNMmQ7aBvBFfMaMt/F5NH2q', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user_authority`
--

CREATE TABLE IF NOT EXISTS `user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_authority`
--

INSERT INTO `user_authority` (`user_id`, `authority_name`) VALUES
(2, 'ROLE_USER');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agent_user`
--
ALTER TABLE `agent_user`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `authority`
--
ALTER TABLE `authority`
 ADD PRIMARY KEY (`name`);

--
-- Index pour la table `batiment`
--
ALTER TABLE `batiment`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UC_BATIMENTNOM_COL` (`nom`);

--
-- Index pour la table `clean_request`
--
ALTER TABLE `clean_request`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_4y28s5u2o12b41lk5vpwm34a4` (`espace_id`), ADD KEY `FK_kac2a9oa0esuvl0lfulhbvvq6` (`manager_id`), ADD KEY `FK_od9ctm7ihf2537a822li2p7q0` (`agent_id`);

--
-- Index pour la table `clean_task`
--
ALTER TABLE `clean_task`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UC_CLEAN_TASKNAME_COL` (`name`), ADD KEY `FK_okhyxpn8xqeeme6pcyi1tm36e` (`clean_request_id`), ADD KEY `FK_p0f07wqjg9kwc6ovea30hdojs` (`tache_definition_id`);

--
-- Index pour la table `databasechangeloglock`
--
ALTER TABLE `databasechangeloglock`
 ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `espace`
--
ALTER TABLE `espace`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UC_ESPACENOM_COL` (`nom`), ADD UNIQUE KEY `UC_ESPACENUMERO_COL` (`numero`), ADD KEY `FK_3ggpqsc352i195b60gk4xlab4` (`etage_id`);

--
-- Index pour la table `etage`
--
ALTER TABLE `etage`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UC_ETAGENOM_COL` (`nom`), ADD KEY `FK_o4bek7j9ca9vpr656949hs3pw` (`batiment_id`);

--
-- Index pour la table `manager_utilisateur`
--
ALTER TABLE `manager_utilisateur`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `notification`
--
ALTER TABLE `notification`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_1urdwwsh2ti15ta6f6p5dbdcp` (`user_id`);

--
-- Index pour la table `persistent_audit_event`
--
ALTER TABLE `persistent_audit_event`
 ADD PRIMARY KEY (`event_id`);

--
-- Index pour la table `persistent_audit_evt_data`
--
ALTER TABLE `persistent_audit_evt_data`
 ADD PRIMARY KEY (`event_id`,`name`);

--
-- Index pour la table `persistent_token`
--
ALTER TABLE `persistent_token`
 ADD PRIMARY KEY (`series`), ADD KEY `FK_gnmx6upplispd97ynh0p5ao8u` (`user_id`);

--
-- Index pour la table `tache_definition`
--
ALTER TABLE `tache_definition`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UC_TACHE_DEFINITIONNOM_COL` (`nom`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UC_USERLOGIN_COL` (`login`), ADD UNIQUE KEY `UC_USEREMAIL_COL` (`email`);

--
-- Index pour la table `user_authority`
--
ALTER TABLE `user_authority`
 ADD PRIMARY KEY (`user_id`,`authority_name`), ADD KEY `FK_tnnyxjpcvg2aj0d0i6ufnabm2` (`authority_name`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `batiment`
--
ALTER TABLE `batiment`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `clean_request`
--
ALTER TABLE `clean_request`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `clean_task`
--
ALTER TABLE `clean_task`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `espace`
--
ALTER TABLE `espace`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `etage`
--
ALTER TABLE `etage`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `notification`
--
ALTER TABLE `notification`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `persistent_audit_event`
--
ALTER TABLE `persistent_audit_event`
MODIFY `event_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `tache_definition`
--
ALTER TABLE `tache_definition`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `agent_user`
--
ALTER TABLE `agent_user`
ADD CONSTRAINT `FK_fom2d002mq3abaa79ws8xnqdr` FOREIGN KEY (`id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `clean_request`
--
ALTER TABLE `clean_request`
ADD CONSTRAINT `FK_4y28s5u2o12b41lk5vpwm34a4` FOREIGN KEY (`espace_id`) REFERENCES `espace` (`id`),
ADD CONSTRAINT `FK_kac2a9oa0esuvl0lfulhbvvq6` FOREIGN KEY (`manager_id`) REFERENCES `manager_utilisateur` (`id`),
ADD CONSTRAINT `FK_od9ctm7ihf2537a822li2p7q0` FOREIGN KEY (`agent_id`) REFERENCES `agent_user` (`id`);

--
-- Contraintes pour la table `clean_task`
--
ALTER TABLE `clean_task`
ADD CONSTRAINT `FK_okhyxpn8xqeeme6pcyi1tm36e` FOREIGN KEY (`clean_request_id`) REFERENCES `clean_request` (`id`),
ADD CONSTRAINT `FK_p0f07wqjg9kwc6ovea30hdojs` FOREIGN KEY (`tache_definition_id`) REFERENCES `tache_definition` (`id`);

--
-- Contraintes pour la table `espace`
--
ALTER TABLE `espace`
ADD CONSTRAINT `FK_3ggpqsc352i195b60gk4xlab4` FOREIGN KEY (`etage_id`) REFERENCES `etage` (`id`);

--
-- Contraintes pour la table `etage`
--
ALTER TABLE `etage`
ADD CONSTRAINT `FK_o4bek7j9ca9vpr656949hs3pw` FOREIGN KEY (`batiment_id`) REFERENCES `batiment` (`id`);

--
-- Contraintes pour la table `manager_utilisateur`
--
ALTER TABLE `manager_utilisateur`
ADD CONSTRAINT `FK_fy7ebpa8ximlk7fn97owdrh5w` FOREIGN KEY (`id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
ADD CONSTRAINT `FK_1urdwwsh2ti15ta6f6p5dbdcp` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `persistent_audit_evt_data`
--
ALTER TABLE `persistent_audit_evt_data`
ADD CONSTRAINT `FK_4jg177onm6l5jpjgx7rxvtntp` FOREIGN KEY (`event_id`) REFERENCES `persistent_audit_event` (`event_id`);

--
-- Contraintes pour la table `persistent_token`
--
ALTER TABLE `persistent_token`
ADD CONSTRAINT `FK_gnmx6upplispd97ynh0p5ao8u` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `user_authority`
--
ALTER TABLE `user_authority`
ADD CONSTRAINT `FK_5losscgu02yaej7prap7o6g5s` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
ADD CONSTRAINT `FK_tnnyxjpcvg2aj0d0i6ufnabm2` FOREIGN KEY (`authority_name`) REFERENCES `authority` (`name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
