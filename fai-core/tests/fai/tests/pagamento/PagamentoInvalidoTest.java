package fai.tests.pagamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import fai.domain.Pagamento;
import fai.domain.Resultado;

@RunWith(SpringJUnit4ClassRunner.class)
// specifies the Spring configuration to load for this test fixture
@ContextConfiguration(locations = { "/fai/tests/resources/testContext.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PagamentoInvalidoTest {

	@Autowired
	private IDAO<Pagamento> pagamentoDao;

	@Autowired
	private IFachada<Pagamento> fachadaDAO;

	@Autowired
	private Pagamento pagamento;

	@Before
	public void setUp() {
		pagamento.getSacado().setCredito(100.0);
	}

	@Test
	public void deveProcessarPagamento() {
		Resultado<Pagamento> resultado = fachadaDAO.salvar(pagamento);
		assertNotNull(resultado);
		assertEquals(1, resultado.getMensagens().size());
	}
}
