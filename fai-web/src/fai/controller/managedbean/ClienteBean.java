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
	
	@Autowired
	private IFachada<Cliente> fachadaCliente;
	
	Cliente cliente = new Cliente();
	
	private String nome;
	private String agencia;
	private String conta;
	private String cpf;
	private Double credito;
	private Double salario;
	private String senha;
	private List<Cliente> clientes;
	private double valor;
	
	public void resetCliente(){
		if(cliente != null){
			cliente = new Cliente();
		}
		nome = "";
		agencia = "";
		conta = "";
		cpf = "";
		credito = new Double(0);
		salario = new Double(0);
		senha = "";
	}
	
	public void setCliente(Long id){
		Cliente c = new Cliente();
		c.setId(id);
		clientes = fachadaCliente.consultar(c).getEntidades();
		
		c = clientes.get(0);
		nome = c.getNome();
		agencia = c.getAgencia();
		conta = c.getConta();
		cpf = c.getCpf();
		credito = c.getCredito();
		salario = c.getSalario();
		senha = c.getSenha();
	}
	
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
			return "addCliente.xhtml";
		}
		return "listaClientes.xhtml";
	}
	
	public String alterarCliente(){
		cliente.setNome(nome);
		cliente.setAgencia(agencia);
		cliente.setConta(conta);
		cliente.setCpf(cpf);
		cliente.setCredito(credito);
		cliente.setDtCadastro(new Date());
		cliente.setSalario(salario);
		cliente.setSenha(senha);
		cliente.setId(clientes.get(0).getId());
		
		Resultado<Cliente> resultado = fachada.alterar(cliente);
		
		if (resultado != null && resultado.getMensagens() != null) {
			for (Mensagem msg : resultado.getMensagens()) {
				fai.controller.util.Utils.addErrorMsg(msg.getMsg());
			}
			return "addCliente.xhtml";
		}
		return "listaClientes.xhtml";
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

