package org.ejemplo.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String clave;
	private String fechaNacimiento;
	private String fechaRegistro;
	
	@OneToMany(mappedBy="usuario")
	List<Actividad> actividades;
	
	public Usuario() {	
	}


	public int getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public List<Actividad> getActividades() {
		return actividades;
	}


	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	public void addActividad(Actividad actividad) {
		getActividades().add(actividad);
		actividad.setUsuario(this);
	}
	
	public void removeActividad(Actividad actividad) {
		getActividades().remove(actividad);
		actividad.setUsuario(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id=").append(id).append(", nombre=").append(nombre).append(", apellido=")
				.append(apellido).append(", email=").append(email).append(", clave=").append(clave)
				.append(", fechaNacimiento=").append(fechaNacimiento).append(", fechaRegistro=").append(fechaRegistro)
				.append(", actividades=").append(actividades).append("]");
		return builder.toString();
	}
	
}
