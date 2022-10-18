package com.AplicationProgrammingInterface.app.model.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
	
	private String nombre;
	private String direccion;
	private String telefono;
	private String contrasena;
	private Boolean estado;
	
}
