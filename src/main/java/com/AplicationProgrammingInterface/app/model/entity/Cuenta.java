package com.AplicationProgrammingInterface.app.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.AplicationProgrammingInterface.app.enu.TipoCuenta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cuentas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Integer numeroCuenta;
	private TipoCuenta tipoCuenta;
	private Integer saldoInicial;
	private Boolean estado;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private static final long serialVersionUID = 1L;

}
