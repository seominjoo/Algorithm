CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'idx',
  `name` varchar(100) DEFAULT NULL COMMENT '이름',
  `reg_date` datetime DEFAULT NULL COMMENT '가입일',
  `mod_date` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO member
     (name, reg_date, mod_date)
VALUES
     ("spring2", now(), now());


select * from member a;