package com.example.backend.models.services;

import java.util.List;

import com.example.backend.models.Producto;

public interface ProductoService {

	public List<Producto> findAll();

	public Producto save(Producto producto);

	public void delete(Long id);

	public Producto findById(Long id);
	
	public List<Producto> findAllByOrderByIdAsc();
	
	public List<Producto> findProductoByCategoriaNombre(String nombre);
	
	public List<Producto> findByNombreOrCodigoBarras(String termino);

  

}
