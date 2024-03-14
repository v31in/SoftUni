package entities.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trucks")
public class Truck extends TransportationVehicle{
    private static final String TRUCK_TYPE = "Truck";

    public Truck(int loadCapacity) {
        super(TRUCK_TYPE, loadCapacity);
    }

}
