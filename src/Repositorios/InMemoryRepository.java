package Repositorios;
import Entidades.Pais;
/*
 * Clase que simula un repositorio en memoria para almacenar entidades.
 * Esta clase puede ser utilizada para pruebas o desarrollo sin necesidad de una base de datos real.
 */

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRepository<T> {
    protected Map<Long, T> almacen = new HashMap<>();
    protected AtomicLong idGenerator = new AtomicLong();
    public T save(T entinty){
        //Genero un id y rescata el id que ya esta declarado en el obejeto, luego los guarda en un HashMap
        long id = idGenerator.incrementAndGet();
        try {
            String clase;
            entinty.getClass().getDeclaredMethod("setId", Long.class).invoke(entinty, id);
            clase = entinty.getClass().getName();
            System.out.println(clase + "    id: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        almacen.put(id,entinty);

        return entinty;

    }

    public Optional<T> findById(long id){
        return Optional.ofNullable(almacen.get(id));
    }

    public Optional<List<T>> findByField(String field, Object value) {
        List<T> lista = new ArrayList<>();
        try{
            for (T entity : almacen.values()) {
                Method metodoEntidad = entity.getClass().getMethod("get"+capitalize(field));
                Object valorField = metodoEntidad.invoke(entity);
                if(valorField != null && valorField.equals(value)){
                    lista.add(entity);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.of(lista);
    }
    public void update(Long id, Object value, String fieldName) {
        try{
            T entity= almacen.get(id);
            if (entity == null) {
                throw new IllegalArgumentException("No se encontró una entidad con el ID: " + id);
            }
            Method campoActualizar = entity.getClass().getMethod("set"+capitalize(fieldName), value.getClass());
            campoActualizar.invoke(entity, value);
            System.out.println("Campo " + fieldName + " actualizada con valor " + value + " en el entidad " + id +"de clase "+ entity.getClass().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public Optional<T> Delete(Long id) {
        if (!almacen.containsKey(id)) {
            return Optional.empty();
        }

        return Optional.ofNullable(almacen.remove(id));
    }
}
