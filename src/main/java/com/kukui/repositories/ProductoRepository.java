package com.kukui.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kukui.models.Producto;



//Indicamos que extendemos de la interface JpaRepository y que manejamos la entidad llamada Producto identificandola por su atributo Long id. 

//Usara consultas predefinidas del JPA Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	//Esta anotacion nos indica que podemos realizar una consulta personalizada a la base de datos. En este caso, obtenemos un producto por su nombre. Dicha consulta esta escrita en JPQL (Java Persistence Query Language) que es un lenguaje orientado a objetos que permite relizar consultas a bases de datos relacionales.
	
	//crear mis propias Querys personalizadas
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	
	
	//Metodo que realiza la consulta personalizada definida anteriormente. Retorna un Optional que puede contener un objeto Producto si se encuentra en la base con el nombre especificado, o un Optional vacio si no existe.
	Optional<Producto> findByNombre(String nombre);
	
}
