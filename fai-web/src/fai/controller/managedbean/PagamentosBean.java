package fai.controller.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fai.controller.util.Utils;
import fai.core.controle.IFachada;
import fai.domain.Mensagem;
import fai.domain.Pagamento;
import fai.domain.Resultado;

@Controller
@RequestScoped
public class PagamentosBean {

	private List<Pagamento> pagamentos;
	
	@Autowired
	private IFachada<Pagamento> fachada;
		
	public void carregarPagamentos() {
		pagamentos = fachada.consultar(new Pagamento()).getEntidades();
	}
	
	
	public void deletar(Long id) {
		Pagamento pag = new Pagamento();
		pag.setId(id);
		Resultado<Pagamento> result = fachada.excluir(pag);
		
		carregarPagamentos();
		
		if(result.getMensagens() != null) {
			for(Mensagem msg : result.getMensagens()) {
				Utils.addErrorMsg(msg.getMsg());
			}
		}		
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
}
