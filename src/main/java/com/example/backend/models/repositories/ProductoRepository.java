package com.example.backend.models.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.backend.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	public List<Producto> findAllByOrderByIdAsc();
	

}
