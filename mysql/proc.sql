/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4 foldmethod=marker: */
--
-- 此脚本用于测试 MYSQL 存储过程
--
USE test;
SET NAMES utf8;

--
-- 存储过程
--

DELIMITER //
-- {{{ PROCEDURE
-- {{{ create table t

DROP TABLE IF EXISTS t//
CREATE TABLE t (
	`s1` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 //

-- }}}
-- {{{ procedure p1
--
-- DROP PROCEDURE IF EXISTS p1 //
-- CREATE PROCEDURE p1() SELECT 'Hello, world' //
--
-- -- 调用
-- CALL p1() //
--
-- }}}
-- {{{ procedure p2
--
-- 输入 example
--
-- DROP PROCEDURE IF EXISTS p2 //
-- CREATE PROCEDURE p2(p INT) SET @x = p //
--
-- -- 调用
-- CALL p2(12345)//
-- SELECT @x//
--
-- }}}
-- {{{ procedure p3
--
-- 输出 example
--
-- DROP PROCEDURE IF EXISTS p3 //
-- CREATE PROCEDURE p3(OUT p INT) SET p = -5 //
--
-- -- 调用
-- CALL p3(@y)//
-- SELECT @y//
--
-- }}}
-- {{{ procedure p4
--
-- DEFAULT 子句 example
--
-- DROP PROCEDURE IF EXISTS p4 //
-- CREATE PROCEDURE p4()
-- BEGIN
-- 	DECLARE a, b INT DEFAULT 5;
-- 	INSERT INTO t VALUE (a);
-- 	SELECT s1 * a FROM t WHERE s1 >= b;
-- END;//
--
-- -- 调用
-- CALL p4()//
--
-- }}}
-- {{{ procedure p5
--
-- 作用域 example
--
-- DROP PROCEDURE IF EXISTS p5 //
-- CREATE PROCEDURE p5()
-- BEGIN
-- 	DECLARE x1 CHAR(5) DEFAULT 'outer';
-- 	BEGIN
-- 		DECLARE x1 CHAR(5) DEFAULT 'inner';
-- 		SELECT x1;
-- 	END;
-- 	SELECT x1;
-- END;//
--
-- -- 调用
-- CALL p5()//
--
-- }}}
-- {{{ procedure p6
--
-- IF-THEN-ELSE example
--
-- DROP PROCEDURE IF EXISTS p6 //
-- CREATE PROCEDURE p6(IN param INT)
-- BEGIN
-- 	DECLARE var1 INT;
-- 	SET var1 = param + 1;
-- 	IF var1 = 0 THEN
-- 		INSERT INTO t VALUES(17);
-- 	END IF;
--
-- 	IF param = 0 THEN
-- 		UPDATE t SET s1 = s1 + 1;
-- 	ELSE
-- 		UPDATE t SET s1 = s1 + 2;
-- 	END IF;
-- END;//
--
-- -- 调用
-- CALL p6(-1)//
-- SELECT * from t//
-- CALL p6(0)//
-- SELECT * from t//
-- CALL p6(2)//
-- SELECT * from t//
--
-- }}}
-- {{{ procedure p7
--
-- CASE example
-- 
-- DROP PROCEDURE IF EXISTS p7 //
-- CREATE PROCEDURE p7(IN param INT)
-- BEGIN
-- 	DECLARE var1 INT;
-- 	SET var1 = param + 1;
-- 	CASE var1
-- 		WHEN 0 THEN INSERT INTO t VALUES (17);
-- 		WHEN 1 THEN INSERT INTO t VALUES (18);
-- 		ELSE INSERT INTO t VALUES(19);
-- 	END CASE;
-- END;//
-- 
-- -- 调用
-- CALL p7(-1)//
-- SELECT * from t//
-- CALL p7(0)//
-- SELECT * from t//
-- CALL p7(2)//
-- SELECT * from t//
-- 
-- }}}
-- {{{ procedure p8
--
-- WHILE...END WHILE example
-- 
-- DROP PROCEDURE IF EXISTS p8 //
-- CREATE PROCEDURE p8()
-- BEGIN
-- 	DECLARE var1 INT DEFAULT 0;
-- 	WHILE var1 < 5 DO
-- 		INSERT INTO t VALUES (var1);
-- 		SET var1 = var1 + 1;
-- 	END WHILE;
-- END;//
-- 
-- -- 调用
-- CALL p8()//
-- SELECT * from t//
-- 
-- }}}
-- {{{ procedure p9
--
-- REPEAT... END REPEAT example
-- 
-- DROP PROCEDURE IF EXISTS p9 //
-- CREATE PROCEDURE p9()
-- BEGIN
-- 	DECLARE var INT DEFAULT 0;
-- 	REPEAT
-- 		INSERT INTO t VALUES(var);
-- 		SET var = var + 1;
-- 		UNTIL var >= 5
-- 	END REPEAT;
-- END;//
-- 
-- -- 调用
-- CALL p9()//
-- SELECT * from t//
-- 
-- }}}
-- {{{ procedure p10
--
-- LOOP...END LOOP example
-- 
-- DROP PROCEDURE IF EXISTS p10 //
-- CREATE PROCEDURE p10()
-- BEGIN
-- 	DECLARE var INT DEFAULT 0;
-- 	loop_label: LOOP
-- 		INSERT INTO t VALUES(var);
-- 		SET var = var + 1;
-- 		IF var >= 5 THEN
-- 			LEAVE loop_label;
-- 		END IF;
-- 	END LOOP;
-- END;//
-- 
-- -- 调用
-- CALL p10()//
-- SELECT * from t//
-- 
-- }}}
-- {{{ procedure p11
--
-- LOOP...END LOOP example
-- 
-- DROP PROCEDURE IF EXISTS p11 //
-- CREATE PROCEDURE p11()
-- BEGIN
-- 	DECLARE var INT DEFAULT 0;
-- 	loop_label: LOOP
-- 		IF var = 3 THEN
-- 			SET var = var + 1;
-- 			ITERATE loop_label;
-- 		END IF;
-- 
-- 		INSERT INTO t VALUES(var);
-- 		SET var = var + 1;
-- 		IF var >= 5 THEN
-- 			LEAVE loop_label;
-- 		END IF;
-- 	END LOOP;
-- END;//
-- 
-- -- 调用
-- CALL p11()//
-- SELECT * from t//
-- 
-- }}}
-- {{{ procedure p12
--
-- DECLARE CONTINUE HANDLER example
-- 
-- DROP TABLE IF EXISTS t4;
-- CREATE TABLE t4 (s1 int,primary key (s1));//
-- DROP PROCEDURE IF EXISTS p12 //
-- CREATE PROCEDURE p12()
-- BEGIN
-- 	DECLARE CONTINUE HANDLER FOR SQLSTATE '23000' SET @x2 = 1;
-- 	SET @x = 1;
-- 	INSERT INTO t4 VALUES(1);
-- 
-- 	SET @x = 2;
-- 	INSERT INTO t4 VALUES(1);
-- 
-- 	SET @x = 3;
-- 	INSERT INTO t4 VALUES(1);
-- END;//
-- 
-- -- 调用
-- CALL p12()//
-- SELECT @x, @x2//
-- 
-- }}}
-- {{{ procedure p13
--
-- DECLARE CONDITION example

DROP TABLE IF EXISTS t4;
CREATE TABLE t4 (s1 int,primary key (s1));//
DROP PROCEDURE IF EXISTS p13 //
CREATE PROCEDURE p13()
BEGIN
	DECLARE `def` CONDITION FOR SQLSTATE '23000';
	DECLARE EXIT HANDLER FOR `def` ROLLBACK;

	START TRANSACTION;
	INSERT INTO t4 VALUES(1);
	INSERT INTO t4 VALUES(1);
	INSERT INTO t4 VALUES(1);
	COMMIT;
END;//

-- 调用
CALL p13()//
SELECT * FROM t4//

-- }}}
-- {{{ procedure p14
--
-- CURSOR example

INSERT INTO  t VALUES(1); 
INSERT INTO  t VALUES(2); 
INSERT INTO  t VALUES(3); 
INSERT INTO  t VALUES(4); 
INSERT INTO  t VALUES(5); 
DROP PROCEDURE IF EXISTS p14 //
CREATE PROCEDURE p14(OUT return_val INT)
BEGIN
	DECLARE a, b INT;
	DECLARE cur_1 CURSOR FOR SELECT s1 FROM t;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET b = 1;

	OPEN cur_1;
	REPEAT
		FETCH cur_1 INTO a;
		UNTIL b = 1
	END REPEAT;
	CLOSE cur_1;
	SET return_val = a;
END;//

-- 调用
CALL p14(@return_val)//
SELECT @return_val//

-- }}}
-- }}}
DELIMITER ;
