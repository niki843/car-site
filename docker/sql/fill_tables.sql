INSERT INTO address (id, street, street_number, floor_number, apartment_number)
VALUES 
	('10109344-3d03-4401-8338-973623670a85', 'first_street', 45, 7, 35),
	('cd727c71-8bd0-4787-9375-28ce90646465', 'second_street', 10, null, null);

INSERT INTO "user" (id, username, password_hash, address_id, is_admin)
VALUES 
	('c6f40667-4c9f-4c71-8862-7e7d4d810126', 'first_user', '$2a$10$lxV/KoyNwBwasG9TV1aHsei84XRNjoAAZgyXX.IhyS6Y2xgu/kRym', '10109344-3d03-4401-8338-973623670a85', true),
	('b535130c-e68e-4aab-81b3-2bf157e3822e', 'second_user', '$2a$10$lxV/KoyNwBwasG9TV1aHsei84XRNjoAAZgyXX.IhyS6Y2xgu/kRym', 'cd727c71-8bd0-4787-9375-28ce90646465', false);

INSERT INTO product (id, description, available_count, discount, price)
VALUES 
	('8bd8cc07-84f8-4c8c-9962-573dff659210', 'first product description', 10, 0.2, 10),
	('b498e8b6-7e00-4c94-8cff-517615211635', 'second product description', 0, 0, 122.99),
	('f0285fe6-72e2-46f2-8987-ce7c609ace22', 'third product description', 100, 0, 36.60);
	
INSERT INTO order_group (id, group_price, products_amount)
VALUES
	('877984c0-002b-497c-82a1-00403347e833', 1.138, 35),
	('27678e56-d0d4-4e8c-947f-604f1161b492', 8, 1);
	
INSERT INTO "order" (id, user_id, product_id, product_count, order_group_id)
VALUES
	('18c8fff1-c27e-471d-af08-d19411ddb05b', 'c6f40667-4c9f-4c71-8862-7e7d4d810126', '8bd8cc07-84f8-4c8c-9962-573dff659210', 5, '877984c0-002b-497c-82a1-00403347e833'),
	('c2befeaa-6a59-46ea-9425-156e51a6d2f7', 'c6f40667-4c9f-4c71-8862-7e7d4d810126', 'f0285fe6-72e2-46f2-8987-ce7c609ace22', 30, '877984c0-002b-497c-82a1-00403347e833'),
	('1ba0a42a-681b-4a7c-ba53-69a873d4f91b', 'b535130c-e68e-4aab-81b3-2bf157e3822e', '8bd8cc07-84f8-4c8c-9962-573dff659210', 1, '27678e56-d0d4-4e8c-947f-604f1161b492');