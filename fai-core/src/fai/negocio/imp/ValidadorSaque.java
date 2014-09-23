package fai.negocio.imp;

import fai.domain.EntidadeDominio;
import fai.domain.Transacao;

public class ValidadorSaque extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Transacao p = (Transacao) entidade;

		double saldo = p.getCliente().getCredito();
		
		if(saldo <= 0 || saldo < p.getValor()){
			return "Saldo insuficiente";
		}

		return null;
	}
}
