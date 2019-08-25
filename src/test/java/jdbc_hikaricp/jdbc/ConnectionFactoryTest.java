package jdbc_hikaricp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import jdbc_hikaricp.AbstractTest;

public class ConnectionFactoryTest extends AbstractTest {

	@Test
	public void testGetConnection() {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			logger.debug(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(con);
	}

}
