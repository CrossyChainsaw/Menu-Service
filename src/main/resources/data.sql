	-- Automatically puts data in db when creating it

	INSERT INTO meal (meal_id, category_id, img_src, meal_name, meal_price) VALUES
      ('1', '2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZy6wENeT6piV866LLp2ZdeTDzGyFEHWxPzg&usqp=CAU', 'Burger', '4.99'),
      ('2', '2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPv6sZreFCdD81Vd3ER9546MxgIxRuTBnspQ&usqp=CAU', 'Fries', '2.99'),
      ('3', '1', 'https://prettygoodcooking.files.wordpress.com/2016/07/lichte-frisse-rosbief-salade-pretty-good-cooking-01.jpg?w=1200', 'Rosbief Salade', '2.49'),
      ('4', '3', 'https://www.receptenkoken.nl/wp-content/uploads/2016/10/Tiramisu-1.jpg', 'Tiramisu', '4.99'),
      ('5', '3', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBYhGMsDsUhFHFul6lZx8cfvh1q-aw5Y1MmQ&usqp=CAU', 'Cheesecake', '4.49');

    INSERT INTO category (category_id, category_name) VALUES
      ('1', 'Voorgerecht'),
      ('2', 'Hoofgerecht'),
      ('3', 'Dessert'),
      ('4', 'Fris'),
      ('5', 'Drank');