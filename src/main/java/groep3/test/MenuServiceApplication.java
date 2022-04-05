package groep3.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MenuServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuServiceApplication.class, args);
	}

	/**
	 INSERT INTO `groep3`.`meal` (`meal_id`, `category_id`, `img_src`, `meal_name`, `meal_price`) VALUES ('1', '2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZy6wENeT6piV866LLp2ZdeTDzGyFEHWxPzg&usqp=CAU', 'Burger', '4.99');
	 INSERT INTO `groep3`.`meal` (`meal_id`, `category_id`, `img_src`, `meal_name`, `meal_price`) VALUES ('2', '2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPv6sZreFCdD81Vd3ER9546MxgIxRuTBnspQ&usqp=CAU', 'Fries', '2.99');
	 INSERT INTO `groep3`.`meal` (`meal_id`, `category_id`, `img_src`, `meal_name`, `meal_price`) VALUES ('3', '1', 'https://prettygoodcooking.files.wordpress.com/2016/07/lichte-frisse-rosbief-salade-pretty-good-cooking-01.jpg?w=1200', 'Rosbief Salade', '2.49');
	 INSERT INTO `groep3`.`meal` (`meal_id`, `category_id`, `img_src`, `meal_name`, `meal_price`) VALUES ('4', '3', 'https://www.receptenkoken.nl/wp-content/uploads/2016/10/Tiramisu-1.jpg', 'Tiramisu', '4.99');
	 INSERT INTO `groep3`.`meal` (`meal_id`, `category_id`, `img_src`, `meal_name`, `meal_price`) VALUES ('5', '3', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBYhGMsDsUhFHFul6lZx8cfvh1q-aw5Y1MmQ&usqp=CAU', 'Cheesecake', '4.49');


	 INSERT INTO `groep3`.`category` (`category_id`, `category_name`) VALUES ('1', 'Voorgerecht');
	 INSERT INTO `groep3`.`category` (`category_id`, `category_name`) VALUES ('2', 'Hoofgerecht');
	 INSERT INTO `groep3`.`category` (`category_id`, `category_name`) VALUES ('3', 'Dessert');
	 INSERT INTO `groep3`.`category` (`category_id`, `category_name`) VALUES ('4', 'Fris');
	 INSERT INTO `groep3`.`category` (`category_id`, `category_name`) VALUES ('5', 'Drank');
	 **/

}
