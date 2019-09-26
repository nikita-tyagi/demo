package com.example.springhateosdemo2.model;

import javax.validation.constraints.NotNull;

import com.couchbase.client.java.repository.annotation.Field;

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
public class GymMembership {

	@NotNull
    @Field
	private int id;

    @Field
	private Person owner;
	
	@NotNull
    @Field
	private String name;
	
	@NotNull
    @Field
	private long cost;
}
