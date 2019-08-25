package jdbc_hikaricp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;


public class AbstractTest {
	
	protected static Logger logger = LogManager.getLogger();
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

}
