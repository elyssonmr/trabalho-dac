package fai.controller.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import fai.core.controle.IFachadaDAO;
import fai.domain.Cliente;
import fai.domain.Mensagem;
import fai.domain.Resultado;

@ManagedBean
public class LoginBean {

	@Autowired
	private IFachadaDAO<Cliente> fachadaDAO;

	private String agencia;
	private String conta;
	private String senha;

	private List<Mensagem> erros;
	
	public LoginBean() {
		erros = new ArrayList<Mensagem>();
	}

	public String acessar() {
		Cliente cliente = new Cliente();
		cliente.setAgencia(agencia);
		cliente.setConta(conta);
		cliente.setSenha(senha);

		Resultado<Cliente> resp = fachadaDAO.consultar(cliente);

		if (resp.getMensagens() == null) {
			// colocar o cliente na sessão
			// retornar para a lista de pagamentos do Cliente
		} else {
			// retornar para a tela de login e exibir os erros
			this.erros = resp.getMensagens();
		}

		return "";
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

	public List<Mensagem> getErros() {
		return erros;
	}

	public void setErros(List<Mensagem> erros) {
		this.erros = erros;
	}

}
