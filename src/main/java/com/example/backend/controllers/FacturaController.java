package com.example.backend.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.DetalleFactura;
import com.example.backend.models.Factura;
import com.example.backend.models.Producto;
import com.example.backend.models.services.FacturaService;
import com.example.backend.models.services.ProductoService;
import com.example.backend.pojos.ProductosBajosInventario;
import com.example.backend.pojos.ProductosInventario;
import com.example.backend.pojos.ProductosVentas;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api/facturas")
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	@Autowired
	private ProductoService productoService;
	
	

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Factura factura, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Factura newFactura = null;
		Producto pro=null;
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			for(DetalleFactura detalleFactura:factura.getDetalles_facturas()) {
				pro=productoService.findById(detalleFactura.getProducto().getId());
				double nuevaCantidadPro=pro.getCantidad_maxima()-detalleFactura.getCantidad();
				pro.setCantidad_maxima(nuevaCantidadPro);
				productoService.save(pro);	
			}
			
			newFactura = facturaService.save(factura);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error  en la inserccion en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Factura insertado  con exito");
		response.put("factura", newFactura);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Factura factura = null;
		Map<String, Object> response = new HashMap<>();

		try {
			factura = facturaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error  en la consulta de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (factura == null) {
			response.put("mensaje", "El factura ID: ".concat(id.toString()).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Factura>(factura, HttpStatus.OK);
	}

	@GetMapping("/")
	public List<Factura> getFacturas() {
		return facturaService.findAll();
	}

	@GetMapping("/filtrar-producto/{codigo}")
	public List<Producto> getByCodigoBarras(@PathVariable String codigo) {
		return productoService.findByNombreOrCodigoBarras(codigo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Factura factura, BindingResult result, @PathVariable Long id) {
		Factura user = facturaService.findById(id);

		Factura facturaUpdate = null;

		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (user == null) {
			response.put("mensaje", "Error:no se pudo editar, el userente ID: ".concat(id.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {

			facturaUpdate = facturaService.save(user);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cliente actualizado con exito");
		response.put("factura", facturaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			facturaService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar al factura en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Factura eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
    
	//CONSULTA QUE TRAE LOS PRODUCTOS VENDIDOS CON LAS FECHAS DESDE HASTA
	@GetMapping("/filtrar-ventasProducto/{fecha1}/{fecha2}")
	public List<ProductosVentas> findProductoVentaByFechas(@PathVariable String fecha1, @PathVariable String fecha2) {
		return facturaService.findProductoByFecha(fecha1, fecha2);
	}
	//CONSULTA QUE TRAE LOS PRODUCTOS BAJOS EN INVENTARIO
	@GetMapping("/filtrar-productos-bajos-inventario")
	public List<ProductosBajosInventario> findProductosBajosInvetario() {
		return facturaService.findProductosBajosEnInventario();
	}
	
	//CONSULTA QUE TRAE PRODUCTOS INVENTARIO
	@GetMapping("/filtrar-productos-inventario")
	public List<ProductosInventario> findProductosInvetario() {
		return facturaService.findProductosInventario();
	}
	
	//CONSULTA QUE TRAE PRODUCTOS INVENTARIO POR CATEGORIA
	@GetMapping("/filtrar-productos-inventario-categoria/{categoria}")
	public List<ProductosInventario> findProductosInventarioCategoria(@PathVariable String categoria) {
		return facturaService.findProductosInventarioPorCategoria(categoria);
	}

}
