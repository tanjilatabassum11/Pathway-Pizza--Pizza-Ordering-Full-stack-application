BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('carl', '4125550099', CURRENT_TIMESTAMP, false, NULL, NULL,'5555555555555555', 200.00, 'pending', 'feedme@aol.com');
INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('alex', '4128675309', CURRENT_TIMESTAMP, false, NULL, NULL,'1555555555555555', 20.00, 'pending', 'feedme@aol.com');
INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('destin', '4125550099', CURRENT_TIMESTAMP, false, NULL, NULL,'5555555555555555', 30.00, 'pending', 'feedme@aol.com');
INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('gene', '4125550099', CURRENT_TIMESTAMP, false, NULL, NULL,'5555555555555555', 25.00, 'pending', 'feedme@aol.com');

INSERT INTO pizzas (pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note, description, image_url)
VALUES
('The Jackson', 'large', true, 85.00, 3, true, 'Pepperoni, pineapple, and jalapenos', 'A delightful mix of pepperoni, sweet pineapple, and spicy jalapenos. Perfect for those who love a sweet and spicy combination.', 'The Jackson.png'),
('The Pineapple Express', 'large', true, 18.00, 1, true, 'More pineapple than you probably want', 'An overload of pineapple for those who can''t get enough of it. A tropical delight that''s both sweet and tangy.', 'The Pineapple Express.png'),
('The Miser', 'small', true, 6.00, 1, true, 'Just Pepperoni', 'A classic choice for purists, featuring a generous amount of pepperoni on a perfectly baked crust.', 'The Miser.png'),
('Three Cheese Blend', 'medium', true, 85.00, 3, true, 'All three cheeses. Yes, there are only three.', 'A cheese lover’s dream with a blend of three premium cheeses, melted to perfection.', 'Three Cheese Blend.png');

INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('pepperoni', 'meat', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('pineapple', 'fruit', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('jalapenos', 'veggies', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('ricotta', 'cheese', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('asiago', 'cheese', 1.00, false);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('fresh mozzarella', 'cheese', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('traditional', 'sauce', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('sweet', 'sauce', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('spicy', 'sauce', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('alfredo', 'sauce', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('hand tossed', 'crust', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('deep dish', 'crust', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('thin', 'crust', 0.00, true);


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

INSERT INTO home (pizza_id, special_offer, combo_deal, deal_cost)
VALUES (1, 'Special Discount', false, 75.00),
       (2, 'Buy One Get One', true, 18.00),
       (3, 'Evening Special', false, 5.50),
       (4, 'Cheese Lovers Offer', false, 80.00);

COMMIT TRANSACTION;
