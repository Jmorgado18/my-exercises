package io.codeforall.fanstatics;

import org.hibernate.type.BooleanType;

import javax.persistence.*;

@Entity
@Table(name = "cadet")
public class Cadet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Embedded
    private Bootcamp bootcamp;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }
}
