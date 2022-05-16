	-- Automatically puts data in db when creating it

	INSERT INTO product (categoryID, image, name, price, stock) VALUES
	  ('1', 'https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg', 'Wortelsoep', '4.99', '5'),
	  ('1', 'https://img.static-rmg.be/a/view/q75/w960/h520/2367861/feestelijke-voorgerechten-met-bladerdeeg-jpg.jpg', 'Bladerdeeg Hapje', '5.49', '2'),
	  ('1', 'https://prettygoodcooking.files.wordpress.com/2016/07/lichte-frisse-rosbief-salade-pretty-good-cooking-01.jpg?w=1200', 'Rosbief Salade', '2.49', '3'),
      ('2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZy6wENeT6piV866LLp2ZdeTDzGyFEHWxPzg&usqp=CAU', 'Burger', '4.99', '6'),
      ('2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPv6sZreFCdD81Vd3ER9546MxgIxRuTBnspQ&usqp=CAU', 'Friet', '2.99', '8'),
      ('3', 'https://www.receptenkoken.nl/wp-content/uploads/2016/10/Tiramisu-1.jpg', 'Tiramisu', '4.99', '4'),
      ('3', 'https://img.24baby.nl/2020/10/786e9d90-cheesecake-als-je-zwanger-bent.jpg', 'Cheesecake', '4.49', '8');

    INSERT INTO category (ID, name) VALUES
      ('1', 'Voorgerecht'),
      ('2', 'Hoofgerecht'),
      ('3', 'Dessert'),
      ('4', 'Fris'),
      ('5', 'Drank');