package fai.tests.login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fai.core.controle.IFachada;
import fai.dao.IDAO;
import fai.domain.Cliente;
import fai.domain.Resultado;

@RunWith(SpringJUnit4ClassRunner.class)
// specifies the Spring configuration to load for this test fixture
@ContextConfiguration(locations = { "/fai/tests/resources/testContext.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class LoginTest {

	@Autowired
	IDAO<Cliente> clienteDao;
	
	@Autowired
	IFachada<Cliente> fachada;

	@Autowired
	private Cliente cliente;

	@Before
	public void setUp() {
		clienteDao.salvar(cliente);
	}

	@Test
	public void deveLogar() {
		cliente.setId(null);
		Resultado<Cliente> resultado = fachada.consultar(cliente);
		assertNotNull(resultado);
		assertNull(resultado.getMensagens());
		assertEquals(1, resultado.getEntidades().size());
	}
}
