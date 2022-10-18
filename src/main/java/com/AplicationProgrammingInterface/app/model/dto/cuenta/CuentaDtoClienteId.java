package com.AplicationProgrammingInterface.app.model.dto.cuenta;

import javax.validation.constraints.NotEmpty;

import com.AplicationProgrammingInterface.app.enu.TipoCuenta;
import com.AplicationProgrammingInterface.app.model.dto.cliente.ClienteIdDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDtoClienteId {
	
	private Integer numeroCuenta;
	private TipoCuenta tipoCuenta;
	private Double saldoInicial;
	
    @NotEmpty(message = "estado no debe ser nulo")
	private String estado;
    
    @NotEmpty(message = "cliente no debe ser nulo")
	private ClienteIdDto cliente;

}
