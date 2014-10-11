package fai.dao.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import fai.domain.Cliente;
import fai.domain.Emprestimo;

public class EmprestimoDAO<P extends Emprestimo> extends AbstractJpaDAO<P> {

	@Override
	public List<P> consultar(P entidade) {
		Emprestimo p = (Emprestimo) entidade;
		List<P> emprestimos;
		emprestimos = new ArrayList<P>();

		if (p.getCliente() != null && p.getCliente().getNome() != null) {
			emprestimos.add((P) consultar(p.getCliente().getNome()));
		} else {
			emprestimos.add((P) consultar(entidade.getId()));
		}

		return emprestimos;
	}
	
	private Emprestimo consultar(String cliente) {
		Query con = em
				.createQuery("SELECT e FROM Emprestimo e WHERE e.cliente.nome = :cliente");
		con.setParameter("nome", cliente);
		return (Emprestimo) con.getSingleResult();
	}
	
	private Emprestimo consultar(Long id) {
		return em.find(Emprestimo.class, id);
	}
}
