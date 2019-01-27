package entities;

import enums.SeatMaterial;
import vos.SeatBelt;

import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private SeatMaterial seatMaterial;

    @Embedded
    private SeatBelt seatBelt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SeatMaterial getSeatMaterial() {
        return seatMaterial;
    }

    public void setSeatMaterial(SeatMaterial seatMaterial) {
        this.seatMaterial = seatMaterial;
    }

    public SeatBelt getSeatBelt() {
        return seatBelt;
    }

    public void setSeatBelt(SeatBelt seatBelt) {
        this.seatBelt = seatBelt;
    }
}
