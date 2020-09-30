package com.softwarefoundation.fooddeliverypedidoapi.controller;

import com.softwarefoundation.fooddeliverypedidoapi.dto.PedidoDto;
import com.softwarefoundation.fooddeliverypedidoapi.entity.Pedido;
import com.softwarefoundation.fooddeliverypedidoapi.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/cliente/{id}")
    public ResponseEntity pesquisar(@PathVariable("id") Long id) {

        try {
            Pedido pedido = pedidoService.pesquisarPorId(id);
            return Objects.nonNull(pedido) ? ResponseEntity.ok(pedido) : ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/cliente")
    public ResponseEntity cadastrar(@RequestBody PedidoDto dto) {
        try {
            log.info(dto.toString());
            return ResponseEntity.ok(pedidoService.salvar(Pedido.from(dto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody PedidoDto dto) {
        Pedido pedido = Pedido.from(dto);
        pedido.setId(id);
        Pedido pd = pedidoService.atualizar(pedido);

        if (Objects.nonNull(pd)) {
            return ResponseEntity.ok(pd);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        if (pedidoService.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
