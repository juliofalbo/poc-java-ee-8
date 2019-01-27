package services;

import caches.CarCache;
import control.CarFactory;
import control.Specification;
import entities.Car;
import events.CarCreatedEvent;
import interceptors.ProcessTracker;
import annotations.Tracked;
import logs.FatalLogger;
import repositories.CarRepository;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CarService {

    @Inject
    private CarFactory carFactory;

    @Inject
    private CarRepository carRepository;

    @Inject
    private FatalLogger fatalLogger;

    @Inject
    private Event<CarCreatedEvent> carCreatedEventEvent;

    @Inject
    private CarCache carCache;

//    @Interceptors(ProcessTrackingInterceptor.class)
    @Tracked(ProcessTracker.Category.MANUFACTURER)
    public Car manufactoreCar(Specification specification) {
        Car car = carFactory.createCar(specification);
//        carRepository.store(car);

        try {
            carCache.cache(car);
        }catch (Exception e){
            fatalLogger.fatal(e);
        }

        //Sync event
        carCreatedEventEvent.fire(new CarCreatedEvent(car.getId()));
        return car;
    }

    public List<Car> findAll() {
//        return carRepository.findAll();
        return carCache.findAll();
    }


    public Car findById(String id) {
        return new Car();
    }
}
