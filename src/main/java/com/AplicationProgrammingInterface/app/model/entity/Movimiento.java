package com.AplicationProgrammingInterface.app.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movimientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Date fecha;
	private String tipoMovimiento;
	private Integer valor; 
	private Integer saldo;
	
	private static final long serialVersionUID = 1L;

}
