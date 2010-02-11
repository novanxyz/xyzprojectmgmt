ALTER TABLE departments DROP PRIMARY KEY;

ALTER TABLE audittrail DROP PRIMARY KEY;

ALTER TABLE tasks DROP PRIMARY KEY;

ALTER TABLE users DROP PRIMARY KEY;

ALTER TABLE contacts DROP PRIMARY KEY;

ALTER TABLE projects DROP PRIMARY KEY;

ALTER TABLE project_contacts DROP PRIMARY KEY;

ALTER TABLE modules DROP PRIMARY KEY;

ALTER TABLE permissions DROP PRIMARY KEY;

ALTER TABLE task_departements DROP PRIMARY KEY;

ALTER TABLE roles DROP PRIMARY KEY;

ALTER TABLE addresses DROP PRIMARY KEY;

ALTER TABLE session DROP PRIMARY KEY;

ALTER TABLE task_contacts DROP PRIMARY KEY;

ALTER TABLE consultants DROP PRIMARY KEY;

ALTER TABLE employees DROP PRIMARY KEY;

ALTER TABLE companies DROP PRIMARY KEY;

ALTER TABLE departments DROP INDEX FK1F3A27612FD9A0E0;

ALTER TABLE departments DROP INDEX FK1F3A276135BA5FCE;

ALTER TABLE permissions DROP INDEX FK4392F4849F828826;

ALTER TABLE employees DROP INDEX employee_nik;

ALTER TABLE employees DROP INDEX employee_contact;

ALTER TABLE tasks DROP INDEX FK6907B8E67A7B558;

ALTER TABLE consultants DROP INDEX consultant_employment;

ALTER TABLE task_departements DROP INDEX FK7F1A2FEA961A81F;

ALTER TABLE project_contacts DROP INDEX contact_id;

ALTER TABLE task_departements DROP INDEX FK7F1A2FEA4873BBA;

ALTER TABLE permissions DROP INDEX FK4392F4849F7FB17C;

ALTER TABLE task_contacts DROP INDEX FKDEAFC1CDA4873BBA;

ALTER TABLE audittrail DROP INDEX FK6608870B650A999A;

ALTER TABLE project_contacts DROP INDEX FK9752B2B9DB5D86FA;

ALTER TABLE departments DROP INDEX FK1F3A2761FF1F2C24;

ALTER TABLE projects DROP INDEX FKC479187A45DAD9B4;

ALTER TABLE task_contacts DROP INDEX FKDEAFC1CDA446159A;

ALTER TABLE roles DROP INDEX FK67A8EBDF7634DFA;

ALTER TABLE tasks DROP INDEX FK6907B8E4E2FF364;

DROP TABLE companies;

DROP TABLE contacts;

DROP TABLE users;

DROP TABLE modules;

DROP TABLE consultants;

DROP TABLE roles;

DROP TABLE departments;

DROP TABLE addresses;

DROP TABLE session;

DROP TABLE audittrail;

DROP TABLE projects;

DROP TABLE tasks;

DROP TABLE task_departements;

DROP TABLE task_contacts;

DROP TABLE employees;

DROP TABLE permissions;

DROP TABLE project_contacts;

CREATE TABLE companies (
	company_id BIGINT NOT NULL,
	company_NAME VARCHAR(255),
	company_COLOR VARCHAR(255),
	company_DESCRIPTION VARCHAR(255),
	company_address BIGINT(20) DEFAULT NULL,
	company_owner BIGINT(20) DEFAULT NULL,
	PRIMARY KEY (company_id)
);

CREATE TABLE contacts (
	contact_id BIGINT NOT NULL,
	contact_FIRSTNAME VARCHAR(255),
	contact_LASTNAME VARCHAR(255),
	contact_ORDERBY VARCHAR(255),
	contact_TITLE VARCHAR(255),
	contact_JOB VARCHAR(255),
	contact_BIRTHDAY DATETIME,
	contact_address BIGINT default null,
	PRIMARY KEY (contact_id)
);

CREATE TABLE users (
	user_id BIGINT NOT NULL,
	USER_USERNAME VARCHAR(255),
	USER_PASSWORD VARCHAR(255),
	USER_REALNAME VARCHAR(255),
	USER_EMAIL VARCHAR(255),
	USER_status BIT,
	PRIMARY KEY (user_id)
);

CREATE TABLE modules (
	module_id BIGINT NOT NULL,
	module_name VARCHAR(255),
	module_class VARCHAR(255),
	module_description VARCHAR(255),
	module_icon VARCHAR(255),
	module_status BIT,
	module_uiactive BIT,
	module_uiName VARCHAR(255),
	module_uiOrder INT,
	PRIMARY KEY (module_id)
);

CREATE TABLE consultants (
	consultant_employment BIGINT NOT NULL,
	consultant_TYPE INT,
	consultant_level INT,
	consultant_LOAD FLOAT,
	consultant_cost FLOAT,
	PRIMARY KEY (consultant_employment)
);

CREATE TABLE roles (
	role_id BIGINT NOT NULL,
	role_name VARCHAR(255),
	user_id BIGINT,
	PRIMARY KEY (role_id)
);
CREATE TABLE `user_roles` (
  `user_id` INTEGER(11) DEFAULT NULL,
  `role_id` INTEGER(11) DEFAULT NULL,
  UNIQUE KEY `user_roles_index` (`user_id`, `role_id`)
);

CREATE TABLE departments (
	dept_id BIGINT NOT NULL,
	dept_NAME VARCHAR(255),
	dept_ADDRESS BIGINT,
	dept_OWNER BIGINT,
	dept_COMPANY BIGINT,
	dept_DESCRIPTION VARCHAR(255),
	PRIMARY KEY (dept_id)
);

CREATE TABLE addresses (
	address_id BIGINT NOT NULL,
	ADDRESS1 VARCHAR(255),
	ADDRESS_CITY VARCHAR(255),
	ADDRESS_STATE VARCHAR(255),
	ADDRESS_COUNTRY VARCHAR(255),
	ADDRESS_ZIPCODE VARCHAR(255),
	ADDRESS_PHONE VARCHAR(255),
	ADDRESS_MOBILE VARCHAR(255),
	ADDRESS_FAX VARCHAR(255),
	ADDRESS_EMAIL VARCHAR(255),
	ADDRESS_URL VARCHAR(255),
	ADDRESS_LOCATION VARCHAR(255),
	PRIMARY KEY (address_id)
);

CREATE TABLE session (
	session_id BIGINT NOT NULL,
	session_name VARCHAR(255),
	session_clientIP VARCHAR(255),
	session_user VARCHAR(255),
	session_login DATETIME,
	session_logout DATETIME,
	PRIMARY KEY (session_id)
);

CREATE TABLE audittrail (
	audit_id BIGINT NOT NULL,
	audit_TIMESTAMP DATETIME,
	audit_USER BIGINT,
	audit_ACTION VARCHAR(255),
	audit_MODULE VARCHAR(255),
	audit_MODULEID BIGINT,
	audit_OLDVALUE VARCHAR(255),
	audit_NEWVALUE VARCHAR(255),
	audit_property VARCHAR(255),
	PRIMARY KEY (audit_id)
);

CREATE TABLE projects (
	project_id BIGINT NOT NULL,
	project_STATUS INT,
	project_PERCENT_COMPLETE INT,
	project_PRIORITY INT,
	project_TYPE INT,
	project_NAME VARCHAR(255),
	project_SHORTNAME VARCHAR(255),
	project_CODE VARCHAR(255),
	project_URL VARCHAR(255),
	project_DESCRIPION VARCHAR(255),
	project_COLOR_identifier VARCHAR(255),
	project_company BIGINT,
	project_START_DATE DATETIME,
	project_END_DATE DATETIME,
	PRIMARY KEY (project_id)
);

CREATE TABLE tasks (
	task_id BIGINT NOT NULL,
	task_NAME VARCHAR(255),
	task_DESCRIPTION VARCHAR(255),
	task_PROJECT BIGINT,
	task_OWNER BIGINT,
	task_START_DATE DATETIME,
	task_END_DATE DATETIME,
	task_DURATION FLOAT,
	task_hours_WORKED FLOAT,
	task_PRIORITY INT,
	task_STATUS INT,
	task_PERCENT_COMPLETE INT,
	task_ACCESS INT,
	task_NOTIFY INT,
	task_TYPE INT,
	task_MILESTONE BIT,
	task_CLIENT_PUBLISH BIT,
	task_DYNAMIC BIT,
	task_REQUIREMENT VARCHAR(255),
	PRIMARY KEY (task_id)
);

CREATE TABLE task_departements (
	task_id BIGINT NOT NULL,
	elt BIGINT NOT NULL,
	PRIMARY KEY (task_id,elt)
);

CREATE TABLE task_contacts (
	task_id BIGINT NOT NULL,
	contact_id BIGINT NOT NULL,
	PRIMARY KEY (task_id,contact_id)
);

CREATE TABLE employees (
	employee_contact BIGINT NOT NULL,
	employee_nik VARCHAR(255),
	employee_grade VARCHAR(255),
	PRIMARY KEY (employee_contact)
);

CREATE TABLE permissions (
	permission_id BIGINT NOT NULL,
	permission_USER BIGINT,
	permission_ROLE BIGINT,
	permission_level INT,
	permission_item VARCHAR(255),
	permission_value INT,
	PRIMARY KEY (permission_id)
);

CREATE TABLE project_contacts (
	project_id BIGINT NOT NULL,
	elt BIGINT NOT NULL,
	PRIMARY KEY (project_id,elt)
);

CREATE INDEX FK1F3A27612FD9A0E0 ON departments (dept_COMPANY ASC);

CREATE INDEX FK1F3A276135BA5FCE ON departments (dept_ADDRESS ASC);

CREATE INDEX FK4392F4849F828826 ON permissions (permission_USER ASC);

CREATE UNIQUE INDEX employee_nik ON employees (employee_nik ASC);

CREATE INDEX employee_contact ON employees (employee_contact ASC);

CREATE INDEX FK6907B8E67A7B558 ON tasks (task_PROJECT ASC);

CREATE INDEX consultant_employment ON consultants (consultant_employment ASC);

CREATE INDEX FK7F1A2FEA961A81F ON task_departements (elt ASC);

CREATE INDEX contact_id ON project_contacts (elt ASC);

CREATE INDEX FK7F1A2FEA4873BBA ON task_departements (task_id ASC);

CREATE INDEX FK4392F4849F7FB17C ON permissions (permission_ROLE ASC);

CREATE INDEX FKDEAFC1CDA4873BBA ON task_contacts (task_id ASC);

CREATE INDEX FK6608870B650A999A ON audittrail (audit_USER ASC);

CREATE INDEX FK9752B2B9DB5D86FA ON project_contacts (project_id ASC);

CREATE INDEX FK1F3A2761FF1F2C24 ON departments (dept_OWNER ASC);

CREATE INDEX FKC479187A45DAD9B4 ON projects (project_company ASC);

CREATE INDEX FKDEAFC1CDA446159A ON task_contacts (contact_id ASC);

CREATE INDEX FK67A8EBDF7634DFA ON roles (user_id ASC);

CREATE INDEX FK6907B8E4E2FF364 ON tasks (task_OWNER ASC);

