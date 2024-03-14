package entities.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{
    private static final String CAR_TYPE = "Car";

    public Car() {
        super(CAR_TYPE);
    }
}
