package com.example.springhateosdemo2.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import com.example.springhateosdemo2.model.Person;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "person")
public interface PersonRepository extends CouchbasePagingAndSortingRepository<Person, Integer> {

}
