package fai.negocio.imp;

import fai.domain.EntidadeDominio;
import fai.negocio.ICommand;

public abstract class AbstractComplementador implements ICommand {

	@Override
	public String execute(EntidadeDominio entidade) {
		return complementar(entidade);
	}

	public abstract String complementar(EntidadeDominio entidade);

}
