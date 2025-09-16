package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(exclude = "provincias")
@EqualsAndHashCode(exclude = "provincias")

public class Pais {
    private Long id;
    private String nombre;

    @Builder.Default
    private Set<Provincia> provincias = new HashSet<>();
}