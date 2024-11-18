package io.codeforall.fanstatics;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
public class Cadet {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String name;
    private Integer age;
    @Embedded
    private Address address;
    @Transient
    private String password;
    @CreationTimestamp
    private Date creationTime;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Version
    private  Integer version;

    public Integer getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}
