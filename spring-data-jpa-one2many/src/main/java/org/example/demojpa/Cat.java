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

    public List<Kitten> getChildren() {
        return children;
    }

    public void setChildren(List<Kitten> children) {
        this.children = children;
    }

    /*
        //Uni-directional
        @OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
        @JoinColumn(name="parent_id")
    */
    //Bi-directional
    @OneToMany (fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "parent")
    private List<Kitten> children;

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
