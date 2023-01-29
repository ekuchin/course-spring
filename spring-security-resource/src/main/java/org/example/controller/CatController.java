package org.example.controller;

import org.example.model.Cat;
import org.example.repository.CatRepository;
import org.example.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping("/cats")
    public ResponseEntity<List<Cat>> getAll() {
        return ResponseEntity.ok()
                .body(catService.getCats());
    }

    @GetMapping("/cat/{id}")
    public ResponseEntity<Cat> getCat(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(catService.readCat(id));
    }

    @PostMapping("/cat")
    public void insertCat(@RequestBody Cat cat) {
        cat.setId(null);
        catService.saveCat(cat);
    }

    @PatchMapping("/cat/{id}")
    public void updateCat(@PathVariable Long id,@RequestBody Cat cat) {
        cat.setId(id);
        catService.saveCat(cat);
    }

    @DeleteMapping("/cat/{id}")
    public void deleteCat(@PathVariable Long id){
        catService.deleteCat(id);
    }

}
