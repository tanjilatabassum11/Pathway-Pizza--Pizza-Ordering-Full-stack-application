BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('carl', '4125550099', CURRENT_TIMESTAMP, false, NULL, NULL,'5555555555555555', 200.00, 'pending', 'feedme@aol.com');
INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('alex', '4128675309', CURRENT_TIMESTAMP, false, NULL, NULL,'1555555555555555', 20.00, 'pending', 'feedme@aol.com');
INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('destin', '4125550099', CURRENT_TIMESTAMP, false, NULL, NULL,'5555555555555555', 30.00, 'pending', 'feedme@aol.com');
INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('gene', '4125550099', CURRENT_TIMESTAMP, false, NULL, NULL,'5555555555555555', 25.00, 'pending', 'feedme@aol.com');

INSERT INTO pizzas(pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note) VALUES('The Jackson', 'large', true, 85.00, 3, true, 'Pepperoni, pineapple, and jalapenos');
INSERT INTO pizzas(pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note) VALUES('The Pineapple Express', 'large', true, 18.00, 1, true, 'More pineapple than you probably want');
INSERT INTO pizzas(pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note) VALUES('The Miser', 'small', true, 6.00, 1, true, 'Just Pepperoni');
INSERT INTO pizzas(pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note) VALUES('Three Cheese Blend', 'medium', true, 85.00, 3, true, 'All three cheeses. Yes, there are only three.');

INSERT INTO toppings(topping_name, type, cost) VALUES('pepperoni', 'meat', 1.00);
INSERT INTO toppings(topping_name, type, cost) VALUES('pineapple', 'fruit', 1.00);
INSERT INTO toppings(topping_name, type, cost) VALUES('jalapenos', 'veggies', 1.00);
INSERT INTO toppings(topping_name, type, cost) VALUES('ricotta', 'cheese', 1.00);
INSERT INTO toppings(topping_name, type, cost) VALUES('asiago', 'cheese', 1.00);
INSERT INTO toppings(topping_name, type, cost) VALUES('fresh mozzarella', 'cheese', 1.00);

INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(1,1);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(1,2);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(1,3);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(2,2);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(3,1);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(4,4);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(4,5);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(4,6);

INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(1,1,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(1,2,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(1,3,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(1,4,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(2,2,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(3,4,2);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(4,1,1);

COMMIT TRANSACTION;
