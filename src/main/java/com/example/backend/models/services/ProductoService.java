package com.example.backend.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.backend.models.Producto;

public interface ProductoService {

	public List<Producto> findAll();

	public Producto save(Producto producto);

	public void delete(Long id);

	public Producto findById(Long id);
	
	public List<Producto> findAllByOrderByIdDesc();
	
	public List<Producto> findProductoByCategoriaNombre(String nombre);
	
	public List<Producto> findByNombreOrCodigoBarras(String termino);

	public Producto findProductoByCodigoBarras(String codigo);
	
	public List<Producto>  findProductosByCodigoBarrasOrNombre(String codigo);
	
	public Page<Producto> findAll(Pageable pageable);
	
	

  

}
