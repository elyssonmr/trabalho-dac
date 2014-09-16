
package fai.domain;



public class Mensagem {

	private String descricao;
	
	public Mensagem(String descricao){
		this.descricao = descricao;
	}
	

	@Override
	public String toString() {
		
		return descricao;
	}
	
}
