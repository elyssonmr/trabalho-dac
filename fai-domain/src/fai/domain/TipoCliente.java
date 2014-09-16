
package fai.domain;



public class TipoCliente extends EntidadeDominio{

	private String descricao;

	
	public TipoCliente() {}
	
	public TipoCliente(String descricao) {this.descricao = descricao;}
	
	public TipoCliente(int id) {this.id = id;}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
/*	CREATE TABLE tb_tipocliente
	(
	  id serial NOT NULL,
	  description character varying(30) NOT NULL,
	  date_insert date NOT NULL,
	  CONSTRAINT tb_tipocliente_pkey PRIMARY KEY (id)
	)*/
	
	
	
}
