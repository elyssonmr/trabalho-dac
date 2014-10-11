package fai.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa extends EntidadeDominio {
	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	protected String nome;

	@Column(length = 11, nullable = false)
	protected String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
