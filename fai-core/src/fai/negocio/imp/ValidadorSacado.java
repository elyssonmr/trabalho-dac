package fai.negocio.imp;

import fai.domain.EntidadeDominio;
import fai.domain.Pagamento;

public class ValidadorSacado extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Pagamento cliente = (Pagamento) entidade;
		if (cliente.getSacado() == null) {
			return "Sacado é obrigatório!";
		}
		return null;
	}
}
