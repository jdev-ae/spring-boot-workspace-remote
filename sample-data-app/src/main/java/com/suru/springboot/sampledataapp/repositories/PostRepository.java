package com.suru.springboot.sampledataapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.suru.springboot.sampledataapp.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
	List<Post> findByAuthorId(Long id);
}

// Query creation from method names
/*

public interface PersonRepository extends Repository<User, Long> {

	List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

	// Enables the distinct flag for the query
	List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);

	List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

	// Enabling ignoring case for an individual property
	List<Person> findByLastnameIgnoreCase(String lastname);

	// Enabling ignoring case for all suitable properties
	List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

	// Enabling static ORDER BY for a query
	List<Person> findByLastnameOrderByFirstnameAsc(String lastname);

	List<Person> findByLastnameOrderByFirstnameDesc(String lastname);
}

*/