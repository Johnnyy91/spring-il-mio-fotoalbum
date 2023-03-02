package com.example.fotoalbum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fotoalbum.model.Foto;


public interface FotoRepository extends JpaRepository<Foto , Integer>{
	
	public List<Foto> findByTitleLike(String title);

}
