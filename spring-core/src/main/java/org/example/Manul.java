package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Manul implements  Cat{

    @Value("${manul.name}")
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

     public String sleep() {
         return ("Я манул, сплю ");
    }

    public String eat() {
        return null;
    }

}
