package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(exclude = "pais")
@EqualsAndHashCode(exclude = "pais")

/* Sin exclude, cuando imprimas una Provincia, también se imprimiría el objeto Pais completo.
Y si ese Pais tiene una colección de Provincia, crearías una referencia circular*/

public class Provincia {
    private Long id;
    private String nombre;
    private Pais pais;

    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();
}
