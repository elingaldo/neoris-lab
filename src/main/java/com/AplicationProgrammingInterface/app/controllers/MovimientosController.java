package com.AplicationProgrammingInterface.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.AplicationProgrammingInterface.app.model.dto.movimiento.MovimientoDto;
import com.AplicationProgrammingInterface.app.model.dto.movimiento.MovimientoListadoDto;
import com.AplicationProgrammingInterface.app.model.entity.Movimiento;
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
	
	
	@PostMapping("/guardar")
	public ResponseEntity<MovimientoDto> save(@Valid @RequestBody MovimientoDto movimientoDto) throws Exception{
		Movimiento movimiento = movimientoService.save(mapperService.mapperMovimientoToMovimientoDto(movimientoDto));
		return new ResponseEntity<>(mapperService.mapperMovimientoDtoToMovimiento(movimiento), HttpStatus.OK);
	}
	
	@GetMapping("/listado")
	public ResponseEntity<List<Movimiento>> listado(@Valid @RequestBody MovimientoListadoDto movimientoListadoDto){
		return new ResponseEntity<>(movimientoService.listado(movimientoListadoDto.getIdCliente(), movimientoListadoDto.getFechaInicio(), movimientoListadoDto.getFechaFin()), HttpStatus.OK);
	}
	

}


