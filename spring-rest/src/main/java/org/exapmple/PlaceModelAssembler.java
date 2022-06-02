package org.exapmple;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PlaceModelAssembler implements RepresentationModelAssembler<Place, EntityModel<Place>> {
    @Override
    public EntityModel<Place> toModel(Place place) {
        return EntityModel.of(place,
                linkTo(methodOn(CatHateoasController.class).getPlace(place.getId())).withSelfRel()
        );
    }
}
