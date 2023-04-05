package com.kukui.models;

import java.util.List;
import java.util.Optional;

import com.kukui.util.PasswordUtil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    private String nombre;
    
    private String apellido;
    
    @OneToOne
    private Optional<Direccion> direccion;
    

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password; // contraseña en texto plano
    
    @Column(nullable = false)
    private String encryptedPassword; // contraseña cifrada
    
    
    
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    // constructor, getters y setters, etc.
    
    
    
    
   
	public Usuario(Long idUsuario, String nombre, String apellido, Direccion direccion, String email, String password,
			String encryptedPassword, List<Pedido> pedidos) {
		
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = Optional.of(direccion);
		this.email = email;
		this.password = password;
		this.encryptedPassword = encryptedPassword;
		this.pedidos = pedidos;
	}
	
	 public Usuario() {
		super();
	}

	public void setPassword(String password) {
	        this.password = password;
	        PasswordUtil passEncoder = new PasswordUtil();
	        this.encryptedPassword = PasswordUtil.hashPassword(password);
	        
	       
	    }

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public Optional<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(Optional<Direccion> direccion2) {
		this.direccion = direccion2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getPassword() {
		return password;
	}
	
	

}