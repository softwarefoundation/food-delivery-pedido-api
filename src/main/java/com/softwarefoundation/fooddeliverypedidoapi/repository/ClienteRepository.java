package com.softwarefoundation.fooddeliverypedidoapi.repository;

import com.softwarefoundation.fooddeliverypedidoapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
