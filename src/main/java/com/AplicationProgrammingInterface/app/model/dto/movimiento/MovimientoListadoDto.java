package com.AplicationProgrammingInterface.app.model.dto.movimiento;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoListadoDto {
	
	private Date fechaInicio;
	private Date fechaFin;
	private Long idCliente;
	
}
