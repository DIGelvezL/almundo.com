package com.almundo.prueba.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import com.almundo.prueba.repository.EmpleadoRepository;
import com.almundo.prueba.repository.LlamadaRepository;
import com.almundo.prueba.service.Dispatcher;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/test/resources/test-servlet-context.xml"})
public class LlamadasControllerTest {

	@Autowired
	private LlamadasController llamadasController;
	
	@InjectMocks
	@Autowired
	private Dispatcher dispatcher;	
	
	@Mock
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Mock
	@Autowired
	private LlamadaRepository llamadaRepository;;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(llamadasController, "dispatcher", dispatcher);
		ReflectionTestUtils.setField(dispatcher, "empleadoRepository", empleadoRepository);
		ReflectionTestUtils.setField(dispatcher, "llamadaRepository", llamadaRepository);
	}

	@Test
	public void testResponderLlamada() throws Exception {

		Long numeroLlamada = 1L;
		for(int i=0; i<=10; i++){
			numeroLlamada += 1;
			dispatcher.dispatchCall(numeroLlamada);
			llamadasController.responderLlamada(numeroLlamada);
		}
	}
}
