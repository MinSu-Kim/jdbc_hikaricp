package jdbc_hikaricp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zaxxer.hikari.HikariDataSource;

import jdbc_hikaricp.AbstractTest;

public class HikariCPFactoryTest extends AbstractTest {
	private static HikariCPFactory factory;
	private static DataSource ds;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new HikariCPFactory();
		ds = factory.getDataSource();
	}

	@Test
	public void testGetDataSource() {
		logger.trace("testPool()");

		Connection[] connections = new Connection[10];

		try {
			for (int i = 0; i < 10; i++) {
				connections[i] = ds.getConnection();
				Assert.assertNotNull(connections[i]);
				printDriverStats();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void printDriverStats() {
		HikariDataSource hds = (HikariDataSource) ds;
		logger.trace(String.format("getMinimumIdle: %s", hds.getMinimumIdle()));
		logger.trace(String.format("getMaximumPoolSize: %d", hds.getMaximumPoolSize()));
		logger.trace(String.format("getJdbcUrl: %s", hds.getJdbcUrl()));
		
		logger.trace(String.format("getCatalog: %s", hds.getCatalog() ));
		logger.trace(String.format("getConnectionTimeout: %s", hds.getConnectionTimeout() ));
		logger.trace(String.format("getDataSourceClassName: %s", hds.getDataSourceClassName() ));
		logger.trace(String.format("getIdleTimeout: %s", hds.getIdleTimeout() ));

	}

}
