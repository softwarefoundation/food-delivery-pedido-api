package com.softwarefoundation.fooddeliverypedidoapi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuDto {

    private Long menuId;
    private String nome;
    private Double preco;
    private Long restautanteId;

}
