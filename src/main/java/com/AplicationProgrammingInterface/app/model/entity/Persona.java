package com.AplicationProgrammingInterface.app.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "personas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Persona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	private String genero;
	private String edad;
	private String identificacion;
	private String direccion;
	private String telefono;
	private static final long serialVersionUID = 1L;

}
