package com.example.backend.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.backend.models.Categoria;



public interface CategoriaService {
	
	public List<Categoria> findAll();

    public Categoria save(Categoria categoria);

    public void delete(Long id);
    
    public Categoria findById(Long id);
    
    public List<Categoria> findAllByOrderByIdAsc();
    
    public Categoria findByNombre(String nombre);
    
    public Page<Categoria> findAll(Pageable pageable);

}
