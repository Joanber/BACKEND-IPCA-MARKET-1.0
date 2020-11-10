package com.example.backend.pojos;

import java.util.Date;

public interface ProductosVentas {
	
	public String getCodigo_barras();

	public String getNombre();

	public int getCantidad();

	public double getPrecio();

	public String getNombre_categoria();
	
	public Date  getFecha();
	
}
