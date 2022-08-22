package implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Cuenta;
import interfaces.Conexion;
import interfaces.DAO;

public class ImpCuenta implements DAO<Cuenta>, Conexion {
	private PreparedStatement preparedStatementBuscar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementListarr;

	@Override
	public Cuenta buscar(int id) {
		Cuenta cuenta = null;
		String sql = "select id_c,tipo_cuenta,No_cuenta from Cuenta where id_c=?";
		try {
			if (preparedStatementBuscar == null) {
				preparedStatementBuscar = getConexion().prepareStatement(sql);
			}
			preparedStatementBuscar.setInt(1, id);

			ResultSet resultSet = preparedStatementBuscar.executeQuery();
			if (resultSet.next()) {
				cuenta = new Cuenta();
				cuenta.setId_c(resultSet.getInt(1));
				cuenta.setTipo_cuenta(resultSet.getString(2));
				cuenta.setNo_cuenta(resultSet.getString(3));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cuenta;
	}

	@Override
	public boolean insertar(Cuenta cuenta) {
		if (cuenta == null) {
			return false;
		}
		String sql = "insert into cuenta (id_c,No_cuenta,tipo_cuenta) values(?,?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}
			preparedStatementInsertar.setInt(1, cuenta.getId_c());
			preparedStatementInsertar.setString(2, cuenta.getNo_cuenta());
			preparedStatementInsertar.setString(3, cuenta.getTipo_cuenta());

			return preparedStatementInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean Eliminar(Cuenta cuenta) {
		return false;
	}

	@Override
	public boolean modificar(Cuenta cuenta) {
		if (cuenta == null) {
			return false;
		}
		String sql = "update cuenta set No_cuenta = ?, tipo_cuenta =? where id_c = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, cuenta.getNo_cuenta());
			preparedStatementModificar.setString(2, cuenta.getTipo_cuenta());

			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cuenta> listar() {
		List<Cuenta> listaCuenta = new ArrayList<>();
		String sql = "select * from cuenta";
		try {
			if (preparedStatementListarr == null) {
				preparedStatementListarr = getConexion().prepareStatement(sql);
			}
			ResultSet resultSet = preparedStatementListarr.executeQuery();
			while (resultSet.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setId_c(resultSet.getInt("id_c"));
				cuenta.setNo_cuenta(resultSet.getString("No_cuenta"));
				cuenta.setTipo_cuenta(resultSet.getString("tipo_cuenta"));
				listaCuenta.add(cuenta);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCuenta;
	}
}
