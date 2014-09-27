package fai.negocio.imp;

import fai.domain.EntidadeDominio;
import fai.domain.Pagamento;

public class ValidadorLinhaDigitavel extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Pagamento cliente = (Pagamento) entidade;

		if (cliente.getLinhaDigitavel() == null
				|| cliente.getLinhaDigitavel().trim().isEmpty()) {
			return "Linha Digitável é obrigatório!";
		}
		return null;
	}
}
