import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
/*
  "ip": "188.251.54.140",
  "city": "Porto",
  "region": "Porto",
  "country": "PT",
  "loc": "41.1496,-8.6110",
  "org": "AS3243 MEO - SERVICOS DE COMUNICACOES E MULTIMEDIA S.A.",
  "postal": "4000-000",
  "timezone": "Europe/Lisbon",
  "readme": "https://ipinfo.io/missingauth"
}
 */
public class MyPojo {

    private String ip;
    private String city;
    private String region;
    private String country;
    private String loc;
    private String org;
    private String postal;
    private String timezone;
    private String readme;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }


    @Override
    public String toString() {
        return "MyPojo{" +
                "ip='" + ip + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", loc='" + loc + '\'' +
                ", org='" + org + '\'' +
                ", postal='" + postal + '\'' +
                ", timezone='" + timezone + '\'' +
                ", readme='" + readme + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {


        ObjectMapper mapper = new ObjectMapper();

        MyPojo myPojo = mapper.readValue(new URL("https://ipinfo.io/json"), MyPojo.class);

        System.out.println(myPojo);


    }



}
