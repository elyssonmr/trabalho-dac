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

@Controller
@SessionScoped
public class EmprestimoBean {
	
	@Autowired
	private IFachada<Emprestimo> fachada;
	
	Emprestimo emprestimo = new Emprestimo();
	
	@Autowired
	Cliente clienteEmprestimo;

	private double valor;
	
	public String criarEmprestimo(){
		emprestimo.setValor(valor);
		emprestimo.setDtCadastro(new Date());
		emprestimo.setCliente(clienteEmprestimo);
		
		Resultado<Emprestimo> resultado = fachada.salvar(emprestimo);
		
		if (resultado != null && resultado.getMensagens() != null) {
			for (Mensagem msg : resultado.getMensagens()) {
				fai.controller.util.Utils.addErrorMsg(msg.getMsg());
			}
		}
		return "Emprestimo.xhtml";
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}

