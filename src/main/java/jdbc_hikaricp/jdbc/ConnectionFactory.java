package jdbc_hikaricp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
	private static HikariCPFactory factory = new HikariCPFactory();

	public static Connection getConnection() throws SQLException {
		return factory.getDataSource().getConnection();
	}
}
