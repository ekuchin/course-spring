package org.exapmple;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/rest")
public class CatHateoasController {

    private CatRepository repository;
    private PlaceRepository placeRepository;
    private CatModelAssembler assembler;
    private PlaceModelAssembler placeAssembler;

    public CatHateoasController(CatRepository repository, CatModelAssembler assembler,
                                PlaceRepository placeRepository, PlaceModelAssembler placeAssembler) {
        this.repository = repository;
        this.assembler = assembler;
        this.placeRepository = placeRepository;
        this.placeAssembler = placeAssembler;
    }

/*
    @GetMapping("/cat/{id}")
    EntityModel<Cat> getOne(@PathVariable Long id){

        Cat cat = repository.findById(id).orElseThrow(() -> new CatNotFoundException(id));
        return EntityModel.of(cat,
                linkTo(methodOn(CatHateoasController.class).getOne(id)).withSelfRel(),
                linkTo(methodOn(CatHateoasController.class).getAll()).withRel("cats")
        );
    }

    @GetMapping("/cats")
    CollectionModel<EntityModel<Cat>> getAll() {

        List<EntityModel<Cat>> cats = repository.findAll().stream()
                .map(cat -> EntityModel.of(cat,
                        linkTo(methodOn(CatHateoasController.class).getOne(cat.getId())).withSelfRel(),
                        linkTo(methodOn(CatHateoasController.class).getAll()).withRel("cats")))
                .collect(Collectors.toList());

        return CollectionModel.of(cats, linkTo(methodOn(CatHateoasController.class).getAll()).withSelfRel());
    }

*/

    @GetMapping("/cat/{id}")
    EntityModel<Cat> getOne(@PathVariable Long id){

        Cat cat = repository.findById(id).orElseThrow(() -> new CatNotFoundException(id));
        return assembler.toModel(cat);
    }

    @GetMapping("/place/{id}")
    EntityModel<Place> getPlace(@PathVariable Long id){

        Place place = placeRepository.findById(id).orElseThrow(() -> new CatNotFoundException(id));
        return placeAssembler.toModel(place);
    }

    @GetMapping("/cats")
    CollectionModel<EntityModel<Cat>> getAll() {
        List<EntityModel<Cat>> cats = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(cats, linkTo(methodOn(CatHateoasController.class).getAll()).withSelfRel());
    }
}

