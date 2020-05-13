package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Actividades
 *
 */
@NamedQuery (name = "Actividades.todos", query = "Select a from Actividades a" )
@Entity

public class Actividades implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Integer Codigo_Act;
	@Column (nullable = false)
	private Integer Plazas;
	private String Nombre;
	private String Descripcion;
	private Date Fecha_Inicio;
	private Date Fecha_Fin;
	private String Tipo;
	@JoinColumn (nullable = false)
	@ManyToOne
	private ONG ong;
	@ManyToMany (mappedBy = "estaEnActividad")
	private List<Usuario> participaUsuario;

	public List<Usuario> getParticipaUsuario() {
		return participaUsuario;
	}
	public void setParticipaUsuario(List<Usuario> participaUsuario) {
		this.participaUsuario = participaUsuario;
	}
	public Actividades() {
		super();
	}   
	public Integer getCodigo_Act() {
		return this.Codigo_Act;
	}

	public void setCodigo_Act(Integer Codigo_Act) {
		this.Codigo_Act = Codigo_Act;
	}   
	public Integer getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(Integer Plazas) {
		this.Plazas = Plazas;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}   
	public Date getFecha_Inicio() {
		return this.Fecha_Inicio;
	}

	public void setFecha_Inicio(Date Fecha_Inicio) {
		this.Fecha_Inicio = Fecha_Inicio;
	}   
	public Date getFecha_Fin() {
		return this.Fecha_Fin;
	}

	public void setFecha_Fin(Date Fecha_Fin) {
		this.Fecha_Fin = Fecha_Fin;
	}   
	public String getTipo() {
		return this.Tipo;
	}

	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
   
}
