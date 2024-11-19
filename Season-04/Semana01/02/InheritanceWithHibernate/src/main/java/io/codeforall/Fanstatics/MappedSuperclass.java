package io.codeforall.Fanstatics;

import com.sun.jdi.PrimitiveValue;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.Date;
@javax.persistence.MappedSuperclass
public class MappedSuperclass {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Version
        private Integer version;

        @CreationTimestamp
        private Date creationTime;

        @UpdateTimestamp
        private Date updateTime;


        @Entity
        @Table(name = "costumer")
        public static class Customer extends MappedSuperclass {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        @Entity
        @Table(name = "account")
        public static class Account extends MappedSuperclass {
            private Double Ballance;

            public Double getBallance() {
                return Ballance;
            }

            public void setBallance(Double ballance) {
                Ballance = ballance;
            }
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

