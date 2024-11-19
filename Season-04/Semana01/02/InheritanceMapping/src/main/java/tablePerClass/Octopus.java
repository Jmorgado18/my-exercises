package tablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "octopus")
public class Octopus extends Animal{

    private Integer numberOfArms;

    public Integer getNumberOfArms() {
        return numberOfArms;
    }

    public void setNumberOfArms(Integer numberOfArms) {
        this.numberOfArms = numberOfArms;
    }
}
