package fai.tests.emprestimo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fai.dao.IDAO;
import fai.domain.Cliente;
import fai.domain.Emprestimo;
import fai.domain.EntidadeDominio;

@RunWith(SpringJUnit4ClassRunner.class)
//specifies the Spring configuration to load for this test fixture
@ContextConfiguration(locations = { "/fai/tests/resources/testContext.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EmprestimoTest {

	@Autowired
	IDAO clienteDao;
	
	@Autowired
	private Cliente cliente;
	
	@Before
	public void setup() {
		this.cliente.setDtCadastro(new Date());
		this.cliente.getTipoCliente().setDtCadastro(new Date());
		this.cliente.getEndereco().setDtCadastro(new Date());
		
		Iterator iter = this.cliente.getEmprestimos().iterator();

		Emprestimo emprestimo = (Emprestimo) iter.next();
		emprestimo.setDtCadastro(new Date());
	}

	
	
	
	@Test
	public void test() {
		clienteDao.salvar(cliente);
		System.out.println("Cliente criado");
		
		assertEquals(cliente.getCpf(), "09876543212");
		assertEquals(String.valueOf(cliente.getCredito()), "1000.0");
		assertEquals(cliente.getNome(), "Joao Marco de Paula Santana");
		assertTrue(cliente.getId() > 0);
		
		assertEquals(cliente.getEndereco().getCidade(), "Santa Rita");
		assertEquals(cliente.getEndereco().getEstado(), "Minas Gerais");
		assertEquals(cliente.getEndereco().getLogradouro(), "Rua A");
		assertEquals(cliente.getEndereco().getNumero(), "45");
		assertTrue(cliente.getEndereco().getId() > 0);
		
		assertEquals(cliente.getTipoCliente().getDescricao(), "Pessoa Fisica");
		assertTrue(cliente.getTipoCliente().getId() > 0);
		
		List<EntidadeDominio> tipos = clienteDao.consultar(cliente);
		
		System.out.println("Consulta de cliente:");
		for (EntidadeDominio e : tipos) {
			Cliente t = (Cliente) e;
			System.out.println("Cliente: " + t.getNome());
			System.out.println("Data de criacao Cliente: " + t.getDtCadastro());
			System.out.println("CPF: " + t.getCpf());
			System.out.println("Credito: " + t.getCredito());
			System.out.println("Endereço: " + t.getEndereco().getLogradouro());
			System.out.println("Cidade: " + t.getEndereco().getCidade());
			System.out.println("Estado: " + t.getEndereco().getEstado());
			System.out.println("Numero: " + t.getEndereco().getNumero());
			System.out.println("Data de criacao Endereco: " + t.getEndereco().getDtCadastro());
			System.out.println("Tipo: " + t.getTipoCliente().getDescricao());
			System.out.println("Data de criacao Tipo: " + t.getTipoCliente().getDtCadastro());
		}
		
		Iterator iter = this.cliente.getEmprestimos().iterator();

		Emprestimo emprestimo = (Emprestimo) iter.next();
		assertEquals(String.valueOf(emprestimo.getValor()), "200.0");
	}

}
