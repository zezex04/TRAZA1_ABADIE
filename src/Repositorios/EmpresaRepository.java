/*
* Esta interfaz define los métodos CRUD?? para la entidad Empresa.
*/

package Repositorios;

import Entidades.Empresa;
import java.util.List;
import java.util.Optional;

public interface EmpresaRepository {
    List<Empresa> findAll();
    Optional<Empresa> findById(Long id);
    Optional<Empresa> findByNombre(String nombre);
    Empresa save(Empresa empresa);
    void deleteById(Long id);
    boolean existsById(Long id);
}