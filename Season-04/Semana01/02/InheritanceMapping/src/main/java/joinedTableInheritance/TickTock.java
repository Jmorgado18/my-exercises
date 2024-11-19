package joinedTableInheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "ticktock")
@Table(name = "ticktock")
public class TickTock extends Chip{

    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}
