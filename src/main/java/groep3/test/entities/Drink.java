package groep3.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long drinkId;

    public String drinkName;

    public double drinkPrice;
}
