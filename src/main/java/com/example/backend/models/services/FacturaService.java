package com.example.backend.models.services;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.example.backend.models.DetalleFactura;
import com.example.backend.models.Factura;
import com.example.backend.pojos.ProductosBajosInventario;
import com.example.backend.pojos.ProductosInventario;
import com.example.backend.pojos.ProductosVentas;



public interface FacturaService {
	
	public List<Factura> findAll();

    public Factura save(Factura factura);

    public void delete(Long id);
    
    public Factura findById(Long id);
    
    public List<ProductosVentas> findProductoByFecha(String desde, String hasta);
    
    public List<ProductosBajosInventario> findProductosBajosEnInventario();
    
    public List<ProductosInventario> findProductosInventario();
    
    public List<ProductosInventario> findProductosInventarioPorCategoria(String categoria);
    
    public List<ProductosVentas> findProductosByFechaUsuario(String desde, String hasta, String username);
    
    public Page<Factura> findAll(Pageable pageable);
    
    public Page<Factura> findByUsuarioUsernameAndFecha(Pageable pageable,String username,String fecha);
    
    public Page<Factura> findByFecha(Pageable pageable,String fecha);
    
    public DetalleFactura findByIdDetalle(Long id);
    
    
    
}
