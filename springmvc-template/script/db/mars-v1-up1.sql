DROP PROCEDURE IF EXISTS addcolumn;

DELIMITER $$
CREATE PROCEDURE addcolumn(IN p_tablename varchar(200), IN p_columnname VARCHAR(200), IN p_info VARCHAR(200))
begin
    declare str VARCHAR(1000);
    set @str=concat('ALTER TABLE `',p_tablename,'` ADD COLUMN `',p_columnname, '` ', p_info);
    SELECT COUNT(*) INTO @cnt FROM information_schema.columns WHERE TABLE_NAME=p_tablename AND COLUMN_NAME=p_columnname;
    IF @cnt = 0 then 
        PREPARE stmt FROM @str;
        EXECUTE stmt ;
    END if;

end $$
DELIMITER;

call addcolumn('data_field','exp_proto','INT NOT NULL DEFAULT 2 AFTER `exp`');

DROP PROCEDURE addcolumn;