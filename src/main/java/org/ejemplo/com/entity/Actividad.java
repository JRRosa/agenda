package org.ejemplo.com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Actividad implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer idUsuario;
	private String nombre;
	private String descripcion;
	private String lugar;
	private Boolean estado;
	private String fechaHoraInicio;
	private String fechaHoraFin;
	private String fechaModificacion;
	private String fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	public Actividad() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(String fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public String getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(String fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		if (!(obj instanceof Actividad)) {
			return false;
		}
		Actividad other = (Actividad) obj;
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
		builder.append("Actividad [id=").append(id).append(", idUsuario=").append(idUsuario).append(", nombre=")
				.append(nombre).append(", descripcion=").append(descripcion).append(", lugar=").append(lugar)
				.append(", estado=").append(estado).append(", fechaHoraInicio=").append(fechaHoraInicio)
				.append(", fechaHoraFin=").append(fechaHoraFin).append(", fechaModificacion=").append(fechaModificacion)
				.append(", fechaRegistro=").append(fechaRegistro).append(", usuario=").append(usuario).append("]");
		return builder.toString();
	}
	
}
