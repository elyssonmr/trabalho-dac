package fai.tests.login;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fai.core.controle.IFachadaAcoes;
import fai.dao.IDAO;
import fai.dao.jpa.impl.ClienteDAO;
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
	IFachadaAcoes acoesFachada;

	@Autowired
	private Cliente cliente;

	@Before
	public void setUp() {
		clienteDao.salvar(cliente);
	}

	@Test
	public void deveLogar() {
		cliente.setId(null);
		Resultado<Cliente> resultado = acoesFachada.validadeLogin(cliente);
		assertNotNull(resultado);
		assertNull(resultado.getMensagens());
		assertEquals(1, resultado.getEntidades().size());
	}
	
	@Test
	public void deveRetornarErroAgencia() {
		cliente.setAgencia(null);
		Resultado<Cliente> resultado = acoesFachada.validadeLogin(cliente);
		
		assertNotNull(resultado);
		assertNull(resultado.getEntidades());
		assertEquals(1, resultado.getMensagens().size());
		assertTrue(resultado.getMensagens().get(0).getMsg().equals("Agencia é obrigatório!"));
	}
	@Test
	public void deveRetornarErroConta() {
		cliente.setConta(null);
		Resultado<Cliente> resultado = acoesFachada.validadeLogin(cliente);
		
		assertNotNull(resultado);
		assertNull(resultado.getEntidades());
		assertEquals(1, resultado.getMensagens().size());
		assertTrue(resultado.getMensagens().get(0).getMsg().equals("Conta é obrigatório!"));
	}
	
	@Test
	public void deveRetornarErroSenha() {
		cliente.setSenha(null);
		Resultado<Cliente> resultado = acoesFachada.validadeLogin(cliente);
		
		assertNotNull(resultado);
		assertNull(resultado.getEntidades());
		assertEquals(1, resultado.getMensagens().size());
		assertTrue(resultado.getMensagens().get(0).getMsg().equals("Senha é obrigatório!"));
	}
	
	@Test
	public void deveRetornarErroNoLogin() {
		cliente.setAgencia(null);
		cliente.setConta(null);
		cliente.setSenha(null);
		Resultado<Cliente> resultado = acoesFachada.validadeLogin(cliente);
		
		assertNotNull(resultado);
		assertNull(resultado.getEntidades());
		assertEquals(3, resultado.getMensagens().size());
	}

}
