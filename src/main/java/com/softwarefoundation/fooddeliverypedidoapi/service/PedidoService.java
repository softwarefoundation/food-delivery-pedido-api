package com.softwarefoundation.fooddeliverypedidoapi.service;

import com.softwarefoundation.fooddeliverypedidoapi.entity.Cliente;
import com.softwarefoundation.fooddeliverypedidoapi.entity.Pedido;
import com.softwarefoundation.fooddeliverypedidoapi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository clienteRepository;


    public Pedido pesquisarPorId(final Long id) {
        Optional<Pedido> pedido = clienteRepository.findById(id);
        return pedido.isPresent() ? pedido.get() : null;
    }

    public Pedido salvar(Pedido cliente) {
        return clienteRepository.save(cliente);
    }

    public Pedido atualizar(Pedido pedido) {
        Optional<Pedido> optional = clienteRepository.findById(pedido.getId());

        if (optional.isPresent()) {
            return clienteRepository.save(pedido);
        } else {
            return null;
        }
    }

    public boolean excluir(Long id) {
        try {

            Optional<Pedido> pedido = clienteRepository.findById(id);
            if (pedido.isPresent()) {
                clienteRepository.delete(pedido.get());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

}
