package vos;

import enums.SeatBeltModel;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class SeatBelt {

    @Enumerated(EnumType.STRING)
    private SeatBeltModel model;

    public void open(){

    }

    public void close(){

    }

}
