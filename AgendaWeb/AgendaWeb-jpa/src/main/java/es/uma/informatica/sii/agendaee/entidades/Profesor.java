package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Profesor
 *
 */
@NamedQuery (name = "Profesor.todos", query = "Select p from Usuario p" )
@Entity

public class Profesor extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer Num_docente;
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "fk_ong", nullable = true)
	private ONG ong;
	
	
	public ONG getOng() {
		return ong;
	}
	public void setOng(ONG ong) {
		this.ong = ong;
	}
	public Profesor() {
		super();
	}   
	public Integer getNum_docente() {
		return this.Num_docente;
	}

	public void setNum_docente(Integer Num_docente) {
		this.Num_docente = Num_docente;
	}
   
}
