package com.softwarefoundation.fooddeliverypedidoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientePedidoDto {

    private String nome;
    private Long clienteId;


}
