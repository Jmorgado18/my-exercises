package tablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gazelle")
public class Gazelle extends Animal {

    private Integer maxSpeed;

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
