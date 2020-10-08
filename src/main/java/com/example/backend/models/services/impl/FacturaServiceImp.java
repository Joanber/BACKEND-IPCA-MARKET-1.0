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
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	    Date desdee = null;
		try {
			desdee = formater.parse(desde);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Date hastaa = null;
		try {
			hastaa = formater.parse(hasta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facturaRepository.findProductosByFecha(desdee, hastaa);
	}


	

}
