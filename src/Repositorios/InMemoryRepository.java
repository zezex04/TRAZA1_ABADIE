package Repositorios;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class InMemoryRepository<T> {
    protected Map<Long, T> almacen = new HashMap<>();
    private Long nextId = 1L;

    public T save(T entity) {
        // Si es una nueva entidad, le asignamos un ID
        if (entity instanceof HasId) {
            HasId hasIdEntity = (HasId) entity;
            if (hasIdEntity.getId() == null) {
                hasIdEntity.setId(nextId++);
            }
            almacen.put(hasIdEntity.getId(), entity);
        }
        return entity;
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(almacen.get(id));
    }

    // Interfaz para entidades que tienen ID
    public interface HasId {
        Long getId();
        void setId(Long id);
    }
}