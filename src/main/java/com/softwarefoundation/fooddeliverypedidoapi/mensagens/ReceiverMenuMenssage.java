package com.softwarefoundation.fooddeliverypedidoapi.mensagens;

import com.softwarefoundation.fooddeliverypedidoapi.dto.ClientePedidoDto;
import com.softwarefoundation.fooddeliverypedidoapi.dto.MenuPedidoDto;
import com.softwarefoundation.fooddeliverypedidoapi.entity.Cliente;
import com.softwarefoundation.fooddeliverypedidoapi.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiverMenuMenssage {

    private final ClienteService clienteService;

    @Autowired
    public ReceiverMenuMenssage(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RabbitListener(queues = {"${cadastro.menu.rabbitmq.queue}"})
    public void receive(@Payload MenuPedidoDto dto) {
        log.info(dto.toString());
    }

}
