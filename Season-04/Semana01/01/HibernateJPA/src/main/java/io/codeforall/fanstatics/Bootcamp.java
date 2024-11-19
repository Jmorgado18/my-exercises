package io.codeforall.fanstatics;

import javax.persistence.Embeddable;

@Embeddable
public class Bootcamp {

    private String bootcamp_name;

    public void setBootcamp_name(String bootcamp_name) {
        this.bootcamp_name = bootcamp_name;
    }

    public String getBootcamp_name() {
        return bootcamp_name;
    }
}
