package fai.dao.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import fai.domain.Cliente;

@Component
public class ClienteDAO<P extends Cliente> extends AbstractJpaDAO<P> {

	@Override
	public List<P> consultar(P entidade) {
		Cliente p = (Cliente) entidade;
		List<P> produtos;
		produtos = new ArrayList<P>();
		
		if (p.getId() != 0) {			
			produtos.add((P) consultar(entidade.getId()));

		} else {
			if (p.getAgencia() != null && p.getConta() != null
					&& p.getSenha() != null) {
				produtos.add((P) consultar(p.getAgencia(), p.getConta(),
						p.getSenha()));
			}
		}

		return produtos;
	}

	private Cliente consultar(String agencia, String conta, String senha) {
		Query con = em
				.createQuery("SELECT c FROM Cliente c WHERE c.agencia = :agencia AND c.conta = :conta AND c.senha = :senha");
		con.setParameter("agencia", agencia);
		con.setParameter("conta", conta);
		con.setParameter("senha", senha);
		return (Cliente) con.getSingleResult();
	}

	private Cliente consultar(Long id) {
		return em.find(Cliente.class, id);
	}
}