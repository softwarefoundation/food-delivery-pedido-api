package com.softwarefoundation.fooddeliverypedidoapi.controller;

import com.softwarefoundation.fooddeliverypedidoapi.dto.ClienteDto;
import com.softwarefoundation.fooddeliverypedidoapi.entity.Cliente;
import com.softwarefoundation.fooddeliverypedidoapi.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/{id}")
    public ResponseEntity pesquisar(@PathVariable("id") Long id) {

        try {
            Cliente cliente = clienteService.pesquisarPorId(id);
            return Objects.nonNull(cliente) ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/cliente")
    public ResponseEntity cadastrar(@RequestBody ClienteDto clienteDto) {
        try {
            log.info(clienteDto.toString());
            return ResponseEntity.ok(clienteService.salvar(Cliente.from(clienteDto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody ClienteDto clienteDto) {
        Cliente cliente = Cliente.from(clienteDto);
        cliente.setId(id);
        Cliente cl = clienteService.atualizar(cliente);

        if (Objects.nonNull(cl)) {
            return ResponseEntity.ok(cl);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        if (clienteService.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
