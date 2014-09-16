package fai.dao.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import fai.domain.Categoria;
import fai.domain.EntidadeDominio;
import fai.domain.Produto;

public class ProdutoJpaDAO<P extends Produto> extends AbstractJpaDAO<P>{
	
	@Override
	public List<P> consultar(P entidade) {
		Produto p = (Produto)entidade;
		List<P> produtos;
		
		if(p.getId() != 0 && p.getCategoria() == null){		
			produtos = new ArrayList<P>();
			produtos.add((P) consultar(entidade.getId()));
			
		}else{
			produtos = consultar(p.getCategoria());
		}
				
		return produtos;
	}
	
	private Produto consultar(int id){
		Produto p = em.find(Produto.class, id);
		return p;
	}

	private List<P> consultar(Categoria c){
		Query con = em.createQuery("select c from Categoria c where c.id = :idCat");
		con.setParameter("idCat", c.getId());

		Categoria cat = (Categoria)con.getSingleResult();
		return (List<P>) cat.getProdutos();
	}
	
}
