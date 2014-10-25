package fai.controller.managedbean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Autowired
	private IFachada<Cliente> fachadaCliente;
	
	@Autowired
	private IFachada<Emprestimo> fachadaEmprestimo;
	
	Emprestimo emprestimo = new Emprestimo();
	
	List<Cliente> clientes;
	List<Emprestimo> emprestimos;

	private double valor;
	
	public void setCliente(Long id){
		Cliente c = new Cliente();
		c.setId(id);
		clientes = fachadaCliente.consultar(c).getEntidades();
	}
	
	public void setEmprestimo(Long id){
		Emprestimo e = new Emprestimo();
		e.setId(id);
		emprestimos = fachadaEmprestimo.consultar(e).getEntidades();
	}
	
	public String criarEmprestimo(){
		emprestimo.setValor(valor);
		emprestimo.setDtCadastro(new Date());
		emprestimo.setCliente(clientes.get(0));
		emprestimo.getCliente().setCredito(emprestimo.getCliente().getCredito() + valor);
		
		Resultado<Emprestimo> resultado = fachada.alterar(emprestimo);
		
		if (resultado != null && resultado.getMensagens() != null) {
			for (Mensagem msg : resultado.getMensagens()) {
				fai.controller.util.Utils.addErrorMsg(msg.getMsg());
			}
			return "addEmprestimo.xhtml";
		}
		return "listaClientes.xhtml";
	}
	
	public String alterarEmprestimo(){
		emprestimo = emprestimos.get(0);
		emprestimo.setValor(valor);
		emprestimo.getCliente().setCredito(emprestimo.getCliente().getCredito() + valor);
		
		Resultado<Emprestimo> resultado = fachada.alterar(emprestimo);
		
		if (resultado != null && resultado.getMensagens() != null) {
			for (Mensagem msg : resultado.getMensagens()) {
				fai.controller.util.Utils.addErrorMsg(msg.getMsg());
			}
			return "addEmprestimo.xhtml";
		}
		return "listaClientes.xhtml";
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
	
}

