package org.example;

//@Component
//@Primary
public class Britain implements Cat{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Britain(String name) {
        setName(name);
    }

    @Override
    public String sleep() {
        return null;
    }

    @Override
    public String eat() {
        return null;
    }



}
