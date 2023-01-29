package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.Cat;
import org.example.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Service
public class CatService {

    @Autowired private CatRepository repo;

    public List<Cat> getCats() {
        return repo.findAll();
    }

    public void saveCat(Cat newCat){
        repo.save(newCat);
    }

    public Cat readCat(Long id){
        return repo.findById(id).orElse(null);
    }

    public void deleteCat(Long id){
        repo.deleteById(id);
    }

}
