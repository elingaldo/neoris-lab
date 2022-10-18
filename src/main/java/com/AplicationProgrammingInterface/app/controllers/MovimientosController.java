package com.AplicationProgrammingInterface.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AplicationProgrammingInterface.app.service.MapperService;
import com.AplicationProgrammingInterface.app.service.MovimientoService;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientosController {
	
	private MovimientoService movimientoService;
	
	private MapperService mapperService;
	
	@Autowired
	public MovimientosController(MovimientoService movimientoService, MapperService mapperService) {
		this.movimientoService = movimientoService;
		this.mapperService = mapperService;
	}
	

}
