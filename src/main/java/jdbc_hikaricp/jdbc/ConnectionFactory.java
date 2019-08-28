package jdbc_hikaricp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
	private static HikariCPFactory factory = new HikariCPFactory();

	public static Connection getConnection() {
		try {
			return factory.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
