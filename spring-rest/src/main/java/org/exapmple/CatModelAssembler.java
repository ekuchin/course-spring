package org.exapmple;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CatModelAssembler implements RepresentationModelAssembler<Cat, EntityModel<Cat>> {
    @Override
    public EntityModel<Cat> toModel(Cat cat) {
        return EntityModel.of(cat,
                linkTo(methodOn(CatHateoasController.class).getOne(cat.getId())).withSelfRel(),
                linkTo(methodOn(CatHateoasController.class).getAll()).withRel("cats"),
                linkTo(methodOn(CatHateoasController.class).getPlace(cat.getPlace())).withRel("place")
        );
    }
}