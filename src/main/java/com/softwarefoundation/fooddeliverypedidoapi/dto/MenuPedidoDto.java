package com.softwarefoundation.fooddeliverypedidoapi.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuPedidoDto {

    private Long menuId;
    private Long restauranreId;
    private String nome;

}
