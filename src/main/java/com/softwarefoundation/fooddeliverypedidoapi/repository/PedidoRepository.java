package com.softwarefoundation.fooddeliverypedidoapi.repository;

import com.softwarefoundation.fooddeliverypedidoapi.entity.Cliente;
import com.softwarefoundation.fooddeliverypedidoapi.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
