package com.AplicationProgrammingInterface.app.model.dto.cuenta;

import com.AplicationProgrammingInterface.app.enu.TipoCuenta;
import com.AplicationProgrammingInterface.app.model.dto.cliente.ClienteIdDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDto {
	private Integer numeroCuenta;
	private TipoCuenta tipoCuenta;
	private Double saldoInicial;
	private String estado;
	private ClienteIdDto cliente;

}
