package com.example.backend.models.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.models.Factura;
import com.example.backend.pojos.ProductosBajosInventario;
import com.example.backend.pojos.ProductosInventario;
import com.example.backend.pojos.ProductosVentas;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

	@Query(value = "SELECT p.codigo_barras AS codigo_barras,p.nombre AS nombre,df.cantidad AS cantidad,p.precio AS precio, p.precio_compra as precio_compra ,c.nombre AS nombre_categoria,"
			+ " f.fecha, CONCAT(pe.cedula,' ',pe.nombre,' ',pe.apellido) as datos_persona from productos p INNER JOIN categorias c on p.categoria_id = c.id"
			+ "	INNER JOIN detalles_facturas df on df.producto_id=p.id INNER JOIN facturas f"
			+ "	on df.factura_id=f.id"
			+ " INNER JOIN usuarios u on f.usuario_id=u.id INNER JOIN personas pe on u.persona_id=pe.id WHERE f.fecha >=?1  and f.fecha <=?2  ", nativeQuery = true)

	public List<ProductosVentas> findProductosByFecha(Date desde, Date hasta);

	@Query(value = "SELECT p.codigo_barras AS codigo_barras,p.nombre AS nombre,df.cantidad AS cantidad,"
			+ " p.precio AS precio ,p.precio_compra as precio_compra,c.nombre AS nombre_categoria, f.fecha,CONCAT(pe.cedula,' ',pe.nombre,' ',pe.apellido) as datos_persona"
			+ "	from productos p INNER JOIN categorias c on p.categoria_id = c.id"
			+ "	INNER JOIN detalles_facturas df on df.producto_id=p.id INNER JOIN facturas f on df.factura_id=f.id"
			+ "	INNER JOIN usuarios u on f.usuario_id=u.id INNER JOIN personas pe on u.persona_id=pe.id"
			+ " WHERE f.fecha >=?1  and f.fecha <=?2 and u.username=?3 ", nativeQuery = true)
	public List<ProductosVentas> findProductosByFechaUsuario(Date desde, Date hasta, String username);

	@Query(value = "SELECT p.id,p.codigo_barras, p.nombre,p.cantidad_maxima,p.cantidad_minima,p.precio,c.nombre AS nombre_categoria"
			+ " from productos p INNER JOIN categorias c on p.categoria_id = c.id where p.cantidad_maxima<p.cantidad_minima", nativeQuery = true)
	public List<ProductosBajosInventario> findProductosBajosEnInventario();

	@Query(value = "SELECT p.codigo_barras, p.nombre,p.cantidad_maxima,p.cantidad_minima,p.precio,c.nombre as nombre_categoria "
			+ " from productos p INNER JOIN categorias c on p.categoria_id = c.id", nativeQuery = true)
	public List<ProductosInventario> findProductosInventario();

	@Query(value = "SELECT p.codigo_barras, p.nombre,p.cantidad_maxima,p.cantidad_minima,p.precio,c.nombre as nombre_categoria "
			+ " from productos p INNER JOIN categorias c on p.categoria_id = c.id where c.nombre=?1", nativeQuery = true)
	public List<ProductosInventario> findProductosInventarioPorCategoria(String categoria);

}
