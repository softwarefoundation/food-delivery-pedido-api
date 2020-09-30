package com.softwarefoundation.fooddeliverypedidoapi.entity;

import com.softwarefoundation.fooddeliverypedidoapi.dto.MenuDto;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "TB03_MENU")
@Entity
public class Menu {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MENU_ID")
    private Long menuId;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO")
    private Double preco;

    public static Menu from(MenuDto dto){
        return new ModelMapper().map(dto, Menu.class);
    }
}
