
package fai.controle.web.command.impl;

import fai.controle.web.command.ICommandFrontController;
import fai.core.controle.IFachadaDAO;
import fai.domain.EntidadeDominio;



public class CommandFrontControllerSalvar<E> implements ICommandFrontController<EntidadeDominio> {
	
	private IFachadaDAO fachada;
	
	@Override
	public void execute(EntidadeDominio entidade) {
		fachada.salvar(entidade);
		
	}

	public void setFachada(IFachadaDAO fachada) {
		this.fachada = fachada;
	}

	
}
