package com.softwarefoundation.fooddeliverypedidoapi.service;

import com.softwarefoundation.fooddeliverypedidoapi.entity.Cliente;
import com.softwarefoundation.fooddeliverypedidoapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente pesquisarPorId(final Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? cliente.get() : null;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        Optional<Cliente> optional = clienteRepository.findById(cliente.getId());

        if (optional.isPresent()) {
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    public boolean excluir(Long id) {
        try {

            Optional<Cliente> cliente = clienteRepository.findById(id);
            if (cliente.isPresent()) {
                clienteRepository.delete(cliente.get());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

}
