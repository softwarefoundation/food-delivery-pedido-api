package com.softwarefoundation.fooddeliverypedidoapi.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PedidoDto {

    private Long menuId;
    private Long clienteId;
    private Long restauranteId;
    private Double preco;

}
