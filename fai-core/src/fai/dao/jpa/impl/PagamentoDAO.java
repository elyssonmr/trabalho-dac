package fai.dao.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fai.domain.Pagamento;

@Component
public class PagamentoDAO<P extends Pagamento> extends AbstractJpaDAO<P> {

	@Override
	public List<P> consultar(P entidade) {
		Pagamento pagamento = (P) entidade;
		List<P> pagamentos;
		pagamentos = new ArrayList<P>();

		// findbyID or find all
		if (pagamento.getId() != null) {
			Pagamento resp = consultar(entidade.getId());
			if (resp != null) {
				pagamentos.add((P) resp);
			} else {
				pagamentos.clear();
			}
			return pagamentos;
		} else {
			pagamentos = em.createQuery("SELECT * FROM Pagamento")
					.getResultList();
		}

		return pagamentos;
	}

	private Pagamento consultar(Long id) {
		return em.find(Pagamento.class, id);
	}
}