package fai.dao.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import fai.domain.Pagamento;

@Component
public class PagamentoDAO<P extends Pagamento> extends AbstractJpaDAO<P> {

	@Override
	public List<P> consultar(P entidade) {
		Pagamento p = (Pagamento) entidade;
		List<P> clientes;
		clientes = new ArrayList<P>();

		if (p.getId() != null) {
			Pagamento resp = consultar(entidade.getId());
			if (resp != null) {
				clientes.add((P) resp);
			}

		} else {
//			if (p.getAgencia() != null && p.getConta() != null
//					&& p.getSenha() != null) {
//				Pagamento resp = consultar(p.getAgencia(), p.getConta(),
//						p.getSenha());
//
//				if (resp != null) {
//					clientes.add((P) resp);
//				}
//			}
		}

		return clientes;
	}

	private Pagamento consultar(String agencia, String conta, String senha) {
		Query con = em
				.createQuery("SELECT c FROM Cliente c WHERE c.agencia = :agencia AND c.conta = :conta AND c.senha = :senha");
		con.setParameter("agencia", agencia);
		con.setParameter("conta", conta);
		con.setParameter("senha", senha);
		return (Pagamento) con.getSingleResult();
	}

	private Pagamento consultar(Long id) {
		return em.find(Pagamento.class, id);
	}
}