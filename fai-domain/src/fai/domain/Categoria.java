package fai.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity
@Table(name="TB_Categoria")
public class Categoria extends EntidadeDominio implements Serializable {

	@Column(name="description", length=30, nullable = false)
	private String descricao;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="categoria", 
			cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Produto> produtos;
	
	public Categoria() {
		super();
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
   
}
