package io.codeforall.Fanstatics;

import javax.persistence.*;

public class SingleTable {
//Single Table

    @Entity(name="VehicleSingleTable")
    @Table(name = "vehicle_single_table")
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    @DiscriminatorColumn(
            name = "vehicle_type",
            discriminatorType = DiscriminatorType.STRING
    )
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

    @Entity(name="BoatSingleTable")
    @DiscriminatorValue("boat")
    public class Boat extends Vehicle{
        private Integer engines;

        public Integer getEngines() {
            return engines;
        }

        public void setEngines(Integer engines) {
            this.engines = engines;
        }
    }

    @Entity(name="CarSingleTable")
    @DiscriminatorValue("car")
    public class car extends Vehicle{
        private Integer gears;

        public Integer getGears() {
            return gears;
        }

        public void setGears(Integer gears) {
            this.gears = gears;
        }
    }


}

