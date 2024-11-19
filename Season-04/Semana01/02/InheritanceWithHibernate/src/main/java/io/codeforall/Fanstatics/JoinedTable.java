package io.codeforall.Fanstatics;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlInlineBinaryData;

public class JoinedTable {

@Entity(name="VehicleJoinedTable")
    @Table(name = "vehicle_joined_table")
    @Inheritance(strategy = InheritanceType.JOINED)
    public abstract class Vehicle{
    @Id
    private Integer id;
    private Integer maxSpeed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


}

@Entity(name = "BoatJoinedTable")
    @Table(name = "boat_joined_table")
    public class Boat extends Vehicle{
    private Integer engines;

    public Integer getEngines() {
        return engines;
    }

    public void setEngines(Integer engines) {
        this.engines = engines;
    }
}

@Entity(name ="CarJoinedTable")
    @Table(name="car_joined_table")
    public class Car extends Vehicle{
    private Integer gears;

    public Integer getGears() {
        return gears;
    }

    public void setGears(Integer gears) {
        this.gears = gears;
    }
}

}
