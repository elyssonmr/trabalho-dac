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
		List<P> clientes;
		clientes = new ArrayList<P>();

		if (p.getAgencia() != null && p.getConta() != null
				&& p.getSenha() != null) {
			Cliente resp = consultar(p.getAgencia(), p.getConta(), p.getSenha());

			if (resp != null) {
				clientes.add((P) resp);
			} else {
				clientes.clear();
			}
			return clientes;
		}

		if (p.getId() != null) {
			Cliente resp = consultar(entidade.getId());
			if (resp != null) {
				clientes.add((P) resp);
			}
		} else {
			clientes = em.createQuery("SELECT c FROM Cliente c").getResultList();
		}

		return clientes;
	}

	private Cliente consultar(String agencia, String conta, String senha) {
		try {
		Query con = em
				.createQuery("SELECT c FROM Cliente c WHERE c.agencia = :agencia AND c.conta = :conta AND c.senha = :senha");
		con.setParameter("agencia", agencia);
		con.setParameter("conta", conta);
		con.setParameter("senha", senha);
		
		return (Cliente) con.getSingleResult();
		} catch(Exception ex) {
			return null;
		}
	}

	private Cliente consultar(Long id) {
		return em.find(Cliente.class, id);
	}
}