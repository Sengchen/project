SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS sys_permission;
DROP TABLE IF EXISTS sys_permission_role;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_role_user;
DROP TABLE IF EXISTS sys_user;




/* Create Tables */

-- sys user permission
CREATE TABLE sys_permission
(
	-- id
	id int(11) NOT NULL COMMENT 'id',
	-- name
	name varchar(50) NOT NULL COMMENT 'name',
	-- description
	description varchar(50) NOT NULL COMMENT 'description',
	-- url
	url varchar(50) COMMENT 'url',
	-- pid
	pid int(11) COMMENT 'pid',
	PRIMARY KEY (id),
	UNIQUE (id)
) COMMENT = 'sys user permission';


-- sys user permission and role relations
CREATE TABLE sys_permission_role
(
	-- id
	id int(11) NOT NULL COMMENT 'id',
	-- role id
	role_id int(11) NOT NULL COMMENT 'role id',
	-- permission id
	permission_id int(11) COMMENT 'permission id',
	PRIMARY KEY (id),
	UNIQUE (id)
) COMMENT = 'sys user permission and role relations';


-- sys role table
CREATE TABLE sys_role
(
	-- id
	id int(11) NOT NULL COMMENT 'id',
	-- name
	name varchar(50) NOT NULL COMMENT 'name',
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (name)
) COMMENT = 'sys role table';


-- sys user and role relations
CREATE TABLE sys_role_user
(
	-- id
	id int(11) NOT NULL COMMENT 'id',
	-- sys_user_id
	sys_user_id int(11) NOT NULL COMMENT 'sys_user_id',
	-- sys_role_id
	sys_role_id int(11) NOT NULL COMMENT 'sys_role_id',
	UNIQUE (id)
) COMMENT = 'sys user and role relations';


-- sys user table
CREATE TABLE sys_user
(
	-- id
	id int(11) NOT NULL COMMENT 'id',
	-- account
	account varchar(50) NOT NULL COMMENT 'account',
	-- password
	password varchar(50) COMMENT 'password',
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (account)
) COMMENT = 'sys user table';



