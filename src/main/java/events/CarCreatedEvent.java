package events;

public class CarCreatedEvent {

    private final String id;

    public CarCreatedEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
