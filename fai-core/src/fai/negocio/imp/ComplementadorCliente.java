package fai.negocio.imp;

import fai.domain.Cliente;
import fai.domain.EntidadeDominio;

public class ComplementadorCliente extends AbstractComplementador {

	@Override
	public String complementar(EntidadeDominio entidade) {
		Cliente cli =  (Cliente) entidade;
		
		ComplementadorDataCadastro c = new ComplementadorDataCadastro();
		c.execute(entidade);
		c.execute(cli.getEndereco());
		
		return null;
	}

}
