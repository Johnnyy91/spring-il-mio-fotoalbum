package com.example.fotoalbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fotoalbum.model.Categorie;
import com.example.fotoalbum.repository.CategorieRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
	
	@Autowired
	private CategorieRepository categorierepository;
	
	@GetMapping()		
	public String index(Model model) {	
		List<Categorie> res = categorierepository.findAll(Sort.by("name"));
		model.addAttribute("categorie", res);
		return "indexCategorie";
	}

	@GetMapping("/create")	
	public String create(Model model) {
		Categorie categorie =new Categorie();	

		model.addAttribute("categorie", categorie);

		return "createCategorie";
	}

	@PostMapping("/create")  
	public String store(
		@Valid @ModelAttribute("categorie") Categorie formCategorie, 
		BindingResult bindingResult,
		Model model){

		if (bindingResult.hasErrors())
			return "createCategorie";

		categorierepository.save(formCategorie);

		return "redirect:/categorie"; 

	}
	
	@GetMapping("/edit/{id}") 
	public String edit(@PathVariable("id") Integer id,Model model ) {
		
		Categorie c;
		c = categorierepository.getReferenceById(id);
		model.addAttribute("categoria", c);
		
	
		return "editCategorie";
	}
	
	@PostMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute Categorie formCategorie,
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors())
			return "editCategorie";
		
		categorierepository.save(formCategorie);
		
		return "redirect:/categorie";
		
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {

	   categorierepository.deleteById(id);

	   return "redirect:/categorie";
	}

}
