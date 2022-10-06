CREATE TABLE IF NOT EXISTS address(
	id varchar(512) NOT NULL,
	street varchar(512) NOT NULL,
	street_number smallint NOT NULL,
	floor_number smallint NULL,
	apartment_number smallint NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS "user" (
	id varchar(512) NOT NULL,
	username varchar(512) NOT NULL,
	password_hash varchar(512) NOT NULL,
	address_id varchar(512),
	is_admin boolean NULL DEFAULT false,
	PRIMARY KEY(id),
	CONSTRAINT fk_address
		FOREIGN KEY (address_id)
		REFERENCES address(id)
);

CREATE TABLE IF NOT EXISTS product (
	id varchar(512) NOT NULL,
	description varchar(512) NOT NULL,
	available_count int NULL,
	discount double NULL DEFAULT 0,
	price double NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS order_group (
	id varchar(512) NOT NULL,
	group_price double NOT NULL,
	products_amount smallint NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS "order" (
	id varchar(512) NOT NULL,
	user_id varchar(512) NOT NULL,
	product_id varchar(512) NOT NULL,
	product_count int NOT NULL,
	order_group_id varchar NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_user
		FOREIGN KEY (user_id)
		REFERENCES "user"(id),
	CONSTRAINT fk_product
		FOREIGN KEY (product_id)
		REFERENCES product(id),
	CONSTRAINT fk_order_group
		FOREIGN KEY (order_group_id)
		REFERENCES order_group(id)
);
