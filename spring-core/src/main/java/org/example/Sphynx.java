package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Sphynx implements  Cat {
    private String name="Рамзес";

    public Sphynx(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sleep() {
        return "Я спящий сфинкс";
    }

    @Override
    public String eat() {
        return "Я поел";
    }

    private void init(){
        System.out.println("Сфинкс появился");
    }

     private void destroy(){
        System.out.println("Сфинкс удалился");
    }

}
