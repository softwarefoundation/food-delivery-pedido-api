package com.softwarefoundation.fooddeliverypedidoapi.entity;

import com.softwarefoundation.fooddeliverypedidoapi.dto.ClienteDto;
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

    public static Cliente from(ClienteDto dto){
        Cliente cliente = new ModelMapper().map(dto, Cliente.class);
        return cliente;
    }

}
