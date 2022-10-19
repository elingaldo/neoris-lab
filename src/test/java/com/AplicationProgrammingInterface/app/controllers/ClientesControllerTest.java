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

import com.AplicationProgrammingInterface.app.model.dto.cliente.ClienteDto;
import com.AplicationProgrammingInterface.app.service.ClienteService;
import com.AplicationProgrammingInterface.app.service.MapperService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClientesController.class)
public class ClientesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClienteService clienteService;
	
	@MockBean
	private MapperService mapperService;
	
	private ClienteDto clienteDto;
	
	@BeforeEach
	public void setup() {
		clienteDto = new ClienteDto(1L, "", "", "", "", true);
	}
	

	@Test
	public void testGetClientesList() throws Exception {
		when(mapperService.mapperListClienteToListClienteDto(clienteService.listado())).thenReturn(Collections.singletonList(clienteDto));
		mockMvc.perform(get("/api/cliente/listado"))
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
		   .andExpect((ResultMatcher) jsonPath("$").isArray());
	}
}
