package Entidades;

import lombok.*;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;

@Data
@SuperBuilder
@ToString(exclude = "empresa")

public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean es_Casa_Matriz;

    private Domicilio domicilio;
    private Empresa empresa;
}
