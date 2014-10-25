package fai.negocio.imp;

import fai.domain.Cliente;
import fai.domain.EntidadeDominio;

public class ValidadorAgencia extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		if (cliente.getAgencia() == null
				|| cliente.getAgencia().trim().isEmpty()) {
			return "Agencia é obrigatório!";
		}
		return null;
	}
}
