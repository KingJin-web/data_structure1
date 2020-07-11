
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_student
-- ----------------------------
DROP TABLE IF EXISTS `db_student`;
CREATE TABLE `db_student`  (
                               `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               `sid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                               `English` double(255, 0) NULL DEFAULT NULL,
                               `history` double(255, 0) NULL DEFAULT NULL,
                               `math` double(255, 0) NULL DEFAULT NULL,
                               `pe` double(255, 0) NULL DEFAULT NULL,
                               `data_structure` double(255, 0) NULL DEFAULT NULL,
                               `cdate` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
                               `total_score` double(255, 0) NULL DEFAULT NULL,
                               PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_student
-- ----------------------------
INSERT INTO `db_student` VALUES ('杨静文', '0001', 86, 99, 95, 80, 88, '2020-07-11 18:34:26', 448);
INSERT INTO `db_student` VALUES ('廖志军', '0002', 99, 88, 98, 88, 99, '2020-07-11 18:34:26', 472);
INSERT INTO `db_student` VALUES ('蔡徐坤', '0003', 19, 56, 91, 36, 25, '2020-07-11 18:34:26', 171);
INSERT INTO `db_student` VALUES ('许如愿', '0004', 99, 56, 98, 36, 99, '2020-07-11 18:34:26', 333);
INSERT INTO `db_student` VALUES ('张三疯', '0005', 99, 56, 98, 36, 18, '2020-07-11 18:34:26', 289);
INSERT INTO `db_student` VALUES ('张三丰', '0006', 99, 85, 98, 36, 89, '2020-07-11 18:34:26', 318);

SET FOREIGN_KEY_CHECKS = 1;
