
package fai.controle.web.command;

import fai.domain.EntidadeDominio;


public interface ICommandFrontController<E extends EntidadeDominio> {

	public void execute(E entidade);
	
}
