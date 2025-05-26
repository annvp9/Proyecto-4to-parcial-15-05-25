package dao.generics;

import java.util.List;

public interface GenericDAO<T> {
    void insertar(T entidad);
    void actualizar(T entidad);
    void eliminar(int id);
    List<T> obtenerTodos();
    T obtenerPorId(int id);
}
