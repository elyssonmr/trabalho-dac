package fai.negocio.imp;

import fai.domain.Cliente;
import fai.domain.EntidadeDominio;
import fai.domain.Pagamento;

public class ComplementadorDebitoPagamento extends AbstractComplementador {

	@Override
	public String complementar(EntidadeDominio entidade) {

		Pagamento pagamento = (Pagamento) entidade;
		if (pagamento.getValor() != null) {
			Cliente sacado = pagamento.getSacado();

			sacado.setCredito(sacado.getCredito() - pagamento.getValor());
			sacado.getPagamentos().add(pagamento);
		}

		return null;
	}

}
