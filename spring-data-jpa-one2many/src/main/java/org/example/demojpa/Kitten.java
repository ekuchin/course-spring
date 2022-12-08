package org.example.demojpa;

import javax.persistence.*;

@Entity
public class Kitten {

    @GeneratedValue
    @Id
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="parent_id")
    private Cat parent;

    @Override
    public String toString() {
        return "Kitten{" +
                "id=" + id +
                ", name='" + name + '\'' +
             //   ", parent=" + parent +
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

    public Cat getParent() {
        return parent;
    }

    public void setParent(Cat parent) {
        this.parent = parent;
    }

    public Kitten() {
    }

    public Kitten(String name) {
        this.name = name;
    }
}
