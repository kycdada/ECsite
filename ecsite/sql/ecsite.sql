set names utf8;
set foreign_key_checks=0;
drop database if exists ecsite;
create database ecsite;
use ecsite;

drop table if exists login_user_transaction;
create table login_user_transaction(
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),
	insert_date datetime,
	updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
	id int not null primary key auto_increment,
	item_name varchar(30),
	item_kata varchar(30),
	item_hira varchar(30),
	item_price int,
	item_category varchar(30),
	item_explain varchar(255),
	item_img_path varchar(255),
	insert_date datetime,
	updated_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
	id int not null primary key auto_increment,
	order_number varchar(16),
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	delete_date datetime
);

drop table if exists cart_transaction;

create table cart_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	price int,
	total_count int,
	total_price int,
	user_master_id varchar(16),
	insert_date datetime,
	delete_date datetime
);

drop table if exists master_login_transaction;

create table master_login_transaction(
	id int not null primary key auto_increment,
	host_master_id varchar(16) unique,
	login_password varchar(16),
	sub_master_flg  bit,
	user_create boolean,
	user_edit boolean,
	user_delete boolean,
	item_create boolean,
	item_edit boolean,
	item_delete bit,

	insert_date datetime,
	update_date datetime
);



INSERT INTO item_info_transaction(item_name,item_hira,item_kata,item_price,item_category,item_explain,item_img_path) VALUES("A5肉 5kg","えーごにく","エーゴニク",100000,"肉","最高級和牛","images/肉.jpg");
INSERT INTO item_info_transaction(item_name,item_hira,item_kata,item_price,item_category,item_explain,item_img_path) VALUES("A4肉 5kg","えーよんにく","エーヨンニク",5000,"肉","高級肉","images/肉.jpg");
INSERT INTO item_info_transaction(item_name,item_hira,item_kata,item_price,item_category,item_explain,item_img_path) VALUES("ジンギスカン用羊肉 5kg","じんぎすかん","ジンギスカン",1000,"肉","若羊肉","images/肉.jpg");
INSERT INTO item_info_transaction(item_name,item_hira,item_kata,item_price,item_category,item_explain,item_img_path) VALUES("豚肉 5kg","ぶたにく","ブタニク",1000,"肉","豚肉","images/肉.jpg");
INSERT INTO item_info_transaction(item_name,item_hira,item_kata,item_price,item_category,item_explain,item_img_path) VALUES("高級豚肉 5kg","こうきゅうぶたにく","コウキュウブタニク",20000,"肉","高級豚肉","images/肉.jpg");
INSERT INTO item_info_transaction(item_name,item_hira,item_kata,item_price,item_category,item_explain,item_img_path) VALUES("高級ジンギスカン用羊肉 5kg","こうきゅうじんぎすかんようひつじにく","コウキュウジンギスカンヨウヒツジニク",10000,"肉","高級若羊肉","images/肉.jpg");
INSERT INTO item_info_transaction(item_name,item_hira,item_kata,item_price,item_category,item_explain,item_img_path) VALUES("低温製法牛乳","ていおんせいほうぎゅうにゅう","テイオンセイホウギュウニュウ",200,"牛乳","低温製法","images/牛乳.jpg");
INSERT INTO item_info_transaction(item_name,item_hira,item_kata,item_price,item_category,item_explain,item_img_path) VALUES("牛乳","ぎゅうにゅう","ギュウニュウ",100,"牛乳","通常製法牛乳","images/牛乳.jpg");
INSERT INTO item_info_transaction(item_name,item_hira,item_kata,item_price,item_category,item_explain,item_img_path) VALUES("高級牛乳","こうきゅうぎゅうにゅう","コウキュウギュウニュウ",300,"牛乳","低温製法牛乳","images/牛乳.jpg");

INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("guest","guest","guest");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("guest1","guest1","guest1");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("guest2","guest2","guest2");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("guest3","guest3","guest3");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("guest4","guest4","guest4");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("guest5","guest5","guest5");

INSERT INTO master_login_transaction(host_master_id,login_password,sub_master_flg) VALUES("admin","admin",false);
INSERT INTO master_login_transaction(host_master_id,login_password,sub_master_flg,user_create,user_edit,user_delete,item_create,item_edit,item_delete) VALUES("admin1","admin1",true,true,true,true,true,true,true);
INSERT INTO master_login_transaction(host_master_id,login_password,sub_master_flg,user_create,user_edit,user_delete,item_create,item_edit,item_delete) VALUES("admin2","admin2",true,false,false,false,true,true,true);
INSERT INTO master_login_transaction(host_master_id,login_password,sub_master_flg,user_create,user_edit,user_delete,item_create,item_edit,item_delete) VALUES("admin3","admin3",true,true,true,true,false,false,false);
INSERT INTO master_login_transaction(host_master_id,login_password,sub_master_flg,user_create,user_edit,user_delete,item_create,item_edit,item_delete) VALUES("admin4","admin4",true,true,false,true,true,false,true);
INSERT INTO master_login_transaction(host_master_id,login_password,sub_master_flg,user_create,user_edit,user_delete,item_create,item_edit,item_delete) VALUES("admin5","admin5",true,false,true,false,false,true,false);
INSERT INTO master_login_transaction(host_master_id,login_password,sub_master_flg,user_create,user_edit,user_delete,item_create,item_edit,item_delete) VALUES("admin6","admin6",true,true,false,false,false,true,false);
INSERT INTO master_login_transaction(host_master_id,login_password,sub_master_flg,user_create,user_edit,user_delete,item_create,item_edit,item_delete) VALUES("admin7","admin7",true,false,false,false,false,false,false);