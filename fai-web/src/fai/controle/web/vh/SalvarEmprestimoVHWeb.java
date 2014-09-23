package fai.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fai.domain.Emprestimo;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;

public class SalvarEmprestimoVHWeb<C extends Emprestimo> implements IViewHelperWeb<C>  {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request)
			throws ServletException, IOException {
		double valor = Double.parseDouble(request.getParameter("valor"));
		emprestimo.setValor(valor);
		
		return emprestimo;
	}

	@Override
	public void setView(Resultado rs, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(rs == null){
			request.setAttribute("emp", emprestimo);
			request.getRequestDispatcher("EmprestimoSucesso.jsp").
				forward(request, response);
		}
	}
	
	private Emprestimo emprestimo;

	public void setemprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}


	
	@Override
	public void setEntidade(C entidade) {
		this.emprestimo = entidade;
		
	}

}
