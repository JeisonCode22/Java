package implementaciones;

import java.util.List;

import entidades.Cliente;
import interfaces.Conexion;
import interfaces.DAO;

public class ImpCliente implements DAO<Cliente>, Conexion {

	@Override
	public Cliente buscar(int id) {

		return null;
	}

	@Override
	public boolean insertar(Cliente cliente) {

		return false;
	}

	@Override
	public boolean modificar(Cliente cliente) {

		return false;
	}

	@Override
	public boolean Eliminar(Cliente cliente) {
		return false;
	}

	@Override
	public List<Cliente> listar() {
		return null;
	}

}
