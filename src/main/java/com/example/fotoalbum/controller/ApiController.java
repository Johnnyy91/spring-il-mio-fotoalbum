package com.example.fotoalbum.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.fotoalbum.model.Foto;
import com.example.fotoalbum.repository.CategorieRepository;
import com.example.fotoalbum.repository.FotoRepository;

public class ApiController {
	
	@Autowired
	FotoRepository fotorepository;
	
	@Autowired
	CategorieRepository caterepository;
	
	@GetMapping() 
	public List<Foto> index(){
		return fotorepository.findAll();
	}
	
	@GetMapping("{id}")		  
	public ResponseEntity<Foto> detail(@PathVariable("id") Integer id) {
		Optional<Foto> res= fotorepository.findById(id);
		if (res.isPresent()) 
			return new ResponseEntity<Foto>(res.get(), HttpStatus.OK);
	    else
	    	return new ResponseEntity<Foto>(HttpStatus.NOT_FOUND);
	}
	

}
