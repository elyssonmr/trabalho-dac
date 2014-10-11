
package fai.dao.jpa.impl;

import java.util.List;

import javax.persistence.Query;

import fai.domain.Categoria;


public class CategoriaJpaDAO<C extends Categoria> extends AbstractJpaDAO<C> {
	
	@Override
	public List<C> consultar(C entidade) {
		Categoria c = entidade;
		List<C> categorias=null;
		if(c.getProdutos() == null){
			Query con = em.createQuery("select c from Categoria c where c.produtos is empty");
				categorias= con.getResultList();
		}
		return categorias;
	}
}
