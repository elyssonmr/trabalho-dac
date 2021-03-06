/*
 * QUADRANS TECNOLOGIA;
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Cria��o: Aug 22, 2014<br>
 * <br>
 * Todos os direitos reservados.
 */

package fai.dao.jpa.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fai.dao.IDAO;
import fai.domain.EntidadeDominio;

@Component
public abstract class AbstractJpaDAO<E extends EntidadeDominio> implements
		IDAO<E> {
	protected EntityManagerFactory emf;

	@PersistenceContext
	protected EntityManager em;

	@Transactional
	public void salvar(E entidade) {
		em.persist(entidade);
	}

	@Override
	@Transactional
	public void alterar(E entidade) {
		em.merge(entidade);			
	}
	@Override
	@Transactional
	public void excluir(E entidade) {
		entidade = (E) em.find(entidade.getClass(), entidade.getId());
        if (entidade != null) {
        	em.remove(entidade);
        }
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
}
