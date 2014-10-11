package fai.negocio.imp;

import fai.domain.Cliente;
import fai.domain.EntidadeDominio;

public class ValidadorConta extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;

		if (cliente.getConta() == null || cliente.getConta().trim().isEmpty()) {
			return "Conta é obrigatório!";
		}
		return null;
	}
}
