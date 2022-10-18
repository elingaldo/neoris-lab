package com.AplicationProgrammingInterface.app.model.dto.cuenta;

import com.AplicationProgrammingInterface.app.enu.TipoCuenta;
import com.AplicationProgrammingInterface.app.model.dto.cliente.ClienteNombreDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDtoNombreCliente {
	
	private Integer numeroCuenta;
	private TipoCuenta tipoCuenta;
	private Double saldoInicial;
	private String estado;
	private ClienteNombreDto cliente;

}