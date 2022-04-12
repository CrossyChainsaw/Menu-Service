	-- Automatically puts data in db when creating it

	INSERT INTO meal (category_id, img_src, meal_name, meal_price) VALUES
	  ('1', 'https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg', 'Wortelsoep', '4.99'),
	  ('1', 'https://img.static-rmg.be/a/view/q75/w960/h520/2367861/feestelijke-voorgerechten-met-bladerdeeg-jpg.jpg', 'Bladerdeeg Hapje', '5.49'),
	  ('1', 'https://prettygoodcooking.files.wordpress.com/2016/07/lichte-frisse-rosbief-salade-pretty-good-cooking-01.jpg?w=1200', 'Rosbief Salade', '2.49'),
      ('2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZy6wENeT6piV866LLp2ZdeTDzGyFEHWxPzg&usqp=CAU', 'Burger', '4.99'),
      ('2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPv6sZreFCdD81Vd3ER9546MxgIxRuTBnspQ&usqp=CAU', 'Friet', '2.99'),
      ('3', 'https://www.receptenkoken.nl/wp-content/uploads/2016/10/Tiramisu-1.jpg', 'Tiramisu', '4.99'),
      ('3', 'https://img.24baby.nl/2020/10/786e9d90-cheesecake-als-je-zwanger-bent.jpg', 'Cheesecake', '4.49');

	INSERT INTO drink (category_id, drink_name, drink_price, img_src) VALUES
      ('4', 'Coca Cola', '2.49', 'https://www.shinzo.nl/wp-content/uploads/2020/05/cocacola.png');

    INSERT INTO category (category_id, category_name) VALUES
      ('1', 'Voorgerecht'),
      ('2', 'Hoofgerecht'),
      ('3', 'Dessert'),
      ('4', 'Fris'),
      ('5', 'Drank');