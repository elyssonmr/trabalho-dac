package fai.negocio.imp;

import fai.domain.Cliente;
import fai.domain.EntidadeDominio;

public class ValidadorSenha extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		if (cliente.getSenha() == null || cliente.getSenha().trim().isEmpty()) {
			return "Senha é obrigatório!";
		}
		return null;
	}
}
