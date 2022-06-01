package ru.projectosnova.springlearnaop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Cat {

    private Long id;
    private String name;
    private String breed;

    public Cat(){}

    public Cat(Long id, String name, String breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

    public void sleep(){
        System.out.println("Sleep");
        this.eat();
    }

    @SayMeow
    public void eat(){
        System.out.println("Eat");
    }

    public void jump(){
        System.out.println("Прыжок !");
    }

    public void crush() throws Exception {
        //throw new Exception("Кот сломался");
        System.out.println("Кот разбит, но не сломлен !");
    }
}