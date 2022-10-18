package com.AplicationProgrammingInterface.app.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Persona implements Serializable {

	private String contrasena;
	private Boolean estado;
	
	private static final long serialVersionUID = 8280130835150657117L;

}
