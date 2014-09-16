package fai.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.DETACH;

/**
 * Entity implementation class for Entity: Produto
 *
 */
@Entity
@Table(name="TB_Produto")
public class Produto extends EntidadeDominio {
		
	@Column(name="description", length=30, nullable = false)
	private String descricao;
	private Double valor;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy="produto", 
			cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Modelo> modelos;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="cat_id")
	private Categoria categoria;
	
	@ManyToMany(cascade={ PERSIST, MERGE, REMOVE, DETACH })
	@JoinTable(name="TB_Produto_Fornecedor", joinColumns={
			@JoinColumn(name="prd_id")}, inverseJoinColumns={
			@JoinColumn(name="frd_id")
	})
	private Set<Fornecedor> fornecedores;
			
	//Métodos getters e setters
	
	public Produto() {
		super();
	}   
	
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(Set<Modelo> modelos) {
		for(Modelo m: modelos)
			m.setProduto(this);
		this.modelos = modelos;
	}

	public Set<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Set<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	
   
}
