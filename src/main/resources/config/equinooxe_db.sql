-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 01 Janvier 2017 à 22:08
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
  `description` text,
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
  `instructions` text,
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
  `description` text,
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
('00000000000001', 'jhipster', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-01-01 20:22:24', 1, 'EXECUTED', '7:c962f621df488c2419ca7d991c18f12c', 'createTable, createIndex (x2), createTable (x2), addPrimaryKey, createTable, addForeignKeyConstraint (x3), loadData, dropDefaultValue, loadData (x2), createTable (x2), addPrimaryKey, createIndex (x2), addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL);

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
  `description` text,
  `nom` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
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
  `description` text,
  `nom` varchar(255) DEFAULT NULL,
  `batiment_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `jhi_authority`
--

CREATE TABLE IF NOT EXISTS `jhi_authority` (
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_authority`
--

INSERT INTO `jhi_authority` (`name`) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_persistent_audit_event`
--

CREATE TABLE IF NOT EXISTS `jhi_persistent_audit_event` (
`event_id` bigint(20) NOT NULL,
  `principal` varchar(50) NOT NULL,
  `event_date` timestamp NULL DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_persistent_audit_event`
--

INSERT INTO `jhi_persistent_audit_event` (`event_id`, `principal`, `event_date`, `event_type`) VALUES
(1, 'user', '2017-01-01 21:07:49', 'AUTHENTICATION_SUCCESS');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_persistent_audit_evt_data`
--

CREATE TABLE IF NOT EXISTS `jhi_persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(150) NOT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_persistent_audit_evt_data`
--

INSERT INTO `jhi_persistent_audit_evt_data` (`event_id`, `name`, `value`) VALUES
(1, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(1, 'sessionId', 'eQCS9Oc0krczSdhGkg8CBdP0_Kej_r5mQfnG0saN');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_persistent_token`
--

CREATE TABLE IF NOT EXISTS `jhi_persistent_token` (
  `series` varchar(76) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `token_value` varchar(76) NOT NULL,
  `token_date` date DEFAULT NULL,
  `ip_address` varchar(39) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_persistent_token`
--

INSERT INTO `jhi_persistent_token` (`series`, `user_id`, `token_value`, `token_date`, `ip_address`, `user_agent`) VALUES
('QfErLTkwMDOHH6kKyPGfxA==', 4, 'q+ro33aF5ZMY5oYW+Vrnkg==', '2017-01-01', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_user`
--

CREATE TABLE IF NOT EXISTS `jhi_user` (
`id` bigint(20) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(5) DEFAULT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NOT NULL,
  `reset_date` timestamp NULL DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  `user_type` varchar(31) NOT NULL,
  `is_archived` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_user`
--

INSERT INTO `jhi_user` (`id`, `login`, `password_hash`, `first_name`, `last_name`, `email`, `activated`, `lang_key`, `activation_key`, `reset_key`, `created_by`, `created_date`, `reset_date`, `last_modified_by`, `last_modified_date`, `user_type`, `is_archived`, `is_deleted`) VALUES
(1, 'system', '$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG', 'System', 'System', 'system@localhost', b'1', 'en', NULL, NULL, 'system', '2017-01-01 19:22:24', NULL, 'system', NULL, 'MANAGER', b'0', b'0'),
(2, 'anonymoususer', '$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO', 'Anonymous', 'User', 'anonymous@localhost', b'1', 'en', NULL, NULL, 'system', '2017-01-01 19:22:24', NULL, 'system', NULL, 'MANAGER', b'0', b'0'),
(3, 'admin', '$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC', 'Administrator', 'Administrator', 'admin@localhost', b'1', 'en', NULL, NULL, 'system', '2017-01-01 19:22:24', NULL, 'system', NULL, 'MANAGER', b'0', b'0'),
(4, 'user', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K', 'User', 'User', 'user@localhost', b'1', 'en', NULL, NULL, 'system', '2017-01-01 19:22:24', NULL, 'system', NULL, 'MANAGER', b'0', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_user_authority`
--

CREATE TABLE IF NOT EXISTS `jhi_user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_user_authority`
--

INSERT INTO `jhi_user_authority` (`user_id`, `authority_name`) VALUES
(1, 'ROLE_ADMIN'),
(3, 'ROLE_ADMIN'),
(1, 'ROLE_USER'),
(3, 'ROLE_USER'),
(4, 'ROLE_USER');

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
  `description` text,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agent_user`
--
ALTER TABLE `agent_user`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `batiment`
--
ALTER TABLE `batiment`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_80v7m4cobyygbptybvs9uee1f` (`nom`);

--
-- Index pour la table `clean_request`
--
ALTER TABLE `clean_request`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_od9ctm7ihf2537a822li2p7q0` (`agent_id`), ADD KEY `FK_4y28s5u2o12b41lk5vpwm34a4` (`espace_id`), ADD KEY `FK_kac2a9oa0esuvl0lfulhbvvq6` (`manager_id`);

--
-- Index pour la table `clean_task`
--
ALTER TABLE `clean_task`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_5mafikufxoyahpccyj1s43jjw` (`name`), ADD KEY `FK_okhyxpn8xqeeme6pcyi1tm36e` (`clean_request_id`), ADD KEY `FK_p0f07wqjg9kwc6ovea30hdojs` (`tache_definition_id`);

--
-- Index pour la table `databasechangeloglock`
--
ALTER TABLE `databasechangeloglock`
 ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `espace`
--
ALTER TABLE `espace`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_luex3jx9ohhcmda8kjapkfm35` (`nom`), ADD UNIQUE KEY `UK_a7k93u17l6tqfp7qspsxy7dhb` (`number`), ADD KEY `FK_3ggpqsc352i195b60gk4xlab4` (`etage_id`);

--
-- Index pour la table `etage`
--
ALTER TABLE `etage`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_csnl8v4e9ylly6fo6s0eltrsy` (`nom`), ADD KEY `FK_o4bek7j9ca9vpr656949hs3pw` (`batiment_id`);

--
-- Index pour la table `jhi_authority`
--
ALTER TABLE `jhi_authority`
 ADD PRIMARY KEY (`name`);

--
-- Index pour la table `jhi_persistent_audit_event`
--
ALTER TABLE `jhi_persistent_audit_event`
 ADD PRIMARY KEY (`event_id`), ADD KEY `idx_persistent_audit_event` (`principal`,`event_date`);

--
-- Index pour la table `jhi_persistent_audit_evt_data`
--
ALTER TABLE `jhi_persistent_audit_evt_data`
 ADD PRIMARY KEY (`event_id`,`name`), ADD KEY `idx_persistent_audit_evt_data` (`event_id`);

--
-- Index pour la table `jhi_persistent_token`
--
ALTER TABLE `jhi_persistent_token`
 ADD PRIMARY KEY (`series`), ADD KEY `fk_user_persistent_token` (`user_id`);

--
-- Index pour la table `jhi_user`
--
ALTER TABLE `jhi_user`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `login` (`login`), ADD UNIQUE KEY `idx_user_login` (`login`), ADD UNIQUE KEY `email` (`email`), ADD UNIQUE KEY `idx_user_email` (`email`);

--
-- Index pour la table `jhi_user_authority`
--
ALTER TABLE `jhi_user_authority`
 ADD PRIMARY KEY (`user_id`,`authority_name`), ADD KEY `fk_authority_name` (`authority_name`);

--
-- Index pour la table `manager_utilisateur`
--
ALTER TABLE `manager_utilisateur`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tache_definition`
--
ALTER TABLE `tache_definition`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_3uye76hjqlsk3bhycgx3bxy8o` (`nom`);

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
-- AUTO_INCREMENT pour la table `jhi_persistent_audit_event`
--
ALTER TABLE `jhi_persistent_audit_event`
MODIFY `event_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `jhi_user`
--
ALTER TABLE `jhi_user`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `tache_definition`
--
ALTER TABLE `tache_definition`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `agent_user`
--
ALTER TABLE `agent_user`
ADD CONSTRAINT `FK_fom2d002mq3abaa79ws8xnqdr` FOREIGN KEY (`id`) REFERENCES `jhi_user` (`id`);

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
-- Contraintes pour la table `jhi_persistent_audit_evt_data`
--
ALTER TABLE `jhi_persistent_audit_evt_data`
ADD CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`);

--
-- Contraintes pour la table `jhi_persistent_token`
--
ALTER TABLE `jhi_persistent_token`
ADD CONSTRAINT `fk_user_persistent_token` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`);

--
-- Contraintes pour la table `jhi_user_authority`
--
ALTER TABLE `jhi_user_authority`
ADD CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`),
ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`);

--
-- Contraintes pour la table `manager_utilisateur`
--
ALTER TABLE `manager_utilisateur`
ADD CONSTRAINT `FK_fy7ebpa8ximlk7fn97owdrh5w` FOREIGN KEY (`id`) REFERENCES `jhi_user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
