package implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.AreaJefe;
import interfaces.Conexion;
import interfaces.DAO;

public class ImpArea implements DAO<AreaJefe>, Conexion {
	private PreparedStatement preparedStatementBuscar;
	private PreparedStatement preparedStatementInsetar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementListar;

	@Override
	public AreaJefe buscar(int id) {
		AreaJefe areaJefe = null;
		String sql = "select id_area,nombre from area where id_area =?";

		try {
			if (preparedStatementBuscar == null) {
				preparedStatementBuscar = getConexion().prepareStatement(sql);
			}
			preparedStatementBuscar.setInt(1, id);

			ResultSet resultSet = preparedStatementBuscar.executeQuery();
			if (resultSet.next()) {
				areaJefe = new AreaJefe();
				areaJefe.setId_area(resultSet.getInt(1));
				areaJefe.setNombre(resultSet.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areaJefe;
	}

	@Override
	public boolean insertar(AreaJefe areaJefe) {
		if (areaJefe == null) {
			return false;
		}
		String sql = "insert into area(id_area,nombre) values(?,?); ";
		try {
			if (preparedStatementInsetar == null) {
				preparedStatementInsetar = getConexion().prepareStatement(sql);
			}
			preparedStatementInsetar.setInt(1, areaJefe.getId_area());
			preparedStatementInsetar.setString(2, areaJefe.getNombre());

			return preparedStatementInsetar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean Eliminar(AreaJefe e) {
		return false;
	}

	@Override
	public boolean modificar(AreaJefe areaJefe) {
		if (areaJefe == null) {
			return false;
		}
		String sql = "update area set nombre =? where id_area =?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, areaJefe.getNombre());
			preparedStatementModificar.setInt(2, areaJefe.getId_area());
			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<AreaJefe> listar() {
		List<AreaJefe> areas = new ArrayList<>();
		String sql = "select id_area,nombre from area";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}
			ResultSet resultSet = preparedStatementListar.executeQuery();
			while (resultSet.next()) {
				AreaJefe areaJefe1 = new AreaJefe();
				areaJefe1.setId_area(resultSet.getInt("id_area"));
				areaJefe1.setNombre(resultSet.getString("nombre"));

				areas.add(areaJefe1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return areas;
	}

}