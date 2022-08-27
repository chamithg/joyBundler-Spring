package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.models.Name;
import com.codingdojo.repositories.nameRepository;



@Service
public class NameService {
	
	@Autowired
	private nameRepository nameRepo;
	

    // returns all 
    public List<Name> allNames() {
        return nameRepo.findAll();
    }
    // creates 
    public  Name createName(Name name) {
//    	List <Name> allNames= nameRepo.findAll();
//    	
//    	if(allNames.contains(name))
//    	
//    	
//    
    	
        return nameRepo.save(name);
    }
    // retrieves single item
    public Name findName(Long id) {
        Optional<Name> optionalName = nameRepo.findById(id);
        if(optionalName.isPresent()) {
            return optionalName.get();
        } else {
            return null;
        }
    }
    
    public void deleteById (Long id) {
    	nameRepo.deleteById(id);
    }
    
//    

}
