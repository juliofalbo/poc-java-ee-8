package entities;

import enums.Color;
import enums.EngineType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
@NamedQuery(name = Car.FIND_ALL, query = "select c from Car c")
public class Car {

    public static final String FIND_ALL = "Car.findAll";
    
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "car", nullable = false)
    private Set<Seat> seats = new HashSet<>();

    public Car(String id, Color color, EngineType engineType) {
        this.id = id;
        this.color = color;
        this.engineType = engineType;
    }

    public Car() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", color=" + color +
                ", engineType=" + engineType +
                '}';
    }
}
