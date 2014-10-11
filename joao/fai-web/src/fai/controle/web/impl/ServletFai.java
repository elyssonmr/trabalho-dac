package fai.controle.web.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fai.controle.web.command.ICommandFrontController;
import fai.controle.web.vh.FactoryMethodVH;
import fai.controle.web.vh.IViewHelperWeb;
import fai.domain.EntidadeDominio;

public class ServletFai extends HttpServlet {

	@Autowired
	private Map<String, ICommandFrontController> commandsFC;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void service(HttpServletRequest arg0, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(arg0, response);
		// carregarDominios(getServletContext());
		// response.sendRedirect("FormCliente.jsp");
	}

	/*
	 * public void carregarDominios(ServletContext context){ if(tipos == null){
	 * Resultado r = fachada.consultar(new TipoCliente()); tipos =
	 * r.getEntidades(); context.setAttribute("tipos", tipos); } }
	 */

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletFai() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String command = request.getParameter("command");
		
		
		IViewHelperWeb vh = FactoryMethodVH.create(uri); 

		EntidadeDominio entidade = vh.getEntidade(request);

		ICommandFrontController<EntidadeDominio> cfc = getCommand(command);
		
		cfc.execute(entidade);

		/*
		 * vh.setEntidade(entidade); // vh.setView(resultado, request,
		 * response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}
	
private ICommandFrontController<EntidadeDominio> getCommand(String command){
		
		return commandsFC.get("commandFrontController"+command);
		
	}

	public void setCommandsFC(Map<String, ICommandFrontController> commandsFC) {
		this.commandsFC = commandsFC;
	}

}
