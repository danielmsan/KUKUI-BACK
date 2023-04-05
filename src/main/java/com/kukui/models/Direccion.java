package com.kukui.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;
    
    private String calle;
    
    private String colonia;
    
    private String cp;
    
    private String ciudad;
    
    private String estado;
    
    @OneToOne(mappedBy = "direccion")
    private Usuario usuario;
    
    

	public Direccion() {
		
	}



	public Direccion(Long idDireccion, String calle, String colonia, String cp, String ciudad, String estado,
			Usuario usuario) {
		
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.colonia = colonia;
		this.cp = cp;
		this.ciudad = ciudad;
		this.estado = estado;
		this.usuario = usuario;
	}



	public Long getIdDireccion() {
		return idDireccion;
	}



	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public String getColonia() {
		return colonia;
	}



	public void setColonia(String colonia) {
		this.colonia = colonia;
	}



	public String getCp() {
		return cp;
	}



	public void setCp(String cp) {
		this.cp = cp;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
    
    // getters y setters
    
    
}
