package caches;

import entities.Car;
import repositories.CarRepository;
import resources.CarResource;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
//To simplify this, you can use JCache
public class CarCache {

    private final Map<String, Car> cache = new ConcurrentHashMap<>();

    @Inject
    private CarRepository carRepository;

    @PostConstruct
    public void initCache(){
        loadCars();
    }

    private void loadCars() {
        carRepository.findAll().forEach(this::cache);
    }

    public List<Car> findAll() {
        return new ArrayList<>(cache.values());
    }

    public void cache(Car car) {
        cache.put(car.getId(), car);
    }
}
