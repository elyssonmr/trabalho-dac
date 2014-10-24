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

@Controller
@Scope("")
public class ClientesBean {

	private List<Cliente> clientes;
	
	@Autowired
	private IFachada<Cliente> fachada;
		
	public void carregarClientes() {
		clientes = fachada.consultar(new Cliente()).getEntidades();
	}
	
	
	public void deletar(Long id) {
		Cliente pag = new Cliente();
		pag.setId(id);
		Resultado<Cliente> result = fachada.excluir(pag);
		
		carregarClientes();
		
		if(result.getMensagens() != null) {
			for(Mensagem msg : result.getMensagens()) {
				Utils.addErrorMsg(msg.getMsg());
			}
		}		
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
