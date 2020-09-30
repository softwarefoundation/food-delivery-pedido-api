package com.softwarefoundation.fooddeliverypedidoapi.service;

import com.softwarefoundation.fooddeliverypedidoapi.entity.Restaurante;
import com.softwarefoundation.fooddeliverypedidoapi.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante pesquisarPorId(final Long id) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(id);
        return restaurante.isPresent() ? restaurante.get() : null;
    }

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Restaurante atualizar(Restaurante restaurante) {
        Optional<Restaurante> optional = restauranteRepository.findById(restaurante.getId());

        if (optional.isPresent()) {
            return restauranteRepository.save(restaurante);
        } else {
            return null;
        }
    }

    public boolean excluir(Long id) {
        try {

            Optional<Restaurante> restaurante = restauranteRepository.findById(id);
            if (restaurante.isPresent()) {
                restauranteRepository.delete(restaurante.get());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

}
