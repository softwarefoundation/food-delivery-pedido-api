package com.softwarefoundation.fooddeliverypedidoapi.mensagens;

import com.softwarefoundation.fooddeliverypedidoapi.dto.ClientePedidoDto;
import com.softwarefoundation.fooddeliverypedidoapi.entity.Cliente;
import com.softwarefoundation.fooddeliverypedidoapi.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiverClienteMenssage {

    private final ClienteService clienteService;

    @Autowired
    public ReceiverClienteMenssage(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RabbitListener(queues = {"${cadastro.client.rabbitmq.queue}"})
    public void receive(@Payload ClientePedidoDto dto) {
        log.info(dto.toString());
        clienteService.salvar(Cliente.from(dto));
    }

}
