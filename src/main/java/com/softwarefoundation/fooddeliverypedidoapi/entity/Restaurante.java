package com.softwarefoundation.fooddeliverypedidoapi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.softwarefoundation.fooddeliverypedidoapi.dto.RestauranteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TB02_RESTAURANTE")
@Entity
public class Restaurante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    public static Restaurante from(RestauranteDto dto) {
        return new ModelMapper().map(dto, Restaurante.class);
    }
}
