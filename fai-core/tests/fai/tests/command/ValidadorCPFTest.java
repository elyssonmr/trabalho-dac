package fai.tests.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fai.domain.Cliente;
import fai.negocio.imp.ValidadorCPF;

public class ValidadorCPFTest {

	private ValidadorCPF validador;
	private Cliente cliente;

	@Before
	public void carregar() {
		validador = new ValidadorCPF();
		this.cliente = new Cliente();
		this.cliente.setCpf("12345678910");
	}

	@Test
	public void deveValidarCPFTest() {
		String erroMsg = validador.execute(this.cliente);
		assertEquals("Não deve conter Mensagem de erro", null, erroMsg);
	}

	@Test
	public void cpfDeveConter11DigitosTest() {
		this.cliente.setCpf("1234");
		String erroMsg = validador.execute(this.cliente);
		assertEquals("Deve Exibir a mensagem de erro do CPF",
				"CPF deve ter 11 digitos", erroMsg);
	}

	@Test
	public void cpfObrigatorioTest() {
		this.cliente.setCpf(null);
		String erroMsg = validador.execute(this.cliente);
		assertEquals("CPF é obrigatorio", "CPF deve estar preenchido", erroMsg);
	}
}
