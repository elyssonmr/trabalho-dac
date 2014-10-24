package fai.controller.managedbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fai.controller.util.Utils;
import fai.core.controle.IFachada;
import fai.domain.Cliente;
import fai.domain.Emprestimo;
import fai.domain.Mensagem;
import fai.domain.Resultado;

@Controller
@Scope("")
public class EmprestimosBean {

	private List<Emprestimo> emprestimos;
	
	@Autowired
	private IFachada<Emprestimo> fachada;
	
	private Cliente cliente;
		
	public void carregarEmprestimos(Cliente c) {
		if(c.getId() != 1){
			String nome = c.getNome();
			c.setNome(null);
			cliente = c;
			
			Emprestimo e = new Emprestimo();
			e.setCliente(c);
			emprestimos = fachada.consultar(e).getEntidades();
			cliente.setNome(nome);
		} else {
			emprestimos = fachada.consultar(new Emprestimo()).getEntidades();
		}
	}
	
	
	public void deletar(Long id) {
		Emprestimo pag = new Emprestimo();
		pag.setId(id);
		Resultado<Emprestimo> result = fachada.excluir(pag);
		
		carregarEmprestimos(cliente);
		
		if(result.getMensagens() != null) {
			for(Mensagem msg : result.getMensagens()) {
				Utils.addErrorMsg(msg.getMsg());
			}
		}		
	}


	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}


	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}
