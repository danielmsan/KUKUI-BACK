package com.kukui.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "pedido")
public class Pedido {
	
	
	@Id //el campo Id es la primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //el campo id sera generado automaticamente por la DB
    @Column(name="id_pedido", unique = true, nullable = false)
	private Long idPedido;
	@Column(name = "fecha" ,columnDefinition = "DATE") //Fecha actual (para un correcto seguimiento)
	private LocalDate fecha;
	@Column(name = "fecha_envio" ,columnDefinition = "DATE")// Fecha aproximada de envio
	private LocalDate fecha_envio;
	@Column(name = "fecha_entrega" ,columnDefinition = "DATE")// Fecha aproximada de entrega
	private LocalDate fecha_entrega;	
	private double monto_pedido;
	
	//Establece la relación bidireccional con Producto
	 @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	    private List<Producto> productos;
	 
	 //Establece la relacion con solo un usario
	 @ManyToOne
	    @JoinColumn(name = "usuario_id")
	    private Usuario usuario;
	 
	 

	public Pedido() {
		
	}



	public Pedido(Long idPedido, LocalDate fecha, LocalDate fecha_envio, LocalDate fecha_entrega, double monto_pedido,
		List<Producto> productos, Usuario usuario) {
		
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.fecha_envio = fecha_envio;
		this.fecha_entrega = fecha_entrega;
		this.monto_pedido = monto_pedido;
		this.productos = productos;
		this.usuario = usuario;
	}



	public Long getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public LocalDate getFecha_envio() {
		return fecha_envio;
	}



	public void setFecha_envio(LocalDate fecha_envio) {
		this.fecha_envio = fecha_envio;
	}



	public LocalDate getFecha_entrega() {
		return fecha_entrega;
	}



	public void setFecha_entrega(LocalDate fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}



	public double getMonto_pedido() {
		return monto_pedido;
	}



	public void setMonto_pedido(double monto_pedido) {
		this.monto_pedido = monto_pedido;
	}



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	
	
	
	 
	 

}
