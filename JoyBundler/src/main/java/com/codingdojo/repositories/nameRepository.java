package com.codingdojo.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Name;

@Repository
public interface nameRepository extends  CrudRepository<Name, Long>{
	
	@SuppressWarnings("unchecked")
	Name save(Name name);
	List<Name> findAll();


}
