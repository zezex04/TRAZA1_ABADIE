package Entidades;

import Repositorios.InMemoryRepository;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@SuperBuilder // Para crear un patrón Builder que funciona con herencia
@Data // Genera getters, setters, equals, hashCode y toString automáticamente
@ToString // Genera metodo toString

public class Empresa implements InMemoryRepository.HasId {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logo;

    //Para asignar un valor por defecto a un campo cuando usas el patrón Builder de Lombok.
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();
}