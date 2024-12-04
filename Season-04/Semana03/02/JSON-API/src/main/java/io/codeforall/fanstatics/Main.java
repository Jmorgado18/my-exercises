package io.codeforall.fanstatics;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            Object obj = mapper.readValue(new URL("https://ipinfo.io/json"), Object.class);
            System.out.println(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}