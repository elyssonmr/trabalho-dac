
package fai.controle.impl;

import java.util.List;
import java.util.Map;

import fai.core.controle.IFachada;
import fai.dao.IDAO;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;



public class Fachada<F extends EntidadeDominio> implements IFachada<F> {
	private Map<String, IDAO> daos;

	
	@Override
	public Resultado<F> salvar(F entidade) {
		IDAO<F> dao = daos.get(entidade.getClass().getName());
		dao.salvar(entidade);
		return null;
	}

	
	@Override
	public Resultado<F> alterar(F entidade) {
		IDAO<F> dao = daos.get(entidade.getClass().getName());
		dao.alterar(entidade);
		return null;
	}

	
	@Override
	public Resultado<F> consultar(F entidade) {
		
		IDAO<F> dao = daos.get(entidade.getClass().getName());
        Resultado<F> r = null;
        List<F> entidades = dao.consultar(entidade);
        if( entidades != null){
        	r = new Resultado<F>();
        	r.setEntidades(entidades);        	
        }
        return r;
	}

	@Override
	public Resultado<F> excluir(F entidade) {
		return null;

	}


	public void setDaos(Map<String, IDAO> daos) {
		this.daos = daos;
	}

	
	
}
