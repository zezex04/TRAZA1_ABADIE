package Entidades;

import lombok.*;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString(exclude = "sucursal")

//Acordarse que solo puede ir uno de los builders, no los dos juntos
//No usar @Builder y @SuperBuilder juntos

public class Domicilio {
    private Long id;
    private String calle;
    private Integer numero;
    private Integer codigoPostal;
    private Localidad localidad;
}
