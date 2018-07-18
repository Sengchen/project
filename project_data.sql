insert into SYS_USER (id,account, password) values (1,'admin', 'admin');
insert into SYS_USER (id,account, password) values (2,'abel', 'abel');

insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

insert into SYS_ROLE_USER(id, SYS_USER_ID,sys_role_id) values(1, 1,1);
insert into SYS_ROLE_USER(id, SYS_USER_ID,sys_role_id) values(2, 2,2);

BEGIN;
INSERT INTO `sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', null), ('2', 'ROLE_ADMIN', 'ABel', '/admin', null);
COMMIT;

BEGIN;
INSERT INTO `sys_permission_role` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '2', '1');
COMMIT;