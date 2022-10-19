package com.AplicationProgrammingInterface.app.controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
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

import com.AplicationProgrammingInterface.app.model.dto.cliente.ClienteDto;
import com.AplicationProgrammingInterface.app.model.entity.Cliente;
import com.AplicationProgrammingInterface.app.service.ClienteService;
import com.AplicationProgrammingInterface.app.service.MapperService;

@RestController
@RequestMapping("/api/cliente")
public class ClientesController {

	private ClienteService clienteService;

	private MapperService mapperService;

	@Autowired
	private ClientesController(ClienteService clienteService, MapperService mapperService) {
		this.clienteService = clienteService;
		this.mapperService = mapperService;
	}

	@PostMapping("/guardar")
	public ResponseEntity<ClienteDto> save(@Valid @RequestBody ClienteDto clienteDto) {
		Cliente cliente = clienteService.save(mapperService.mapperClienteDtoToCliente(clienteDto));
		return new ResponseEntity<>(mapperService.mapperClienteToClienteDto(cliente), HttpStatus.OK);
	}

	@GetMapping("/listado")
	public ResponseEntity<List<ClienteDto>> list() {
		List<ClienteDto> dto = mapperService.mapperListClienteToListClienteDto(clienteService.listado());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws SQLIntegrityConstraintViolationException {
		clienteService.delete(id);
		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "cliente ha sido eliminado con exito");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ClienteDto clienteDto, @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Cliente clienteActual = clienteService.clientById(id);
		ClienteDto clienteDtoActual = mapperService.mapperClienteToClienteDto(clienteActual);

		if (clienteActual == null) {
			response.put("mensaje", "Error:, no se pudo editar, El cliente ID: "
					.concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		try {
			clienteDtoActual.setId(clienteDto.getId());
			clienteDtoActual.setNombre(clienteDto.getNombre());
			clienteActual.setDireccion(clienteDto.getDireccion());
			clienteActual.setTelefono(clienteDto.getTelefono());
			clienteActual.setContrasena(clienteDto.getContrasena());
			clienteActual.setEstado(clienteDto.getEstado());
			clienteService.save(mapperService.mapperClienteDtoToCliente(clienteDtoActual));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar cliente en la base de datos");
			response.put("errors", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "cliente ha sido actualizado con exito");
		response.put("cliente", clienteDtoActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
