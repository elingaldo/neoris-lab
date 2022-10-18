package com.AplicationProgrammingInterface.app.model.dto.movimiento;

import java.util.Date;


import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaNumeroDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDto {
	
	private String tipoMovimiento;
	private Integer valor; 
	
	private CuentaNumeroDto cuenta;

}
