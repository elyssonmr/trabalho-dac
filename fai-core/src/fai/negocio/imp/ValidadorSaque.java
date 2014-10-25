package fai.negocio.imp;

import fai.domain.EntidadeDominio;
import fai.domain.Transacao;

public class ValidadorSaque extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Transacao p = (Transacao) entidade;
		if(p.getTipo() == 1){
			p.getCliente().setCredito(p.getCliente().getCredito() + p.getValor());
			return null;
		} else {
			double saldo = p.getCliente().getCredito();
			if(saldo <= 0 || saldo < p.getValor()){
				return "Saldo insuficiente";
			}
			p.getCliente().setCredito(p.getCliente().getCredito() - p.getValor());
		}

		return null;
	}
}
