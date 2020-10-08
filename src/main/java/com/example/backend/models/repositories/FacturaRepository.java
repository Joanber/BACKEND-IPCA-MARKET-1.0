package com.example.backend.models.repositories;

import java.util.Date;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.models.Factura;
import com.example.backend.pojos.ProductosVentas;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
	
  
	@Query(value="SELECT p.codigo_barras AS codigo_barras,p.nombre AS nombre,df.cantidad AS cantidad,p.precio AS precio ,c.nombre AS nombre_categoria"
			+ "	from productos p INNER JOIN categorias c on p.categoria_id = c.id"
			+ "	INNER JOIN detalles_facturas df on df.producto_id=p.id INNER JOIN facturas f"
			+ "	on df.factura_id=f.id  WHERE f.fecha >=?1 and f.fecha <=?2" ,nativeQuery=true)
	
	public List<ProductosVentas> findProductosByFecha(Date desde, Date hasta);
}
