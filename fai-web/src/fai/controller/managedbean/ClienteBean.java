package fai.controller.managedbean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fai.core.controle.IFachada;
import fai.domain.Cliente;
import fai.domain.Mensagem;
import fai.domain.Resultado;

@Controller
@SessionScoped
public class ClienteBean {
	
	@Autowired
	private IFachada<Cliente> fachada;
	
	Cliente cliente = new Cliente();
	
	String nome;
	String agencia;
	String conta;
	String cpf;
	Double credito;
	Double salario;
	String senha;
	List<Cliente> clientes;
	

	private double valor;
	
	public String salvarCliente(){
		cliente.setNome(nome);
		cliente.setAgencia(agencia);
		cliente.setConta(conta);
		cliente.setCpf(cpf);
		cliente.setCredito(credito);
		cliente.setDtCadastro(new Date());
		cliente.setSalario(salario);
		cliente.setSenha(senha);
		
		Resultado<Cliente> resultado = fachada.salvar(cliente);
		
		if (resultado != null && resultado.getMensagens() != null) {
			for (Mensagem msg : resultado.getMensagens()) {
				fai.controller.util.Utils.addErrorMsg(msg.getMsg());
			}
		}
		return "Cliente.xhtml";
	}
	
	public void listarClientes(){
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getCredito() {
		return credito;
	}

	public void setCredito(Double credito) {
		this.credito = credito;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public IFachada<Cliente> getFachada() {
		return fachada;
	}

	public void setFachada(IFachada<Cliente> fachada) {
		this.fachada = fachada;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}

