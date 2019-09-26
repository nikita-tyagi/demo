package com.example.springhateosdemo2.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springhateosdemo2.model.Person;
import com.example.springhateosdemo2.model.PersonResource;
import com.example.springhateosdemo2.repository.PersonRepository;

@RestController
@RequestMapping(value = "/people", produces = "application/hal+json")
public class PersonController {

	final PersonRepository personRepository;

	public PersonController(final PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@GetMapping
	public ResponseEntity<Resources<PersonResource>> all() {
		final List<PersonResource> collection = personRepository.findAll().stream().map(PersonResource::new)
				.collect(Collectors.toList());
		final Resources<PersonResource> resources = new Resources<>(collection);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonResource> get(@PathVariable final long id) {
		return personRepository.findById(id).map(p -> ResponseEntity.ok(new PersonResource(p)))
				.orElseThrow(() -> new PersonNotFoundException(id));
	}

	@PostMapping
	public ResponseEntity<PersonResource> post(@RequestBody final Person personFromRequest) {
		final Person person = new Person(personFromRequest);
		personRepository.save(person);
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(person.getId())
				.toUri();
		return ResponseEntity.created(uri).body(new PersonResource(person));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PersonResource> put(@PathVariable("id") final long id,
			@RequestBody Person personFromRequest) {
		final Person person = new Person(personFromRequest, id);
		personRepository.save(person);
		final PersonResource resource = new PersonResource(person);
		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).body(resource);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") final long id) {
		return personRepository.findById(id).map(p -> {
			personRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}).orElseThrow(() -> new PersonNotFoundException(id));
	}
}
