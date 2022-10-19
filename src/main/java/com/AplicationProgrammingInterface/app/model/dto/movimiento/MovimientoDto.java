package com.AplicationProgrammingInterface.app.model.dto.movimiento;

import javax.validation.constraints.NotEmpty;

import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaNumeroDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDto {

	private Long Id;
	@NotEmpty(message = "tipo movimiento no debe ser nulo")
	private String tipoMovimiento;

	private Integer valor;

	private CuentaNumeroDto cuenta;

}
