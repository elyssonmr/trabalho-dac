
package fai.domain;

import java.util.List;



public class Resultado<E extends EntidadeDominio> {
	private List<E> entidades;
	private List<Mensagem> mensagens;
	
	public Resultado(List<Mensagem> mensagens, 
			List<E> entidades){
		this.entidades = entidades;
		this.mensagens = mensagens;
	}	
	public Resultado(List<Mensagem> mensagens){
		this.mensagens = mensagens;
	}
	
	public Resultado(){
		
	}	
	
	public List<E> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<E> entidades) {
		this.entidades = entidades;
	}
	public List<Mensagem> getMensagens() {
		return mensagens;
	}
	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}	
	
}
