CREATE TABLE `user_details` (
	`id` int(10) NOT NULL AUTO_INCREMENT,
	`name` varchar(250) NOT NULL,
	`email` varchar(250) NOT NULL,
	`company_name` varchar(250) NOT NULL,
	`password` varchar(500) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `email` (`email`)
);