package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Conexion {
	default Connection getConexion() {
		Connection conexion = null;
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/bancodb";
		String user = "root";
		String password = "";

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, password);
			System.out.println("exitosa");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;

	}
}