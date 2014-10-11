package fai.domain;

import fai.domain.EntidadeDominio;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity
@Table(name="TB_Item")
public class Item extends EntidadeDominio implements Serializable {

	private Integer quantidade;
	private Produto produto;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ped_id")
	private Pedido pedido;
	
	private static final long serialVersionUID = 1L;

	public Item() {
		super();
	}
   
}
