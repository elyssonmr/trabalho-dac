
package fai.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fai.domain.EntidadeDominio;
import fai.domain.Resultado;
import fai.domain.TipoCliente;


public class SalvarTipoClienteVHWeb<T extends TipoCliente> implements IViewHelperWeb<T> {
	private TipoCliente tipo;
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request)
			throws ServletException, IOException {
		String descricao = request.getParameter("txtDescricao");
		
		tipo.setDescricao(descricao);	
	
		
		return tipo;
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

	
	@Override
	public void setEntidade(T entidade) {
		this.tipo = entidade;
		
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}




}
