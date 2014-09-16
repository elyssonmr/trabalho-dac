
package fai.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fai.domain.Cliente;
import fai.domain.Endereco;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;
import fai.domain.TipoCliente;




public class SalvarClienteVHWeb<C extends Cliente> implements IViewHelperWeb<C> {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request)
			throws ServletException, IOException {
		String nome = request.getParameter("txtNome");
		String cpf = request.getParameter("txtCpf");
		String logradouro = request.getParameter("txtLogradouro");
		String cidade = request.getParameter("txtCidade");
		String estado = request.getParameter("txtEstado");
		String cep = request.getParameter("txtCep");
		String tpCliente = request.getParameter("txtTipo");		
		cliente.setNome(nome);
		cliente.setCpf(cpf);		
		Endereco end = new Endereco();
		end.setCep(Integer.parseInt(cep));
		end.setLogradouro(logradouro);
		end.setCidade(cidade);
		end.setEstado(estado);
		
		cliente.setEndereco(end);		
		TipoCliente t = new TipoCliente(Integer.parseInt(tpCliente));
		cliente.setTipoCliente(t);	
		
		return cliente;
	}

	
	@Override
	public void setView(Resultado rs, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(rs == null){
			request.setAttribute("cli", cliente);
			request.getRequestDispatcher("FuncionarioCliente.jsp").
				forward(request, response);
		}
		
	}
	
	private Cliente cliente;

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	
	@Override
	public void setEntidade(C entidade) {
		this.cliente = entidade;
		
	}

	
}
