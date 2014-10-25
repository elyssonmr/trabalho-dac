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
import fai.domain.Transacao;

@Controller
@SessionScoped
public class TransacaoBean {

	@Autowired
	private IFachada<Transacao> fachada;
	
	@Autowired
	private IFachada<Cliente> fachadaCliente;
	
	@Autowired
	private IFachada<Transacao> fachadaTransacao;

	Transacao transacao = new Transacao();
	
	List<Cliente> clientes;
	List<Transacao> transacoes;

	int operacao;

	private double valor;
	
	public void setCliente(Long id){
		Cliente c = new Cliente();
		c.setId(id);
		clientes = fachadaCliente.consultar(c).getEntidades();
	}
	
	public void setTransacao(Long id){
		Transacao e = new Transacao();
		e.setId(id);
		transacoes = fachadaTransacao.consultar(e).getEntidades();
	}

	public String criarSaque(){
		transacao.setTipo(0);
		transacao.setCliente(clientes.get(0));
		
		if(criarTransacao(transacao))
			return "listaClientes.xhtml";
		else
			return "addSaque.xhtml";
	}
	
	public String criarDeposito(){
		transacao.setTipo(1);
		transacao.setCliente(clientes.get(0));
		
		if(criarTransacao(transacao))
			return "listaClientes.xhtml";
		else
			return "addDeposito.xhtml";
	}
	
	private boolean criarTransacao(Transacao transacao2) {
		transacao.setValor(valor);
		transacao.setDtCadastro(new Date());
		
		Resultado<Transacao> resultado = fachada.alterar(transacao);
		
		if (resultado != null && resultado.getMensagens() != null) {
			for (Mensagem msg : resultado.getMensagens()) {
				fai.controller.util.Utils.addErrorMsg(msg.getMsg());
			}
			return false;
		}
		return true;
	}

	public String alterarTransacao(){
		transacao = transacoes.get(0);
		transacao.setValor(valor);
		
		Resultado<Transacao> resultado = fachada.alterar(transacao);
		
		if (resultado != null && resultado.getMensagens() != null) {
			for (Mensagem msg : resultado.getMensagens()) {
				fai.controller.util.Utils.addErrorMsg(msg.getMsg());
			}
			return "AddDeposito.xhtml";
		}
		return "listaClientes.xhtml";
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public IFachada<Transacao> getFachada() {
		return fachada;
	}

	public void setFachada(IFachada<Transacao> fachada) {
		this.fachada = fachada;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
	

}
