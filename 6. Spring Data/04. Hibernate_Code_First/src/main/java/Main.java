import entities.shampoo.BasicLabel;
import entities.shampoo.BasicShampoo;
import entities.vehicle.Bike;
import entities.vehicle.Car;
import entities.vehicle.Truck;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Bike bike = new Bike();
        //Car car = new Car();
        //Truck truck = new Truck(45000);

        //em.persist(bike);
        //em.persist(car);
        //em.persist(truck);

        BasicLabel label = new BasicLabel("blue");
        BasicShampoo shampoo = new BasicShampoo("shower", label);

        em.persist(label);
        em.persist(shampoo);

        em.getTransaction().commit();
    }
}
