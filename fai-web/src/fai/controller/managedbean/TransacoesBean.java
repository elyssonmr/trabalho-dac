package fai.controller.managedbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fai.controller.util.Utils;
import fai.core.controle.IFachada;
import fai.domain.Cliente;
import fai.domain.Mensagem;
import fai.domain.Resultado;
import fai.domain.Transacao;

@Controller
@Scope("")
public class TransacoesBean {

	private List<Transacao> transacoes;
	
	@Autowired
	private IFachada<Transacao> fachada;
	
	private Cliente cliente;
		
	public void carregarTransacoes(Cliente c) {
		if(c.getId() != 1){
			String nome = c.getNome();
			c.setNome(null);
			cliente = c;
			
			Transacao t = new Transacao();
			t.setCliente(c);
			transacoes = fachada.consultar(t).getEntidades();
			cliente.setNome(nome);
		} else {
			transacoes = fachada.consultar(new Transacao()).getEntidades();
		}
	}
	
	
	public void deletar(Long id) {
		Transacao pag = new Transacao();
		pag.setId(id);
		Resultado<Transacao> result = fachada.excluir(pag);
		
		carregarTransacoes(cliente);
		
		if(result.getMensagens() != null) {
			for(Mensagem msg : result.getMensagens()) {
				Utils.addErrorMsg(msg.getMsg());
			}
		}		
	}


	public List<Transacao> getTransacoes() {
		return transacoes;
	}


	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
