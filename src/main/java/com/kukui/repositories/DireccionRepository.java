package com.kukui.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kukui.models.Direccion;
@Repository

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
	
	
	
	
    
}
