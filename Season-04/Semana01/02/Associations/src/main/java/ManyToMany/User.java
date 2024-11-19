package ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<SecurityGroup> sgroups;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SecurityGroup> getSgroups() {
        return sgroups;
    }

    public void addSgroups(SecurityGroup sgroup) {
        if(this.sgroups == null){
           this.sgroups = new ArrayList<>();
        }
        this.sgroups.add(sgroup);
    }
}
