package fai.dao.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

<<<<<<< HEAD
import fai.domain.Cliente;
=======
>>>>>>> elyssonmr
import fai.domain.Emprestimo;

public class EmprestimoDAO<P extends Emprestimo> extends AbstractJpaDAO<P> {

	@Override
	public List<P> consultar(P entidade) {
		Emprestimo p = (Emprestimo) entidade;
		List<P> emprestimos;
		emprestimos = new ArrayList<P>();

		if (p.getCliente() != null && p.getCliente().getNome() != null) {
<<<<<<< HEAD
			emprestimos.add((P) consultar(p.getCliente().getNome()));
=======
			emprestimos = consultar(p.getCliente().getNome());
		} else if (p.getCliente() != null && p.getCliente().getId() != null) {
			emprestimos = consultarByClienteId(p.getCliente().getId());
>>>>>>> elyssonmr
		} else {
			emprestimos.add((P) consultar(entidade.getId()));
		}

		return emprestimos;
	}
	
<<<<<<< HEAD
	private Emprestimo consultar(String cliente) {
		Query con = em
				.createQuery("SELECT e FROM Emprestimo e WHERE e.cliente.nome = :cliente");
		con.setParameter("nome", cliente);
		return (Emprestimo) con.getSingleResult();
=======
	private List<P> consultar(String cliente) {
		Query con = em
				.createQuery("SELECT e FROM Emprestimo e WHERE e.cliente.nome = :cliente");
		con.setParameter("nome", cliente);
		return (List<P>) con.getResultList();
	}
	
	private List<P> consultarByClienteId(Long id) {
		Query con = em
				.createQuery("SELECT e FROM Emprestimo e WHERE e.cliente.id = :id");
		con.setParameter("id", id);
		return (List<P>) con.getResultList();
>>>>>>> elyssonmr
	}
	
	private Emprestimo consultar(Long id) {
		return em.find(Emprestimo.class, id);
	}
}
