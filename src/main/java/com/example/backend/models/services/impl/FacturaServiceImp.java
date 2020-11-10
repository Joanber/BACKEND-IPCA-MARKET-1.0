package com.example.backend.models.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Factura;
import com.example.backend.models.repositories.FacturaRepository;
import com.example.backend.models.services.FacturaService;
import com.example.backend.pojos.ProductosBajosInventario;
import com.example.backend.pojos.ProductosInventario;
import com.example.backend.pojos.ProductosVentas;


@Service
public class FacturaServiceImp implements FacturaService {
	
	@Autowired
	private FacturaRepository facturaRepository;

	@Override
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	public Factura save(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	public void delete(Long id) {
		facturaRepository.deleteById(id);
	}

	@Override
	public Factura findById(Long id) {
		return facturaRepository.findById(id).orElse(null);
	}
	@Override
	public List<ProductosVentas> findProductoByFecha(String desde, String hasta) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date desdee = null;
		try {
			desdee = formater.parse(desde.concat(" 00:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Date hastaa = null;
		try {
			hastaa = formater.parse(hasta.concat(" 23:59:59"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facturaRepository.findProductosByFecha(desdee, hastaa);
	}

	@Override
	public List<ProductosBajosInventario> findProductosBajosEnInventario() {
		return facturaRepository.findProductosBajosEnInventario();
	}

	@Override
	public List<ProductosInventario> findProductosInventario() {
		return facturaRepository.findProductosInventario();
	}

	@Override
	public List<ProductosInventario> findProductosInventarioPorCategoria(String categoria) {
		return facturaRepository.findProductosInventarioPorCategoria(categoria);
	}

	@Override
	public List<ProductosVentas> findProductosByFechaUsuario(String desde, String hasta, String username) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date desdee = null;
		try {
			desdee = formater.parse(desde.concat(" 00:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Date hastaa = null;
		try {
			hastaa = formater.parse(hasta.concat(" 23:59:59"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facturaRepository.findProductosByFechaUsuario(desdee, hastaa, username);
	}


	

}
