package implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.EmpleadoJefe;
import interfaces.Conexion;
import interfaces.DAO;

public class ImpEmpleadoJefe implements DAO<EmpleadoJefe>, Conexion {
	private PreparedStatement preparedStatementBuscaid;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementListar;

	public EmpleadoJefe buscarID(int id_jefe) {
		EmpleadoJefe empleadoJefe = null;
		String sql = "select nombre, id_area from empleado_jefe where id_jefe = ? ";
		try {
			if (preparedStatementBuscaid == null) {
				preparedStatementBuscaid = getConexion().prepareStatement(sql);
			}
			preparedStatementBuscaid.setInt(1, id_jefe);

			ResultSet resultSet = preparedStatementBuscaid.executeQuery(); 
			if (resultSet.next()) {
				empleadoJefe = new EmpleadoJefe();
				empleadoJefe.setId_jefe(resultSet.getInt(1));
				empleadoJefe.setNombre(resultSet.getString(2));
				empleadoJefe.setId_area(resultSet.getInt(3));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empleadoJefe;
	}

	@Override
	public EmpleadoJefe buscar(int id) {
		return null;
	}

	@Override
	public boolean insertar(EmpleadoJefe empleadoJefe) {
		if (empleadoJefe == null) {
			return false;
		}
		String sql = "insert into empleado_jefe(id_jefe,nombre,id_area) values(?,?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}
			preparedStatementInsertar.setInt(1, empleadoJefe.getId_jefe());
			preparedStatementInsertar.setString(2, empleadoJefe.getNombre());
			preparedStatementInsertar.setInt(3, empleadoJefe.getId_area());

			return preparedStatementInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean modificar(EmpleadoJefe empleadoJefe) {
		if (empleadoJefe == null) {
			return false;
		}
		String sql = "update empleado_jefe set nombre =?,id_area =? where id_jefe=?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, empleadoJefe.getNombre());
			preparedStatementModificar.setInt(2, empleadoJefe.getId_area());
			preparedStatementModificar.setInt(3, empleadoJefe.getId_jefe());

			return preparedStatementModificar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean Eliminar(EmpleadoJefe empleadoJefe) {
		return false;
	}

	@Override
	public List<EmpleadoJefe> listar() {
		List<EmpleadoJefe> jefes = new ArrayList<>();
		String sql = "select id_jefe,nombre,id_area from empleado_jefe";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}
			ResultSet resultSet = preparedStatementListar.executeQuery();
			while (resultSet.next()) {
				EmpleadoJefe empleadoJefe = new EmpleadoJefe();
				empleadoJefe.setId_jefe(resultSet.getInt("id_jefe"));
				empleadoJefe.setNombre(resultSet.getString("nombre"));
				empleadoJefe.setId_area(resultSet.getInt("id_area"));
				jefes.add(empleadoJefe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jefes;
	}
}
