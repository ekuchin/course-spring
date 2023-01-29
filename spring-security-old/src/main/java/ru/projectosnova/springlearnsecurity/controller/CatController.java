package ru.projectosnova.springlearnsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.projectosnova.springlearnsecurity.entity.Cat;
import ru.projectosnova.springlearnsecurity.repository.CatRepository;

@RestController
@CrossOrigin(origins = "*")
public class CatController {

    @Autowired
    CatRepository repo;


    @GetMapping("/cats")
     public ResponseEntity<?> getCats() throws Exception {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }




}
