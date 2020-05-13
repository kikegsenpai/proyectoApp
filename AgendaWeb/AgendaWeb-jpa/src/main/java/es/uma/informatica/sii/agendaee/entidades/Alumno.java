package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Alumno
 *
 */
@NamedQuery (name = "Alumno.todos", query = "Select a from Usuario a where a.Num_docente is null" )
@Entity

public class Alumno extends Usuario implements Serializable {

	
	private Integer Num_expediente;
	private static final long serialVersionUID = 1L;

	public Alumno() {
		super();
	}   
	public Integer getNum_expediente() {
		return this.Num_expediente;
	}

	public void setNum_expediente(Integer Num_expediente) {
		this.Num_expediente = Num_expediente;
	}
   
}
