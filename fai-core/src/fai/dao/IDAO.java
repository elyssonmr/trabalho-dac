
package fai.dao;

import java.util.List;

import fai.domain.EntidadeDominio;



public interface IDAO<E extends EntidadeDominio> {

	public void salvar(E entidade);
	public void alterar(E entidade);
	public List<E> consultar(E entidade);
	public void excluir(E entidade);
	
}
