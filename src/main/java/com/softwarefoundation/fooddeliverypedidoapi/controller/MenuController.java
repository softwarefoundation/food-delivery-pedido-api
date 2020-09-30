
package com.softwarefoundation.fooddeliverypedidoapi.controller;

import com.softwarefoundation.fooddeliverypedidoapi.dto.MenuDto;
import com.softwarefoundation.fooddeliverypedidoapi.entity.Menu;
import com.softwarefoundation.fooddeliverypedidoapi.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@RestController
@RequestMapping(name = "/api")
@Slf4j
public class MenuController implements Serializable{
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu/{id}")
    public ResponseEntity pesquisar(@PathVariable("id") Long id) {

        try {
            Menu menu = menuService.pesquisarPorId(id);
            return Objects.nonNull(menu) ? ResponseEntity.ok(menu) : ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/menu")
    public ResponseEntity cadastrar(@RequestBody MenuDto menuDto) {
        try {
            log.info(menuDto.toString());
            return ResponseEntity.ok(menuService.salvar(Menu.from(menuDto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/menu/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody MenuDto menuDto) {
        Menu menu = Menu.from(menuDto);
        menu.setId(id);
        Menu rs = menuService.atualizar(menu);

        if (Objects.nonNull(rs)) {
            return ResponseEntity.ok(rs);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        if (menuService.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
