package com.jinyawen.shortlink.admin.test;

public class UserTableShardingTest {
    public static final String SQL="CREATE TABLE `tb_user_%d` (\n" +
            "  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',\n" +
            "  `name` varchar(50) NOT NULL COMMENT '用户名',\n" +
            "  `phone` varchar(11) NOT NULL COMMENT '手机号',\n" +
            "  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',\n" +
            "  `profession` varchar(11) DEFAULT NULL COMMENT '专业',\n" +
            "  `age` tinyint unsigned DEFAULT NULL COMMENT '年龄',\n" +
            "  `gender` char(1) DEFAULT NULL COMMENT '性别 , 1: 男, 2: 女',\n" +
            "  `status` char(1) DEFAULT NULL COMMENT '状态',\n" +
            "  `createtime` datetime DEFAULT NULL COMMENT '创建时间',\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户表'\n" +
            "\n";
    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n",i);
        }
    }
}
