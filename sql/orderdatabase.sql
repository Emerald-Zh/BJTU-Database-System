/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80036
Source Host           : localhost:3306
Source Database       : orderdatabase

Target Server Type    : MYSQL
Target Server Version : 80036
File Encoding         : 65001

Date: 2024-04-16 13:32:03
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
create table menu
(
    menu_id    int auto_increment
        primary key,
    menu_name  varchar(45)                 not null,
    menu_price decimal(10, 2) default 0.00 not null,
    menu_class varchar(45)                 not null,
    constraint yueshu
        check (`menu_price` > 0)
);

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu`
(menu_name, menu_price, menu_class)
VALUES ('红烧肉', '60.00', '热菜');
INSERT INTO `menu`
(menu_name, menu_price, menu_class)
VALUES ('大拌菜', '20.00', '凉菜');
INSERT INTO `menu`
(menu_name, menu_price, menu_class)
VALUES ('米饭', '2.00', '主食');
INSERT INTO `menu`
(menu_name, menu_price, menu_class)
VALUES ('水果沙拉', '10.00', '凉菜');
INSERT INTO `menu`
(menu_name, menu_price, menu_class)
VALUES ('龙井虾仁', '50.00', '热菜');
INSERT INTO `menu`
(menu_name, menu_price, menu_class)
VALUES ('花茶', '10.00', '凉菜');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
drop table if exists orders;
create table orders
(
    orders_id    int auto_increment
        primary key,
    orders_time  datetime(6) default (now()) not null,
    orders_price decimal(10, 2)              not null,
    user_id      int                         not null,
    menu_id      int                         not null,
    constraint fk_menu_id
        foreign key (menu_id) references menu (menu_id),
    constraint fk_user_id
        foreign key (user_id) references user (user_id)
);

create index idx_user_id
    on orders (user_id);


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
create table user
(
    user_id     int auto_increment
        primary key,
    username    varchar(255)                       not null,
    nick_name   varchar(255)                       null comment '昵称',
    password    varchar(255)                       null comment '密码',
    total_price double   default 0                 null comment '点餐总金额',
    create_time datetime default CURRENT_TIMESTAMP null,
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    charset = utf8mb3;


-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`(username, nick_name, password)
VALUES ('admin','管理员', 'admin');
INSERT INTO `user`(username, nick_name, password)
VALUES ('zhangsan','张三', '12345678');
INSERT INTO `user`(username, nick_name, password)
VALUES ('xiaoyi','小1', '78945612');
INSERT INTO `user`(username, nick_name, password)
VALUES ('wangwu','王五', '333333');
INSERT INTO `user`(username, nick_name, password)
VALUES ('xiaohua','小花', '444444');

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
create table worker
(
    worker_id   int auto_increment
        primary key,
    worker_name varchar(45) not null,
    worker_sex  char        null,
    worker_age  int         not null,
    constraint wid
        unique (worker_id)
);

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker`
( worker_name, worker_sex, worker_age)
VALUES ('工二', '男', '28');
INSERT INTO `worker`
( worker_name, worker_sex, worker_age)
VALUES ('工三', '女', '30');
INSERT INTO `worker`
( worker_name, worker_sex, worker_age)
VALUES ('工四', '男', '25');

-- ----------------------------
-- View structure for ord
-- ----------------------------
DROP VIEW IF EXISTS `ord`;
CREATE ALGORITHM = UNDEFINED DEFINER =`root`@`localhost` SQL SECURITY DEFINER VIEW `ord` AS
select `orders`.`user_id` AS `user_id`, sum(`orders`.`orders_price`) AS `总价格`
from `orders`
group by `orders`.`user_id`;

-- ----------------------------
-- View structure for us
-- ----------------------------
DROP VIEW IF EXISTS `us`;
CREATE ALGORITHM = UNDEFINED DEFINER =`root`@`localhost` SQL SECURITY DEFINER VIEW `us` AS
select `user`.`user_id` AS `user_id`, `user`.`password` AS `password`
from `user`
where (`user`.`user_id` > 1);

-- ----------------------------
-- View structure for wor
-- ----------------------------
DROP VIEW IF EXISTS `wor`;
CREATE ALGORITHM = UNDEFINED DEFINER =`root`@`localhost` SQL SECURITY DEFINER VIEW `wor` AS
select (`worker`.`worker_id` + 1) AS `worker_id+1`, `worker`.`worker_name` AS `worker_name`
from `worker`;

-- ----------------------------
-- Procedure structure for new_procedure
-- ----------------------------
DROP PROCEDURE IF EXISTS `new_procedure`;
DELIMITER ;;
CREATE
    DEFINER = `root`@`localhost` PROCEDURE `new_procedure`(IN init int, IN loop_time int)
BEGIN
    DECLARE var INT;
    DECLARE id INT;
    SET var = 0;
    SET id = init;
    WHILE var < loop_time
        DO
            INSERT INTO user
            VALUES (id, CONCAT('name_', id), id);
            SET id = id + 1;
            SET var = var + 1;
        END WHILE;
END
;;
DELIMITER ;
-- --------------------
-- 触发器实现添加点餐总金额修改
-- --------------------
DELIMITER //

CREATE TRIGGER after_order_insert
    AFTER INSERT
    ON orders
    FOR EACH ROW
BEGIN
    UPDATE user
    SET total_price = total_price + NEW.orders_price
    WHERE user_id = NEW.user_id;
END //

DELIMITER ;

-- --------------------
-- 触发器实现删除点餐总金额修改
-- --------------------

DELIMITER //

CREATE TRIGGER after_order_delete
    AFTER DELETE
    ON orders
    FOR EACH ROW
BEGIN
    UPDATE user
    SET total_price = total_price - OLD.orders_price
    WHERE user_id = OLD.user_id;
END //

DELIMITER ;

-- --------------------
-- 触发器实现修改点餐总金额修改
-- --------------------
DELIMITER //

CREATE TRIGGER after_order_update
    AFTER UPDATE
    ON orders
    FOR EACH ROW
BEGIN
    UPDATE user
    SET total_price = total_price - OLD.orders_price + NEW.orders_price
    WHERE user_id = NEW.user_id;
END //

DELIMITER ;