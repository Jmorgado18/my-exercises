package joinedTableInheritance;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "chip")
@Table(name = "chip")
@Inheritance(strategy = InheritanceType.JOINED)
public class Chip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer maxSpeed;

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
