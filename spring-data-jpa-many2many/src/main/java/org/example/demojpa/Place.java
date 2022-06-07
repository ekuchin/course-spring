package org.example.demojpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Place {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "places", fetch = FetchType.EAGER)
    private List<Cat> cats;

    public Place() {
    }

    public Place(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cats=" + cats +
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

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}
