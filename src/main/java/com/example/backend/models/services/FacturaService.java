package com.example.backend.models.services;

import java.util.List;

import com.example.backend.models.Factura;
import com.example.backend.pojos.ProductosVentas;



public interface FacturaService {
	
	public List<Factura> findAll();

    public Factura save(Factura factura);

    public void delete(Long id);
    
    public Factura findById(Long id);
    
    public List<ProductosVentas> findProductoByFecha(String desde, String hasta);
    
}