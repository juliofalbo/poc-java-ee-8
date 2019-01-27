package repositories;

import entities.Car;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CarRepository {

    //Only need if yo have 2 datasources
//    @PersistenceContext(unitName = "prod")
    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void store(Car car) {
        entityManager.persist(car);
    }
    public List<Car> findAll(){
        return entityManager.createNamedQuery(Car.FIND_ALL, Car.class).getResultList();
    }
}
