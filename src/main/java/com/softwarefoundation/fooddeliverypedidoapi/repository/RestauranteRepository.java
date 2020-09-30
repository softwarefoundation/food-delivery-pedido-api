package com.softwarefoundation.fooddeliverypedidoapi.repository;

import com.softwarefoundation.fooddeliverypedidoapi.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
    
}
