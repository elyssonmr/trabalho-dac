package fai.controller.managedbean;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fai.core.controle.IFachada;
import fai.domain.Cliente;
import fai.domain.Mensagem;
import fai.domain.Resultado;

@Controller
@Scope("session")
public class LoginBean {

	@Autowired
	private IFachada<Cliente> fachada;

	private String agencia;
	private String conta;
	private String senha;
	private Cliente atualCliente;

	public LoginBean() {
	}

	public String acessar() {
		Cliente cliente = new Cliente();
		cliente.setAgencia(agencia);
		cliente.setConta(conta);
		cliente.setSenha(senha);

		Resultado<Cliente> resp = fachada.consultar(cliente);

		if (resp.getMensagens() == null) {
			if (resp.getEntidades().isEmpty()) {
				fai.controller.util.Utils.addErrorMsg("Login Inválido");
				return "login.xhtml";
			}
			this.atualCliente = resp.getEntidades().get(0);
			reset();
			return "listaPagamentos.xhtml?faces-redirect=true";
		} else {
			for (Mensagem msg : resp.getMensagens()) {
				fai.controller.util.Utils.addErrorMsg(msg.getMsg());
			}
			return "login.xhtml";
		}
	}

	private void reset() {
		this.agencia = "";
		this.conta = "";
		this.senha = "";
	}

	public String sair() {
		this.atualCliente = null;
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "index.xhtml?faces-redirect=true";
	}

	public boolean isLogged() {
		return atualCliente != null;
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

	public Cliente getAtualCliente() {
		return atualCliente;
	}
}
