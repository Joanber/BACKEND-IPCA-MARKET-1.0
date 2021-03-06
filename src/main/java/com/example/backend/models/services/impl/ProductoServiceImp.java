package com.example.backend.models.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		return productoRepository.findAllByOrderByIdDesc();
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

	@Override
	public List<Producto> findAllByOrderByIdDesc() {
		return productoRepository.findAllByOrderByIdDesc();
	}

	@Override
	public List<Producto> findProductoByCategoriaNombre(String nombre) {
		return productoRepository.findProductoByCategoriaNombre(nombre);
	}

	@Override
	public List<Producto> findByNombreOrCodigoBarras(String termino) {
		return productoRepository.findByNombreOrCodigoBarras(termino);
	}

	@Override
	public Producto findProductoByCodigoBarras(String codigo) {
		return productoRepository.findProductoByCodigoBarras(codigo);
	}

	@Override
	public List<Producto> findProductosByCodigoBarrasOrNombre(String codigo) {
		return productoRepository.findByNombreOrCodigoBarras(codigo);
	}

	@Override
	public Page<Producto> findAll(Pageable pageable) {
		return productoRepository.findAll(pageable);
	}

	

}
