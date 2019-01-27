package exposers;

import annotations.Diesel;
import enums.Color;

import javax.enterprise.inject.Produces;

public class DefaultColorExposer {

    @Produces
    @Diesel
    public Color exposeDefaultColor(){
        return Color.BLUE;
    }

}
