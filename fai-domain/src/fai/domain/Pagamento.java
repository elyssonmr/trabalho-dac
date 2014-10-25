package fai.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento extends EntidadeDominio {

	private static final long serialVersionUID = 1L;

	@Column(length = 30, nullable = false)
	private String linhaDigitavel;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade={ CascadeType.MERGE })
	private Cliente sacado;

	@Column(nullable = false)
	private Float valor;

	public Cliente getSacado() {
		return sacado;
	}

	public void setSacado(Cliente sacado) {
		this.sacado = sacado;
	}

	public String getLinhaDigitavel() {
		return linhaDigitavel;
	}

	public void setLinhaDigitavel(String linhaDigitavel) {
		this.linhaDigitavel = linhaDigitavel;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}
