
package fai.teste;


import fai.controle.impl.Fachada;
import fai.core.controle.IFachada;
import fai.domain.Cliente;
import fai.domain.Endereco;



public class TesteCliente {

	
	public static void main(String[] args) {
	Cliente cliente = new Cliente();
	Endereco end = new Endereco();
	//definir dados do cliente e endereco
	//deve associar end a cliente
	IFachada fachada = new Fachada();
	fachada.salvar(cliente);

	}

}
