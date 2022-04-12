//package groep3.test;
//
//import groep3.test.entities.Meal;
//import groep3.test.repository.MealRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class MealTest {
//
//    @Autowired
//    private MealRepository repo;
//
//    @Test
//    @Rollback(value = false) // als je dit weghaald dan niet save
//    public void CreateProductTest() throws SQLException {
//        // create object
//        Meal meal = new Meal("iPhone 10", 789);
//        Meal savedMeal = repo.save(Meal);
//
//        // assert object
//        assertNotNull(savedMeal);
//        assert (savedMeal.getName() == "iPhone 10");
//        assert (savedMeal.getPrice() == 789);
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void DeleteProductTest() {
//        Meal meal = new Meal("iPhone 10", 789);
//        repo.delete(meal);
//    }
//}
