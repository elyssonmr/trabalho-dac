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

	@Column(nullable = false)
	private boolean pago;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {
			CascadeType.PERSIST, CascadeType.REFRESH })
	private Cliente sacado;

	@Column(nullable = false)
	private float valor;

	public Pagamento() {
		this.pago = false;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
