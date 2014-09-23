package fai.negocio.imp;

import fai.domain.Emprestimo;
import fai.domain.EntidadeDominio;

public class ValidadorEmprestimo extends AbstractValidator {

	@Override
	public String validar(EntidadeDominio entidade) {
		Emprestimo p = (Emprestimo) entidade;

		double saldo = p.getCliente().getCredito();
		double salario = p.getCliente().getSalario();
		
		if(saldo <= 0){
			return "Saldo insuficiente";
		}
		
		if(p.getValor() > (salario * 3)){
			return "Renda insuficiente";
		}

		return null;
	}

}
