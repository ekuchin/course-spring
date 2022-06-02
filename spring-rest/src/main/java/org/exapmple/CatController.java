package org.exapmple;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CatController {

    private CatRepository repository;

    public CatController(CatRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cats")
    List<Cat> getAll(){
        return repository.findAll();
    }

    @GetMapping("/cat/{id}")
    Cat getOne(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new CatNotFoundException(id));
    }

    @PostMapping("/cat")
    ResponseEntity<Cat> add(@RequestBody Cat newCat) {
       return new ResponseEntity<>(repository.save(newCat), HttpStatus.CREATED);
    }

    @PostMapping("/cat/{id}")
    Cat replace(@RequestBody Cat newCat, @PathVariable Long id){
        newCat.setId(id);
        return repository.save(newCat);
    }

    @DeleteMapping("/cat/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
