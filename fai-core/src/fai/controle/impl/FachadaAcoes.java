package fai.controle.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import fai.core.controle.IFachadaAcoes;
import fai.dao.IDAO;
import fai.domain.Cliente;
import fai.domain.Mensagem;
import fai.domain.Resultado;
import fai.negocio.ICommand;

public class FachadaAcoes implements IFachadaAcoes {
	@Autowired
	IDAO<Cliente> clienteDAO;

	private Map<String, List<ICommand>> acoesCmds;

	@Override
	public Resultado<Cliente> validadeLogin(Cliente cliente) {
		List<ICommand> cmds = acoesCmds.get(cliente.getClass().getName());
		List<Mensagem> msgs = new ArrayList<Mensagem>();

		for (ICommand cmd : cmds) {
			String msg = cmd.execute(cliente);
			if (msg != null) {
				msgs.add(new Mensagem(msg));
			}
		}

		if (msgs.size() == 0) {
			List<Cliente> items = clienteDAO.consultar(cliente);
			
			return new Resultado<Cliente>(null, items);
		} else {
			return new Resultado<Cliente>(msgs);
		}
	}

	public void setAcoesCmds(Map<String, List<ICommand>> acoesCmds) {
		this.acoesCmds = acoesCmds;
	}
}
