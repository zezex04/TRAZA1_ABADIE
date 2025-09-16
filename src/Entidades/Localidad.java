package Entidades;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@SuperBuilder // Para crear un patrón Builder que funciona con herencia
@Data // Genera getters, setters, equals, hashCode y toString automáticamente
@ToString // Genera metodo toString (redundante porque @Data ya lo incluye)
@Builder // Para crear un patrón Builder básico (conflicto con @SuperBuilder)

public class Localidad {
    private Long id;
    private String nombre;
    private Provincia provincia;
}
