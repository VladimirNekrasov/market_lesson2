INSERT INTO roles (name)
VALUES
('ROLE_EMPLOYEE'), ('ROLE_MANAGER'), ('ROLE_ADMIN');

INSERT INTO users (username,password,first_name,last_name,email,phone)
VALUES
('admin','$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i','Admin','Admin','admin@gmail.com','+79881111111');

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(1, 2),
(1, 3);

INSERT INTO categories (title)
VALUES
("Телевизоры"), ("Ноутбуки");

INSERT INTO orders_statuses (title)
VALUES
("Сформирован");

INSERT INTO products (category_id, vendor_code, title, short_description, full_description, price)
VALUES
(1, "00000001", "20\" Телевизор Samsung UE20NU7170U", "Коротко: Хороший телевизор Samsung 20", "LED телевизор Samsung 20", 1.00),
(1, "00000002", "24\" Телевизор Samsung UE24NU7170U", "Коротко: Хороший телевизор Samsung 24", "LED телевизор Samsung 24", 2.00),
(1, "00000003", "28\" Телевизор Samsung UE28NU7170U", "Коротко: Хороший телевизор Samsung 28", "LED телевизор Samsung 28", 3.00),
(1, "00000004", "32\" Телевизор Samsung UE32NU7170U", "Коротко: Хороший телевизор Samsung 32", "LED телевизор Samsung 32", 4.00),
(1, "00000005", "36\" Телевизор Samsung UE36NU7170U", "Коротко: Хороший телевизор Samsung 36", "LED телевизор Samsung 36", 5.00),
(1, "00000006", "40\" Телевизор Samsung UE40NU7170U", "Коротко: Хороший телевизор Samsung 40", "LED телевизор Samsung 40", 6.00),
(1, "00000007", "44\" Телевизор Samsung UE44NU7170U", "Коротко: Хороший телевизор Samsung 44", "LED телевизор Samsung 44", 7.00),
(1, "00000008", "48\" Телевизор Samsung UE48NU7170U", "Коротко: Хороший телевизор Samsung 48", "LED телевизор Samsung 48", 8.00),
(1, "00000009", "52\" Телевизор Samsung UE52NU7170U", "Коротко: Хороший телевизор Samsung 52", "LED телевизор Samsung 52", 9.00),
(1, "00000010", "56\" Телевизор Samsung UE56NU7170U", "Коротко: Хороший телевизор Samsung 56", "LED телевизор Samsung 56", 10.00),
(1, "00000011", "60\" Телевизор Samsung UE60NU7170U", "Коротко: Хороший телевизор Samsung 60", "LED телевизор Samsung 60", 11.00),
(1, "00000012", "64\" Телевизор Samsung UE64NU7170U", "Коротко: Хороший телевизор Samsung 64", "LED телевизор Samsung 64", 12.00);

INSERT INTO products_images (product_id, path)
VALUES
(2, "2.jpg");

INSERT INTO delivery_addresses (user_id, address)
VALUES
(1, "18a Diagon Alley"),
(1, "4 Privet Drive");