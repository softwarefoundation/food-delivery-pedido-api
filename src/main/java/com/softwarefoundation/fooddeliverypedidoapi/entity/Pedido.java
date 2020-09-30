package com.softwarefoundation.fooddeliverypedidoapi.entity;

import com.softwarefoundation.fooddeliverypedidoapi.dto.PedidoDto;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "TB01_PEDIDO")
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MENU_ID")
    private Long menuId;

    @Column(name = "CLIENTE_ID")
    private Long clienteId;

    @Column(name = "RESTAURANTE_ID")
    private Long restauranteId;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "DATA_PEDIDO")
    private Date dataPedido;

    public static Pedido from(PedidoDto dto){
        Pedido p = new ModelMapper().map(dto, Pedido.class);
        return p;
    }

}
