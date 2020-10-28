package com.example.backend.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.models.Categoria;
import com.example.backend.models.repositories.CategoriaRepository;
import com.example.backend.models.services.CategoriaService;

@Service
public class CategoriaServiceImp implements CategoriaService{
	  
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return categoriaRepository.findAllByOrderByIdAsc();
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAllByOrderByIdAsc() {
		return categoriaRepository.findAllByOrderByIdAsc();
	}

	@Override
	public Categoria findByNombre(String nombre) {
		return categoriaRepository.findByNombre(nombre);
	}

}
