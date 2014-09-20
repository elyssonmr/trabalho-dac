package fai.negocio.imp;

import fai.domain.EntidadeDominio;
import fai.negocio.ICommand;

public abstract class AbstractValidator implements ICommand {

	@Override
	public String execute(EntidadeDominio entidade) {
		return validar(entidade);
	}

	public abstract String validar(EntidadeDominio entidade);
}
