package fai.tests.pagamento;

import static org.junit.Assert.*;

import java.util.List;

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
import fai.core.controle.IFachadaDAO;
import fai.dao.IDAO;
import fai.dao.jpa.impl.ClienteDAO;
import fai.domain.Cliente;
import fai.domain.Pagamento;
import fai.domain.Resultado;

@RunWith(SpringJUnit4ClassRunner.class)
// specifies the Spring configuration to load for this test fixture
@ContextConfiguration(locations = { "/fai/tests/resources/testContext.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PagamentoValidoTest {

	@Autowired
	private IDAO<Pagamento> pagamentoDao;
	
	@Autowired
	private IFachadaDAO<Pagamento> fachadaDAO;

	@Autowired
	private Pagamento pagamento;

	@Before
	public void setUp() {
		fachadaDAO.salvar(pagamento);
	}

	@Test
	public void deveProcessarPagamento() {
		List<Pagamento> pagamentos = pagamentoDao.consultar(pagamento);
		assertNotNull(pagamentos);
		assertEquals(1, pagamentos.size());
		assertNotNull(pagamentos.get(0).getId());
	}

}
