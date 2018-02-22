create database `kingdom`;
create table  `kingdom`.`users` (`id` int not null auto_increment ,
`email` varchar(50) not null unique, `password` varchar(50) not null, primary key(`id`));
insert into `kingdom`.`users` (`email`, `password`) values ('sweetochka1997@gmail.com', '12345');

