package com.softwarefoundation.fooddeliverypedidoapi.entity;

import com.softwarefoundation.fooddeliverypedidoapi.dto.ClientePedidoDto;
import com.softwarefoundation.fooddeliverypedidoapi.dto.PedidoDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "TB01_CLIENTE")
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CLIENTE_ID")
    private Long clienteId;

    @Column(name = "NOME")
    private String nome;

    public static Cliente from(ClientePedidoDto dto){
        Cliente cliente = new ModelMapper().map(dto, Cliente.class);
        return cliente;
    }

    public static Cliente from(PedidoDto dto){
        Cliente cliente = new ModelMapper().map(dto, Cliente.class);
        return cliente;
    }

}
