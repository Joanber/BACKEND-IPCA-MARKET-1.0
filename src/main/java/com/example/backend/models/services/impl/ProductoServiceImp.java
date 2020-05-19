package com.example.backend.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Producto;
import com.example.backend.models.repositories.ProductoRepository;
import com.example.backend.models.services.ProductoService;

@Service
public class ProductoServiceImp implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void delete(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public Producto findById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

}
