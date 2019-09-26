package com.example.springhateosdemo2.model;

import org.springframework.hateoas.ResourceSupport;

import com.example.springhateosdemo2.controller.PersonController;

import lombok.Getter;

@Getter
public class PersonResource extends ResourceSupport {
	
	private final Person person;

	  public PersonResource(final Person person) {
	    this.person = person;
	    final long id = person.getId();
	    add(linkTo(PersonController.class).withRel("people"));
	    //add(linkTo(methodOn(GymMembershipController.class).all(id)).withRel("memberships"));
	    add(linkTo(methodOn(PersonController.class).get(id)).withSelfRel());
	  }

}
