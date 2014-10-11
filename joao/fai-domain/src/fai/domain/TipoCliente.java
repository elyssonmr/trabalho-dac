package fai.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipocliente")
public class TipoCliente extends EntidadeDominio {
	private static final long serialVersionUID = 1L;

	private String descricao;

	public TipoCliente() {
	}

	public TipoCliente(Long parseInt) {
		this.id = parseInt;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
