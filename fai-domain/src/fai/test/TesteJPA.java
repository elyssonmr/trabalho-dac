
package fai.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fai.domain.Categoria;
import fai.domain.Modelo;
import fai.domain.Fornecedor;
import fai.domain.Pais;
import fai.domain.Produto;

public class TesteJPA {	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fai-domain");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Categoria c = em.find(Categoria.class, 1);		
		
		Modelo e1 = new Modelo("XX23");
	//	Modelo e2 = new Modelo("XX23");
		
		Set<Modelo> modelos = new HashSet<Modelo>();
		modelos.add(e1);
		//modelos.add(e2);
		
		Fornecedor f1 = new Fornecedor("Sony do Brasil", Pais.BRASIL);
		Fornecedor f2 = new Fornecedor("Philips do Mexico", Pais.BRASIL);
		
		Set<Fornecedor> fornecedores = new HashSet<Fornecedor>();
		fornecedores.add(f1);
		fornecedores.add(f2);
		
		Produto p = new Produto();
		p.setDescricao("Blue&Ray");
		p.setValor(new Double(100));
		
		p.setCategoria(c);
		
		p.setModelos(modelos);
		p.setFornecedores(fornecedores);
		
		em.persist(p);
	
		em.getTransaction().commit();
		System.out.println(":::::::::::" + p.getId()+":::::::::::::");
		em.close();
		emf.close();
	}
}
