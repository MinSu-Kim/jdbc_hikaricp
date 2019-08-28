package jdbc_hikaricp.jdbc;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import jdbc_hikaricp.AbstractTest;

public class ConnectionFactoryTest extends AbstractTest {

	@Test
	public void testGetConnection() {
		Connection con = ConnectionFactory.getConnection();
		logger.debug(con);
			
		Assert.assertNotNull(con);
	}

}
