BEGIN TRANSACTION;

DROP TABLE IF EXISTS pizzas_toppings;
DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS orders_pizzas;
DROP TABLE IF EXISTS pizzas;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	is_approved boolean NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    order_name VARCHAR(50),
    phone_number VARCHAR(15),
    order_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_delivery BOOLEAN NOT NULL DEFAULT false,
    address VARCHAR(100),
    delivery_date_time TIMESTAMP,
    payment_info VARCHAR(50) NOT NULL,
    total_cost NUMERIC(5, 2) NOT NULL CHECK (total_cost >= 0),
    order_status VARCHAR(25) DEFAULT 'pending',
    email_address VARCHAR(100)
);
CREATE TABLE pizzas(
    pizza_id SERIAL PRIMARY KEY,
    pizza_name varchar(50),
    pizza_size varchar(10),
    is_available BOOLEAN not NULL,
    pizza_cost NUMERIC(5,2) NOT NULL,
    max_toppings INTEGER,
    is_specialty BOOLEAN,
    note varchar(150)
);

CREATE TABLE orders_pizzas(
    order_id INTEGER REFERENCES orders(order_id),
    pizza_id INTEGER REFERENCES pizzas(pizza_id),
    quantity INTEGER,
    CONSTRAINT pk_order_pizzas PRIMARY KEY(order_id,pizza_id)
);

CREATE TABLE toppings(
    topping_id SERIAL PRIMARY KEY,
    topping_name varchar(50),
    type varchar(25),
    cost NUMERIC(5,2)
);

CREATE TABLE pizzas_toppings(
    pizza_id INTEGER REFERENCES pizzas(pizza_id),
    topping_id INTEGER REFERENCES toppings(topping_id),
    CONSTRAINT pk_pizzas_toppings PRIMARY KEY(pizza_id, topping_id)
);

COMMIT TRANSACTION;
