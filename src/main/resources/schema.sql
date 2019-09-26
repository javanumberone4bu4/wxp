drop database if exists oss;
create database oss default character set utf8 collate utf8_general_ci;
use oss;
drop table if exists oss.user;
create table oss.user(
 id int not null auto_increment comment 'ID',
 username varchar(20) not null comment '用户名',
 password varchar(50) not null comment '密码',
 telephone int not null comment '手机号码',
 email varchar(20) not null comment '邮箱',
 jointime timestamp not null comment '加入时间',
 unique key (username),
 primary key(id)
 )engine=InnoDB comment '用户表';

 insert into oss.user(username, password, telephone, email, join_time) values('admin',123,123456,'123@qq.com','2018-10-01 16:21:21');

use oss;
drop table if exists oss.role;
create table oss.role(
    id int not null auto_increment comment 'ID',
    role_name varchar(20) not null comment '角色名',
    role_rule varchar(50) not null comment '权限规则',
    role_description varchar(50) not null comment '角色描述',
    primary key (id)
)engine=InnoDB comment '角色表';

insert into oss.role(role_name, role_rule, role_description) values('超级管理员','会员列表','权力无限大');

use oss;
drop table if exists oss.rule;
create table oss.rule(
    id int not null auto_increment comment 'ID',
    classifyname varchar(20) not null comment '分类名',
    primary key (id)
)engine=innoDB comment '权限分类表';

insert into oss.rule(classifyname) values('会员相关,但又区别于会员');

use oss;
drop table if exists oss.orders;
create table oss.orders(
    id int not null auto_increment comment 'ID',
    order_number int not null comment '订单编号',
    order_person varchar(20) not null comment '收货人',
    order_sum decimal(10,2) not null comment '总金额',
    order_money decimal(10,2) not null comment '应付金额',
    order_status varchar(20) not null comment '订单状态',
    money_status varchar(20) not null comment '支付状态',
    good_status varchar(20) not null comment '发货状态',
    money_style varchar(20) not null comment '支付方式',
    send_style varchar(20) not null comment '配送方式',
    order_time timestamp not null comment '下单时间',
    unique key (order_number),
    primary key (id)
)engine=InnoDB comment '订单表';

insert into oss.orders(order_number, order_person, order_sum, order_money, order_status, money_status, good_status, money_style, send_style, order_time) values(1002,'王君义',18888.88,18000,'未收货','已支付','已发货','支付宝','申通','2019-09-09 09:09:09');


use oss;
drop table if exists oss.member;
create table oss.member(
    id int not null auto_increment comment 'ID',
    username varchar(20) not null comment '用户名',
    sex varchar(20) not null comment '性别',
    telephone int not null comment '手机',
    address varchar(20) not null comment '地址',
    unique key(username),
    primary key(id)
)engine=InnoDB comment '会员表';

insert into oss.member(username, sex, telephone, address) values('君临天下','男',15675424,'南天门');