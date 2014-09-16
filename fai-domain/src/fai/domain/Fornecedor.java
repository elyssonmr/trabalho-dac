package fai.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Fornecedor
 *
 */
@Entity
@Table(name="TB_Fornecedor")
public class Fornecedor extends EntidadeDominio {

	@Column(name="rzSocial", length=30, nullable = false)
	private String rzSocial;
	
	@ManyToMany(mappedBy="fornecedores")
	private Set<Produto> produtos;
	
	@Enumerated(EnumType.STRING)
	private Pais pais;
	
	public Fornecedor(String rzSocial, Pais pais) {
		super();
		this.rzSocial = rzSocial;
		this.pais = pais;
	}   
	
	public Fornecedor() {
		super();		
	}   
	public String getRzSocial() {
		return this.rzSocial;
	}

	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
   
	
}
