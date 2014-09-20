package fai.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria extends EntidadeDominio {

	private static final long serialVersionUID = 1L;
	@Column(name = "descricao", length = 50, nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "categoria", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private List<Produto> produtos;

	public String getDescricao() {
		return descricao;
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
