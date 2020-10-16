-- Include table data insertion, updation, deletion and select scripts

USE truyum;

-- view menu item list admin

INSERT INTO `truyum`.`menu_item` VALUES 
(1,'Sandwich',99.00,1,'2017-03-15','Main Course',1,'https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1053&amp;q=80'),
(2,'Burger',129.00,1,'2017-12-23','Main Course',0,'https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1050&amp;q=80'),
(3,'Pizza','149.00',1,'2017-08-21','Main Course',0,'https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1055&amp;q=80'),
(4,'Freench Fries','57.00',0,'2017-07-02','Starters',1,'https://images.unsplash.com/photo-1526230427044-d092040d48dc?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1050&amp;q=80'),
(5,'Chocolate Browine','32.00',1,'2022-11-02','Dessert',1,'https://images.unsplash.com/photo-1564355808539-22fda35bed7e?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1030&amp;q=80');


-- add to cart
 
INSERT INTO `truyum`.`user` 
VALUES (1,'admin','admin','admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),(2,'user','user','user','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');


INSERT INTO `truyum`.`cart` 
VALUES (1,1,2),(2,1,4),(3,1,1);
INSERT INTO `truyum`.`cart`
(`ct_us_id`,
`ct_me_id`)
VALUES
(1,2),(1,4),(1,1);

INSERT INTO `truyum`.`role`
VALUES	(1,'ADMIN'),(2,'USER'); 

INSERT INTO `truyum`.`user_role`
VALUES (1,1,1),(2,2,2);


