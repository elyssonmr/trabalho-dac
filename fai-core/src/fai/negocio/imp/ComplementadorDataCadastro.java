package fai.negocio.imp;

import java.util.Date;

import fai.domain.EntidadeDominio;

public class ComplementadorDataCadastro extends AbstractComplementador {

	@Override
	public String complementar(EntidadeDominio entidade) {
		entidade.setDtCadastro(new Date());
		return null;
	}

}
