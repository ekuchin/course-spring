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

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="cats_places",
        joinColumns = {
            @JoinColumn(name="cat_id", referencedColumnName="id") },
        inverseJoinColumns ={
            @JoinColumn(name = "place_id", referencedColumnName = "id")
        }
    )
    private List<Place> places;

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
