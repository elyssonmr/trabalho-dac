package fai.controller.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fai.controller.util.Utils;
import fai.core.controle.IFachada;
import fai.domain.Cliente;
import fai.domain.Mensagem;
import fai.domain.Pagamento;
import fai.domain.Resultado;

@Controller
@ViewScoped
public class PagamentoBean {

	private String linhaDigitavel;
	private Double valor;
	private Long idSacado;
	private List<Cliente> sacados;

	@Autowired
	private IFachada fachada;

	public void carregarSacados() {
		sacados = fachada.consultar(new Cliente()).getEntidades();
	}

	public void salvar() {
		Pagamento pagamento = new Pagamento();
		pagamento.setLinhaDigitavel(linhaDigitavel);
		Cliente cli = new Cliente();
		cli.setId(idSacado);
		pagamento.setSacado((Cliente) fachada.consultar(cli).getEntidades()
				.get(0));

		Resultado<Pagamento> result = fachada.salvar(pagamento);

		if (result.getMensagens() == null) {
			this.reset();
			Utils.addErrorMsg("Pagamento Efetuado!");
		} else {
			for (Mensagem msg : result.getMensagens()) {
				Utils.addErrorMsg(msg.getMsg());
			}
		}
	}

	private void reset() {
		this.linhaDigitavel = "";
		this.idSacado = 0L;
		this.valor = 0.0D;
	}

	public String getLinhaDigitavel() {
		return linhaDigitavel;
	}

	public void setLinhaDigitavel(String linhaDigitavel) {
		this.linhaDigitavel = linhaDigitavel;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
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
