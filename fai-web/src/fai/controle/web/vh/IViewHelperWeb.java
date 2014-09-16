
package fai.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fai.domain.EntidadeDominio;
import fai.domain.Resultado;



public interface IViewHelperWeb<E extends EntidadeDominio> {

	
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException;
	
	public void setView(Resultado rs, HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException;
	
	public void setEntidade(E entidade);
	
}
