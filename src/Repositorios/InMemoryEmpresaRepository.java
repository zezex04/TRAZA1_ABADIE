package Repositorios;

/* Cree esta clase para convertir las operaciones abstractas definidas en la interfaz
en código funcional que maneja datos en memoria.*/


import Entidades.Empresa;
import java.util.*;

public class InMemoryEmpresaRepository extends InMemoryRepository<Empresa> implements EmpresaRepository {

    @Override
    public List<Empresa> findAll() {
        return new ArrayList<>(almacen.values());
    }

    @Override
    public Optional<Empresa> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Optional<Empresa> findByNombre(String nombre) {
        return almacen.values().stream()
                .filter(empresa -> empresa.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        almacen.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return almacen.containsKey(id);
    }
}