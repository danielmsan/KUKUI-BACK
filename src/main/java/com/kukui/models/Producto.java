package com.kukui.models;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "producto") 
public class Producto {
	
	@Id //el campo Id es la primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //el campo id sera generado automaticamente por la DB
    @Column(name="id", unique = true, nullable = false) //especifica el nombre de la columna en la DB
	
	private Long idProducto;
	private String nombre;
	private String categoria;
	@Column(columnDefinition = "TEXT", length = 1000)
	private String descripcion;
	private Double precio;
	private String src_imagen;
	private String tamanio;
	@ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
	
	
	public Producto() {
		
	}


	public Producto(Long idProducto, String nombre, String categoria, String descripcion, Double precio,
			String src_imagen, String tamanio) {
		
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.src_imagen = src_imagen;
		this.tamanio = tamanio;
	}


	public Long getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public String getSrc_imagen() {
		return src_imagen;
	}


	public void setSrc_imagen(String src_imagen) {
		this.src_imagen = src_imagen;
	}


	public String getTamanio() {
		return tamanio;
	}


	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}


	public void setPedido(Optional<Pedido> pedido2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
