package com.softwarefoundation.fooddeliverypedidoapi.service;

import com.softwarefoundation.fooddeliverypedidoapi.entity.Menu;
import com.softwarefoundation.fooddeliverypedidoapi.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {


    @Autowired
    private MenuRepository menuRepository;

    public Menu pesquisarPorId(final Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        return menu.isPresent() ? menu.get() : null;
    }

    public Menu salvar(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu atualizar(Menu menu) {
        Optional<Menu> optional = menuRepository.findById(menu.getId());

        if (optional.isPresent()) {
            return menuRepository.save(menu);
        } else {
            return null;
        }
    }

    public boolean excluir(Long id) {
        try {

            Optional<Menu> restaurante = menuRepository.findById(id);
            if (restaurante.isPresent()) {
                menuRepository.delete(restaurante.get());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

}
