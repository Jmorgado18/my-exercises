package io.codeforall.Fanstatics;

import javax.persistence.*;

public class TablePerClass {

    @Entity
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    public abstract class Vehicle{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;
        private Integer masSpeed;


    }

    @Entity
    @Table(name = "car_table_per_class")
    public class Car extends Vehicle{
    private Integer gears;

        public Integer getGears() {
            return gears;
        }

        public void setGears(Integer gears) {
            this.gears = gears;
        }
    }

    @Entity
    @Table(name = "boat_car_per_class")
    public class Boat extends Vehicle{
        private Integer engines;

        public Integer getEngines() {
            return engines;
        }

        public void setEngines(Integer engines) {
            this.engines = engines;
        }
    }

}
