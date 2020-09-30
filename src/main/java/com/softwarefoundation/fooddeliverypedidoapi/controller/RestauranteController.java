
package com.softwarefoundation.fooddeliverypedidoapi.controller;

import java.io.Serializable;
import java.util.Objects;

import com.softwarefoundation.fooddeliverypedidoapi.dto.RestauranteDto;
import com.softwarefoundation.fooddeliverypedidoapi.entity.Restaurante;
import com.softwarefoundation.fooddeliverypedidoapi.service.RestauranteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api")
@Slf4j
public class RestauranteController implements Serializable{
    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/restaurante/{id}")
    public ResponseEntity pesquisar(@PathVariable("id") Long id) {

        try {
            Restaurante restaurante = restauranteService.pesquisarPorId(id);
            return Objects.nonNull(restaurante) ? ResponseEntity.ok(restaurante) : ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/restaurante")
    public ResponseEntity cadastrar(@RequestBody RestauranteDto restauranteDto) {
        try {
            log.info(restauranteDto.toString());
            return ResponseEntity.ok(restauranteService.salvar(Restaurante.from(restauranteDto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/restaurante/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody RestauranteDto restauranteDto) {
        Restaurante restaurante = Restaurante.from(restauranteDto);
        restaurante.setId(id);
        Restaurante rs = restauranteService.atualizar(restaurante);

        if (Objects.nonNull(rs)) {
            return ResponseEntity.ok(rs);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/restaurante/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        if (restauranteService.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
