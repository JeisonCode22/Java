package interfaces;

import java.util.List;

public interface DAO<E> {

	public abstract E buscar(int id);

	public abstract boolean insertar(E e);

	public abstract boolean modificar(E e);

	public abstract boolean Eliminar(E e);

	List<E> listar();
}