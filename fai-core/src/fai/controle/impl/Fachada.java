package fai.controle.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import fai.core.controle.IFachada;
import fai.dao.IDAO;
import fai.domain.EntidadeDominio;
import fai.domain.Mensagem;
import fai.domain.Resultado;
import fai.negocio.ICommand;

@Component
public class Fachada<P extends EntidadeDominio> implements IFachada<P> {

	private Map<String, IDAO> daos;
	private Map<String, List<ICommand>> rns;

	public Fachada() {
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		String nomeClasse = entidade.getClass().getName();
		List<ICommand> cmds = rns.get(nomeClasse);
		List<Mensagem> msgs = new ArrayList<Mensagem>();

		for (ICommand cmd : cmds) {
			String msg = cmd.execute(entidade);

			if (msg != null) {
				msgs.add(new Mensagem(msg));
			}
		}

		if (msgs.size() == 0) {
			daos.get(entidade.getClass().getName()).salvar(entidade);
			return null;
		} else {
			return new Resultado(msgs);
		}

	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		String nomeClasse = entidade.getClass().getName();
		List<ICommand> cmds = rns.get(nomeClasse);
		List<Mensagem> msgs = new ArrayList<Mensagem>();

		for (ICommand cmd : cmds) {
			String msg = cmd.execute(entidade);

			if (msg != null) {
				msgs.add(new Mensagem(msg));
			}
		}

		if (msgs.size() == 0) {
			daos.get(entidade.getClass().getName()).alterar(entidade);
			return null;
		} else {
			return new Resultado(msgs);
		}
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		String nomeClasse = entidade.getClass().getName();
		List<P> entidades = daos.get(nomeClasse).consultar(entidade);
		Resultado<P> resultado = new Resultado<P>();
		resultado.setEntidades(entidades);
		return resultado;

	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		daos.get(entidade.getClass().getName()).excluir(entidade);
		return new Resultado();
	}

	public void setDaos(Map<String, IDAO> daos) {
		this.daos = daos;
	}

	public void setRns(Map<String, List<ICommand>> rns) {
		this.rns = rns;
	}
}
