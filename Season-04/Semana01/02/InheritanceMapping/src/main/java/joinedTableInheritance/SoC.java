package joinedTableInheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "soc")
@Table(name = "soc")
public class SoC extends Chip{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
