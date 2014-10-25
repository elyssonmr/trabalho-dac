package fai.negocio.imp;

import fai.domain.EntidadeDominio;
import fai.domain.Pessoa;

public class ValidadorCPF extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Pessoa p = (Pessoa) entidade;
		
		String cpf = p.getCpf();
		if(cpf != null && !cpf.trim().equals("")) {
			if(cpf.length() != 11) {
				return "CPF deve ter 11 digitos";
			}
		} else {
			return "CPF deve estar preenchido";
		}
		
		return null;
	}

}
