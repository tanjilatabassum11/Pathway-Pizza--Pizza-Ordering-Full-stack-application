BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('carl', '4125550099', CURRENT_TIMESTAMP, false, NULL, NULL,'5555555555555555', 200.00, 'pending', 'feedme@aol.com');
INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('alex', '4128675309', CURRENT_TIMESTAMP, false, NULL, NULL,'1555555555555555', 20.00, 'pending', 'feedme@aol.com');
INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('destin', '4125550099', CURRENT_TIMESTAMP, false, NULL, NULL,'5555555555555555', 30.00, 'pending', 'feedme@aol.com');
INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) VALUES('gene', '4125550099', CURRENT_TIMESTAMP, false, NULL, NULL,'5555555555555555', 25.00, 'pending', 'feedme@aol.com');

INSERT INTO pizzas (pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note, description, image_url)
VALUES
('The Jackson', 'large', true, 85.00, 5, true, 'Pepperoni, pineapple, and jalapenos', 'A delightful mix of pepperoni, sweet pineapple, and spicy jalapenos. Perfect for those who love a sweet and spicy combination.', 'The Jackson.png'),
('The Pineapple Express', 'large', true, 18.00, 3, true, 'More pineapple than you probably want', 'An overload of pineapple for those who can''t get enough of it. A tropical delight that''s both sweet and tangy.', 'The Pineapple Express.png'),
('The Miser', 'small', true, 6.00, 3, true, 'Just Pepperoni', 'A classic choice for purists, featuring a generous amount of pepperoni on a perfectly baked crust.', 'The Miser.png'),
('Three Cheese Blend', 'medium', true, 15.00, 5, true, 'All three cheeses. Yes, there are only three.', 'A cheese lover’s dream with a blend of three premium cheeses, melted to perfection.', 'Three Cheese Blend.png'),
('Supreme', 'large', true, 15.00, 7, true, 'Best treat for post interview jitters', 'We know you nailed that interview. Now celebrate with this supreme treat', 'Supreme.png'),
('Sweet Dreams', 'small', true, 10.00, 7, true, 'Pizza equivalent of eating a tub of ice-cream', 'Even if you didn''t ace that interview, we''re sure you''ll get back on you''re feet', 'Sweet Dreams.png'),
('The B-Yo', 'medium', true, 12.00, 8, true, 'The B-Yo we know gives the best career advice', 'Named after our esteemed owner and career guide. Also baby yoda.', 'The B-Yo.png'),
('Buffalo Chicken', 'large', true, 12.00, 4, true, 'No buffalos were harmed in the making of this pizza', 'Spicy sauce, melty cheese, grill seared chicken. Just make sure to get something else for your spice intolerant friends', 'Buffalo Chicken.png'),
('Chickie Bakie Ranch', 'large', true, 12.00, 5, true, 'It''s not even trying to be healthy', 'Creamy Ranch, Crispy Applewood smoked bacon, tender chicken, and a massive (like, "should I book a doctor''s appointment?") amount of cheese', 'Chicken Bacon Ranch.png'),
('Margherita', 'medium', true, 10.00, 6, true, 'A true classic', 'From the hills Napoli, this recipe has been handed down through the generations', 'Margherita.png'),
('The Safest Option', 'medium', true, 10.00, 9, true, 'No one will complain', 'Literally the most inoffensive pizza we could make. Vegan. Gluten Free. Nut Free. Peanut Free. Coconut Free.', 'Veggie Pizza.png');


INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('pepperoni', 'meat', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('pineapple', 'fruit', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('jalapenos', 'veggies', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('ricotta', 'cheese', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('asiago', 'cheese', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('fresh mozzarella', 'cheese', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('traditional', 'sauce', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('sweet', 'sauce', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('spicy', 'sauce', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('alfredo', 'sauce', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('hand tossed', 'crust', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('deep dish', 'crust', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('thin', 'crust', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('chicken', 'meat', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('ham', 'meat', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('sausage', 'meat', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('bacon', 'meat', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('anchovy', 'meat', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('basil leaves', 'veggies', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('daiya vegan', 'cheese', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('gluten free', 'crust', 0.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('onions', 'veggies', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('mushrooms', 'veggies', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('peppers', 'veggies', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('sun dried tomato', 'veggies', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('olives', 'veggies', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('spinach', 'veggies', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('blueberry compote', 'fruit', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('fig glaze', 'fruit', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('pears', 'fruit', 1.00, true);
INSERT INTO toppings(topping_name, type, cost, is_available) VALUES('ranch', 'sauce', 0.00, true);



INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(1,1);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(1,2);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(1,3);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(1,7);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(1,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(2,2);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(2,7);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(2,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(3,1);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(3,7);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(3,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(4,4);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(4,5);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(4,6);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(4,7);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(4,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(5,7);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(5,17);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(5,16);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(5,24);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(5,22);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(5,26);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(5,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(6,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(6,8);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(6,28);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(6,29);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(6,30);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(6,4);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(6,16);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(7,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(7,7);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(7,17);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(7,16);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(7,15);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(7,1);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(8,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(8,21);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(8,6);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(8,14);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(9,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(9,31);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(9,6);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(9,17);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(9,14);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(10,11);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(10,7);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(10,19);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(10,6);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(11,20);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(11,21);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(11,7);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(11,23);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(11,24);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(11,26);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(11,25);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(11,22);
INSERT INTO pizzas_toppings(pizza_id, topping_id) VALUES(11,27);

INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(1,1,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(1,2,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(1,3,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(1,4,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(2,2,1);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(3,4,2);
INSERT INTO orders_pizzas(order_id, pizza_id, quantity) VALUES(4,1,1);

--INSERT INTO home (pizza_id, special_offer, combo_deal, deal_cost)
--VALUES (1, 'Special Discount', false, 75.00),
--       (2, 'Buy One Get One', true, 18.00),
--       (3, 'Evening Special', false, 5.50),
--       (4, 'Cheese Lovers Offer', false, 80.00);

COMMIT TRANSACTION;
