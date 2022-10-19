package com.AplicationProgrammingInterface.app.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.AplicationProgrammingInterface.app.enu.TipoCuenta;
import com.AplicationProgrammingInterface.app.model.dto.cliente.ClienteNombreDto;
import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDtoNombreCliente;
import com.AplicationProgrammingInterface.app.service.CuentaService;
import com.AplicationProgrammingInterface.app.service.MapperService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CuentasController.class)
public class CuentasControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CuentaService cuentaService;
	
	@MockBean
	private MapperService mapperService;
	
	private CuentaDtoNombreCliente cuentaDtoNombreCliente;
	
	private ClienteNombreDto clienteNombreDto;
	
	@BeforeEach
	public void setup() {
		clienteNombreDto = new ClienteNombreDto("Aldo");
		cuentaDtoNombreCliente = new CuentaDtoNombreCliente(1, TipoCuenta.AHORRO, 2.00, true, clienteNombreDto);
	}
	
	@Test
	public void testGetCuentasList() throws Exception {
		when(mapperService.mapperListCuentaToListCuentaDtoNombreCliente(cuentaService.list())).thenReturn(Collections.singletonList(cuentaDtoNombreCliente));

		mockMvc.perform(get("/api/cuenta/listado"))
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
		   .andExpect((ResultMatcher) jsonPath("$").isArray());
	}

}
