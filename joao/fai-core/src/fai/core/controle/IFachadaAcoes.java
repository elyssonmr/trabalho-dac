package fai.core.controle;

import fai.domain.Cliente;
import fai.domain.Resultado;

public interface IFachadaAcoes {

	public Resultado<Cliente> validadeLogin(Cliente cliente);

}
