package ru.projectosnova.ru.springlearnmvc;

public class Cat {

    private String name;
    private String breed;

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public Cat() {
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
}
