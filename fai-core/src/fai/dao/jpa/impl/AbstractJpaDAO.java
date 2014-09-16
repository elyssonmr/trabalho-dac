/*
 * QUADRANS TECNOLOGIA;
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: Aug 22, 2014<br>
 * <br>
 * Todos os direitos reservados.
 */

package fai.dao.jpa.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import fai.dao.IDAO;
import fai.domain.EntidadeDominio;


public abstract class AbstractJpaDAO<E extends EntidadeDominio> implements IDAO<E> {
	protected EntityManagerFactory emf;
	@PersistenceContext 
	protected EntityManager em;	
	
	
	//@Transactional para o spring
	@Transactional
	public void salvar(E entidade) {
		/*em.getTransaction().begin();		
		em.persist(entidade);			
		em.getTransaction().commit();	*/
		
		//Quando configurado pelo spring
		em.persist(entidade);
	}	
	@Override
	public void alterar(E entidade) {
		em.getTransaction().begin();		
		em.refresh(entidade);			
		em.getTransaction().commit();	
	}
	@Override
	public void excluir(E entidade) {
		entidade = (E) em.find(entidade.getClass(), entidade.getId());
        if (entidade != null) {
        	em.getTransaction().begin();
        	em.remove(entidade);
        	em.getTransaction().commit();
        }
	}
	
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}	
	
	
}
