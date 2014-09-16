
package fai.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fai.domain.Categoria;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;


public class SalvarCategoriaVHWeb<C extends Categoria> implements IViewHelperWeb<C> {
	private Categoria categoria;
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request)
			throws ServletException, IOException {
		String descricao = request.getParameter("txtDescricao");
		
		categoria.setDescricao(descricao);	
	
		
		return categoria;
	}

	/** 
	 * TODO Descrição do Método
	 * @param rs
	 * @param rq
	 * @param rp
	 * @throws ServletException
	 * @throws IOException
	 * @see fai.controle.web.vh.IViewHelperWeb#setView(fai.domain.Resultado, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void setView(Resultado rs, HttpServletRequest rq, HttpServletResponse rp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * TODO Descrição do Método
	 * @param entidade
	 * @see fai.controle.web.vh.IViewHelperWeb#setEntidade(fai.domain.EntidadeDominio)
	 */
	@Override
	public void setEntidade(C entidade) {
		this.categoria = entidade;
		
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}




}
