package control;

import annotations.Config;
import annotations.Diesel;
import entities.Car;
import enums.Color;
import exceptions.CarCreationException;

import javax.inject.Inject;
import java.util.Random;
import java.util.UUID;

//@ApplicationScoped //Like @Singleton
//@Dependent //Default Scope
//@RequestScoped
//@SessionScoped
public class CarFactory {

    @Inject
//    @Named("diesel")
    @Diesel
    Color defaultColor;

    @Inject
    @Config("id.prefix")
    private String prefix;

    public Car createCar(Specification specification){
        Car car = new Car();
        car.setId(prefix + "-" + UUID.randomUUID().toString());
        car.setColor(specification.getColor() == null ? defaultColor : specification.getColor());
        car.setEngineType(specification.getEngineType());
        return car;
    }

}
