package ManyToMany;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sgroups")
public class SecurityGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(
            mappedBy = "sgroups",
            fetch = FetchType.LAZY
    )
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if(this.users == null){
            this.users = new ArrayList<>();
        }
        this.users.add(user);
    }
}
