package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: ValoracionProfesor
 *
 */
@NamedQuery (name = "ValoracionProfesor.todos", query = "Select va from ValoracionActividad va" )
@Entity

public class ValoracionProfesor extends ValoracionActividad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Profesor profesor;
	
	
	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public ValoracionProfesor() {
		super();
	}
   
}
