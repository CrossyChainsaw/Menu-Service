package groep3.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meal {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long mealId;

    public String mealName;

    public double mealPrice;

    public Meal() {
    }

    public Meal(int mealId, String mealName, double mealPrice) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealPrice = mealPrice;
    }
}
