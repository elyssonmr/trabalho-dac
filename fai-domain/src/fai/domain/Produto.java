package fai.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto extends EntidadeDominio {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private Double valor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE,
			CascadeType.DETACH })
	private Set<Modelo> modelos;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "cat_id")
	private Categoria categoria;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE, CascadeType.DETACH })
	@JoinTable(name = "tb_produtos_fornecedor", joinColumns = { @JoinColumn(name = "prd_id") }, inverseJoinColumns = { @JoinColumn(name = "frd_id") })
	private Set<Fornecedor> fornecedores;

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

	public Set<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Set<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Set<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(Set<Modelo> modelos) {

		for (Modelo m : modelos) {
			m.setProduto(this);
		}
		this.modelos = modelos;
	}
}
