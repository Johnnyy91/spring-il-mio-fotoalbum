package com.example.fotoalbum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Categorie")
public class Categorie {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;

}
