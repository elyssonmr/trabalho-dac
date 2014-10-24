package fai.controller.managedbean;

import java.util.List;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fai.controller.util.Utils;
import fai.core.controle.IFachada;
import fai.domain.Cliente;
import fai.domain.Mensagem;
import fai.domain.Pagamento;
import fai.domain.Resultado;

@Controller
@Scope("request")
public class PagamentoBean {

	private String linhaDigitavel;
	private Float valor;
	private Long idSacado;
	private List<Cliente> sacados;

	@Autowired
	private IFachada fachada;
	
	public void carregarSacados() {
		sacados = fachada.consultar(new Cliente()).getEntidades();
	}

	public String salvar() {
		if(idSacado == 0) {
			return "addPagamento.xhtml";
		}
		Pagamento pagamento = new Pagamento();
		pagamento.setLinhaDigitavel(linhaDigitavel);
		pagamento.setValor(valor);
		Cliente cli = new Cliente();
		cli.setId(idSacado);
		pagamento.setSacado((Cliente) fachada.consultar(cli).getEntidades()
				.get(0));

		Resultado<Pagamento> result = fachada.salvar(pagamento);

		if (result == null) {
			this.reset();
			Utils.addErrorMsg("Pagamento Efetuado!");
			return "listaPagamentos.xhtml?faces-redirect=true";
		} else {
			for (Mensagem msg : result.getMensagens()) {
				Utils.addErrorMsg(msg.getMsg());
			}
		}
		return "addPagamento.xhtml";
	}

	private void reset() {
		this.linhaDigitavel = "";
		this.idSacado = 0L;
		this.valor = 0.0F;
	}

	public String getLinhaDigitavel() {
		return linhaDigitavel;
	}

	public void setLinhaDigitavel(String linhaDigitavel) {
		this.linhaDigitavel = linhaDigitavel;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Long getIdSacado() {
		return idSacado;
	}

	public void setIdSacado(Long idSacado) {
		this.idSacado = idSacado;
	}

	public List<Cliente> getSacados() {
		return sacados;
	}

	public void setSacados(List<Cliente> sacados) {
		this.sacados = sacados;
	}
}
