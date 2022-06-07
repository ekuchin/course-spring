package org.example.demojpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cat {

    @GeneratedValue
    @Id
    private Long id;

    @Column(name="imya", nullable = true, updatable = true)
    private String name;
    private String breed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bowl_id")
    private Bowl bowl;

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

    public Bowl getBowl() {
        return bowl;
    }

    public void setBowl(Bowl bowl) {
        this.bowl = bowl;
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

    public Cat(String name, String breed) {
         this.name = name;
        this.breed = breed;
    }
}
