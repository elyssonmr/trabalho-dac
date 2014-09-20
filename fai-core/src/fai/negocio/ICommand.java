package fai.negocio;

import fai.domain.EntidadeDominio;

public interface ICommand {
	
	public String execute(EntidadeDominio entidade);

}
