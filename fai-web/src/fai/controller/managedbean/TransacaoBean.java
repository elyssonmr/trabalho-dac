package fai.controller.managedbean;

import java.util.Date;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fai.core.controle.IFachada;
import fai.domain.Cliente;
import fai.domain.Emprestimo;
import fai.domain.Mensagem;
import fai.domain.Resultado;
import fai.domain.Transacao;

@Controller
@SessionScoped
public class TransacaoBean {

	@Autowired
	private IFachada<Transacao> fachada;

	Transacao transacao = new Transacao();

	@Autowired
	Cliente clienteEmprestimo;

	int operacao;

	private double valor;

	public String criarTransacao() {
		transacao.setValor(valor);
		transacao.setDtCadastro(new Date());
		transacao.setCliente(clienteEmprestimo);

//		if (operacao.equals("Saque") || operacao.equals("Depósito")) {
//			transacao.setTipo(operacao.equals("Saque") ? 0 : 1);
			Resultado<Transacao> resultado = fachada.salvar(transacao);

			if (resultado != null && resultado.getMensagens() != null) {
				for (Mensagem msg : resultado.getMensagens()) {
					fai.controller.util.Utils.addErrorMsg(msg.getMsg());
				}
			}
			return "Transacao.xhtml";
//		} else {
//			return "Extrato.xhtml";
//		}
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

	

}
