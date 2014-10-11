package fai.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa {
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "end_fk")
	private Endereco endereco;

	@Column(nullable = false)
	private double credito;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private TipoCliente tipoCliente;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE,
			CascadeType.DETACH })
	private Set<Emprestimo> emprestimos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE,
			CascadeType.DETACH })
	private Set<Transacao> transacoes;

	@Column(length = 10, nullable = false)
	private String agencia;

	@Column(length = 10, nullable = false)
	private String conta;

	@Column(length = 15, nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private double salario;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Set<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(Set<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public Set<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(Set<Transacao> transacoes) {
		this.transacoes = transacoes;
	}	
	
	
}
