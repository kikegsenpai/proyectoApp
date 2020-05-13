package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


@Entity
public class ONG implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	private String Nombre;
	private String Descripcion;
	
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ONG other = (ONG) obj;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
	
	/*
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "fk_profesor", nullable = false)
	private Profesor profesor;
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public List<Actividades> getActividades() {
		return actividades;
	}
	public void setActividades(List<Actividades> actividades) {
		this.actividades = actividades;
	}

	@OneToMany (mappedBy = "ong")
	private List<Actividades> actividades;
	

	public ONG() {
		super();
	}   
	public Integer getCodigo_ong() {
		return this.Codigo_ong;
	}

	public void setCodigo_ong(Integer Codigo_ong) {
		this.Codigo_ong = Codigo_ong;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
	*/
   
}
