USE `airTickets`;
DROP procedure IF EXISTS `getUser`;

USE `airTickets`;
DROP procedure IF EXISTS `airTickets`.`getUser`;
;

DELIMITER $$
USE `airTickets`$$
CREATE PROCEDURE `getUser`(IN id VARCHAR(45))
BEGIN
 SELECT * 
    FROM airTickets.User
    WHERE ID = id;
END$$

DELIMITER ;
;


USE `airTickets`;
DROP procedure IF EXISTS `getInfoUser`;

DELIMITER $$
USE `airTickets`$$
CREATE PROCEDURE `getInfoUser` (IN id VARCHAR(45))
BEGIN
	SELECT * FROM airTickets.InfoUser
    WHERE ID= id;
END$$

DELIMITER ;
