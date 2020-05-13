package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String DNI;
	@Column (nullable = false)
	private String Password;
	@Column (nullable = false)
	private String Nombre;
	@Column (nullable = false)
	private String Apellido1;
	
	@Column (nullable = false)
	private String Apellido2;
	
	@Column (nullable = false)
	private String Email;
	private String Direccion;
	@ManyToMany
	@JoinTable ( name = "jnd_usuario_actividad" ,
			joinColumns = @JoinColumn (name = "usuario_fk"),
			inverseJoinColumns = @JoinColumn(name = "actividad_fk"))
	private List<Actividades> estaEnActividad;

	public List<Actividades> getEstaEnActividad() {
		return estaEnActividad;
	}
	public void setEstaEnActividad(List<Actividades> estaEnActividad) {
		this.estaEnActividad = estaEnActividad;
	}
	public Usuario() {
		super();
	}   
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getApellido1() {
		return this.Apellido1;
	}

	public void setApellido1(String Apellido1) {
		this.Apellido1 = Apellido1;
	}   
	public String getApellido2() {
		return this.Apellido2;
	}

	public void setApellido2(String Apellido2) {
		this.Apellido2 = Apellido2;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public String getDireccion() {
		return this.Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
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
		Usuario other = (Usuario) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		return true;
	}
   
}
