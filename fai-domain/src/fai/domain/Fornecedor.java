package fai.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor extends EntidadeDominio {
	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String rzSocial;

	@ManyToMany(mappedBy = "fornecedores")
	private Set<Produto> produtos;

	@Enumerated(EnumType.STRING)
	private Pais pais;

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
