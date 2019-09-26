package com.example.springhateosdemo2.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
	
	@NotNull
	@Id
	private int id;
	
	@NotNull
    @Field
	private String firstName;
	
	@NotNull
    @Field
	private String lastName;
	
	@NotNull
    @Field
	private String dateOfBirth;
	
	@NotNull
    @Field
	private String profession;
	
	@NotNull
    @Field
	private long salary;

    @Field
	private List<GymMembership> memberships;
}
