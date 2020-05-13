package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ValoracionActividad
 *
 */
@NamedQuery (name = "ValoracionActividad.todos", query = "Select va from ValoracionActividad va" )
@Entity

public class ValoracionActividad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column (nullable = false)
	private Integer Puntuacion;
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Actividades getActividad() {
		return actividad;
	}
	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}

	private String Contenido;
	private Date Fecha;
	@Id
	private Alumno alumno;
	@Id
	private Actividades actividad;
	

	public ValoracionActividad() {
		super();
	}   
	public Integer getPuntuacion() {
		return this.Puntuacion;
	}

	public void setPuntuacion(Integer Puntuacion) {
		this.Puntuacion = Puntuacion;
	}   
	public String getContenido() {
		return this.Contenido;
	}

	public void setContenido(String Contenido) {
		this.Contenido = Contenido;
	}   
	public Date getFecha() {
		return this.Fecha;
	}

	public void setFecha(Date Fecha) {
		this.Fecha = Fecha;
	}
   
}
