package com.AplicationProgrammingInterface.app.controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDto;
import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDtoClienteId;
import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDtoNombreCliente;
import com.AplicationProgrammingInterface.app.model.entity.Cuenta;
import com.AplicationProgrammingInterface.app.service.CuentaService;
import com.AplicationProgrammingInterface.app.service.MapperService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/cuenta")
//@NoArgsConstructor
//@AllArgsConstructor
public class CuentasController {
	
	private CuentaService cuentaService;
	
	private MapperService mapperService;
	
	@Autowired
	public CuentasController(CuentaService cuentaService, MapperService mapperService) {
		this.cuentaService = cuentaService;
		this.mapperService = mapperService;
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<CuentaDtoClienteId> save(@Valid @RequestBody CuentaDto cuentaDto){
		Cuenta cuenta = cuentaService.save(mapperService.mapperCuentaDtoTocuenta(cuentaDto));
		return new ResponseEntity<>(mapperService.mapperCuentaToCuentaDtoClienteId(cuenta), HttpStatus.OK);
	}
	
	@GetMapping("/listado")
	public ResponseEntity<List<CuentaDtoNombreCliente>> list(){
		List<Cuenta> cuenta = cuentaService.list();
		return new ResponseEntity<>(mapperService.mapperListCuentaToListCuentaDtoNombreCliente(cuenta), HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody CuentaDto cuentaDto, @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Cuenta cuentaActual = cuentaService.cuentaById(id);
		CuentaDto cuentaDtoActual = mapperService.mapperCuentaToCuentaDto(cuentaActual);

		if (cuentaActual == null) {
			response.put("mensaje", "Error:, no se pudo editar,cuenta ID: "
					.concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		try {
			cuentaDtoActual.setNumeroCuenta(cuentaDto.getNumeroCuenta());
			cuentaDtoActual.setTipoCuenta(cuentaDto.getTipoCuenta());
			cuentaDtoActual.setSaldoInicial(cuentaDto.getSaldoInicial());
			cuentaDtoActual.setEstado(cuentaDto.getEstado());
			cuentaService.save(mapperService.mapperCuentaDtoTocuenta(cuentaDtoActual));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar cliente en la base de datos");
			response.put("errors", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "cuenta ha sido actualizado con exito");
		response.put("cuenta", cuentaDtoActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws SQLIntegrityConstraintViolationException{
		cuentaService.delete(id);
		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "cuenta ha sido eliminado con exito");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
