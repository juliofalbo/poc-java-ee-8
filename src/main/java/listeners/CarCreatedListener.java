package listeners;

import events.CarCreatedEvent;

import javax.enterprise.event.Observes;

public class CarCreatedListener {

    public void onCarCreation(@Observes CarCreatedEvent event){

    }

}
