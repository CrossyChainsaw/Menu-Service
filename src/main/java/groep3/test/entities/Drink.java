package groep3.test.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public long drinkId;

    public String drinkName;

    public String imgSrc;

    public double drinkPrice;

    public long CategoryId;
}
