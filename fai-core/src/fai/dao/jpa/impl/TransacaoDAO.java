package fai.dao.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import fai.domain.Transacao;

public class TransacaoDAO<P extends Transacao> extends AbstractJpaDAO<P> {

	@Override
	public List<P> consultar(P entidade) {
		Transacao p = (Transacao) entidade;
		List<P> transacoes;
		transacoes = new ArrayList<P>();

		if (p.getCliente() != null && p.getCliente().getNome() != null) {
			transacoes = consultar(p.getCliente().getNome());
		} else if (p.getCliente() != null && p.getCliente().getId() != null) {
			transacoes = consultarByClienteId(p.getCliente().getId());
		} else {
			transacoes.add((P) consultar(entidade.getId()));
		}

		return transacoes;
	}
	
	private List<P> consultar(String cliente) {
		Query con = em
				.createQuery("SELECT t FROM Transacao t WHERE t.cliente.nome = :cliente");
		con.setParameter("nome", cliente);
		return (List<P>) con.getResultList();
	}
	
	private List<P> consultarByClienteId(Long id) {
		Query con = em
				.createQuery("SELECT t FROM Transacao t WHERE t.cliente.id = :id");
		con.setParameter("id", id);
		return (List<P>) con.getResultList();
	}
	
	private Transacao consultar(Long id) {
		return em.find(Transacao.class, id);
	}

}
