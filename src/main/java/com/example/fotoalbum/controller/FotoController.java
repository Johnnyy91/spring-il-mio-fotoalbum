package com.example.fotoalbum.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fotoalbum.model.Foto;
import com.example.fotoalbum.repository.FotoRepository;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/")
public class FotoController {
	
	@GetMapping()
	public String home(@RequestParam(name="keyword", required = false) String keyword, Model model) {
		
		List<Foto> listFoto;
		
		if (keyword!=null && !keyword.isEmpty()) {
			
			 listFoto = fotorepository.findByTitleLike("%" + keyword + "%");
			
		} else {
			
			 listFoto = fotorepository.findAll();
		}
		model.addAttribute("foto", listFoto);
		return "index";
	}
	
	 @Autowired
	 FotoRepository fotorepository;
	 
	 // SEARCH FOTO
	 @GetMapping("/foto/{id}")
	 public String detail_id (@PathVariable("id") Integer id , Model model ) {
		 
		 Optional<Foto> k = fotorepository.findById(id);
		 
		 if (k.isPresent()) {
			 model.addAttribute("foto", k.get());
		 } else {
			 return "404";
		 }
		 
		 return "/detail_id";
	 }
	 
	 
	     // CREATE FOTO
         @GetMapping("/create")
         public String create(Model model) {
        	 Foto foto = new Foto();
            model.addAttribute("foto", foto);
            return "/create";
            
         }
		
		@PostMapping("/create")  	
		public String store(
			@Valid @ModelAttribute("foto") Foto formFoto, 
			BindingResult bindingResult,
			Model model){
			
			if (bindingResult.hasErrors())
				return "/create";
			
			fotorepository.save(formFoto);
			
			return "redirect:/"; 
			
		}
		
		//DETAIL FOTO
		  @GetMapping("/detail/{id}")
	         public String detail(@PathVariable("id") Integer id, Model model) {
			  Foto foto=fotorepository.getReferenceById(id);
			  
	            model.addAttribute("foto", foto);
	            return "/detail";
	            
	         }
		  
		@PostMapping("/detail/{id}")  	
		public String detail(
			@Valid @ModelAttribute("foto") Foto formFoto, 
			BindingResult bindingResult,
			Model model){
			
			if (bindingResult.hasErrors())
				return "/detail";
			
			fotorepository.save(formFoto);
			
			return "redirect:/"; 
			
		}
		
		
		// EDIT FOTO
		@GetMapping("/edit/{id}")		
		public String edit(@PathVariable("id") Integer id, Model model) {		
			Foto foto=fotorepository.getReferenceById(id); 
			
			model.addAttribute("foto", foto);
			return "/edit";
		}
		
		@PostMapping("/edit/{id}")		
		public String update(
				@Valid @ModelAttribute Foto formFoto,
				BindingResult bindingResult,
				Model model) {
			
			
			 if (bindingResult.hasErrors())
				return "/edit";
			
			    fotorepository.save(formFoto);
			
			    return "redirect:/";
		} 
		
		
		
		// DELETE FOTO
		@PostMapping("/delete/{id}")
		public String delete(@PathVariable("id") Integer id) {
		 
		   fotorepository.deleteById(id);
		   
		   return "redirect:/";
		}

}
