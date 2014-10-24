package fai.domain;

<<<<<<< HEAD
=======
import java.util.Date;

>>>>>>> elyssonmr
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo extends EntidadeDominio {
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private double valor;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "cli_id")
	private Cliente cliente;
	
	public Emprestimo(){
		super();
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
