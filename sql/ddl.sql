drop table if exists member CASCADE;

CREATE TABLE `member` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `user_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                          `user_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                          `user_pass` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                          PRIMARY KEY (`id`)
)