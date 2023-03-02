package com.example.fotoalbum.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="Foto")
public class Foto {
	
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="name must be not null")
	@NotEmpty(message="name must be not empty")
	private String title;
	
	@NotNull(message="description must be not null")
	@NotEmpty(message="description must be not empty")
	private String description;
	
	@NotNull(message="imgPath must be not null")
	@NotEmpty(message="imgPath must be not empty")
	private String url;
	
	@NotNull(message="price must be not null")
	private String tag;
	
	@NotNull(message="price must be not null")
	private boolean visible;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public List<Categorie> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categorie> categorie) {
		this.categorie = categorie;
	}



	@ManyToMany(cascade = CascadeType.ALL)
	private List<Categorie> categorie;


}
