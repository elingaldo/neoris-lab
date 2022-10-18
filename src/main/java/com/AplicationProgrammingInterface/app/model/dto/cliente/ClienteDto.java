package com.AplicationProgrammingInterface.app.model.dto.cliente;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
	
	@NotEmpty(message = "nombre no debe ser nulo")
	private String nombre;
	@NotEmpty(message = "direccion no debe ser nulo")
	private String direccion;
	@NotEmpty(message = "telefono no debe ser nulo")
	private String telefono;
	@NotEmpty(message = "contrasena no debe ser nulo")
	private String contrasena;
	
	private Boolean estado = true;
	
}
