	CREATE TABLE product  (
		productId BIGINT  NOT NULL PRIMARY KEY ,
		price BIGINT  ,
		unit BIGINT  ,
		productName VARCHAR(2500)  ,
		productDesc VARCHAR(2500)
	) ENGINE=InnoDB;


	Insert into product(productId, price, unit, productName, productDesc) values(1, 2588, 6, "Dell product", "The first model in italy");
	Insert into product(productId, price, unit, productName, productDesc) values(2, 6000, 96, "HP product", "The second model in germany");
	Insert into product(productId, price, unit, productName, productDesc) values(3, 250, 7, "XBOX product", "The thisrd model in frensh");

	select * from product;