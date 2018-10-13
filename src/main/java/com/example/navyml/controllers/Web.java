package com.example.navyml.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ConfigurationProperties("my.living.rent")
class Address {

    private String city;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

@RestController
public class Web {

    @Autowired Address address;

    @RequestMapping(method = RequestMethod.GET, path = "/rent")
    @ResponseBody
    public String rent() {
        return address.getCity() + " " + address.getCountry();
    }

}