package fai.tests.command;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fai.dao.IDAO;
import fai.dao.jpa.impl.ClienteDAO;
import fai.domain.Cliente;
import fai.negocio.imp.AbstractValidator;
import fai.negocio.imp.ValidadorClienteExistente;

@RunWith(SpringJUnit4ClassRunner.class)
//specifies the Spring configuration to load for this test fixture
@ContextConfiguration(locations = { "/fai/tests/resources/testContext.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ValidadorClienteExistenteTest {

	@Resource
	private AbstractValidator validadorClienteExistente;
	
	@Autowired
	private IDAO<Cliente> clienteDao;
	
	@Autowired
	private Cliente cliente;

	@Before
	public void carregar() {
		this.clienteDao.salvar(cliente);
	}

	@Test
	public void testClienteExistente() {
		String erroMsg = validadorClienteExistente.execute(cliente);

		assertEquals("Cliente já cadastrado", erroMsg);
	}

	@Test
	public void testClienteInesxistente() {
		cliente.setId(20L);
		String erroMsg = validadorClienteExistente.execute(cliente);

		assertEquals(null, erroMsg);
	}
	
	@After
	public void deleteDB() {
		
	}

}
