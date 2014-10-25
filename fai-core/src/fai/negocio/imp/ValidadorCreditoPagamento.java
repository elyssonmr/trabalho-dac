package fai.negocio.imp;

import fai.domain.EntidadeDominio;
import fai.domain.Pagamento;

public class ValidadorCreditoPagamento extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Pagamento pagamento = (Pagamento) entidade;
		
		if(pagamento.getValor() == null) {
			return "Valor é um campo obrigatório";
		}
		
		if (pagamento.getValor() >= pagamento.getSacado().getCredito()) {
			return "Cliente não possui saldo duficiente!";
		} else {
			pagamento.getSacado().setCredito(pagamento.getSacado().getCredito() - pagamento.getValor());
		}
		return null;
	}
}
