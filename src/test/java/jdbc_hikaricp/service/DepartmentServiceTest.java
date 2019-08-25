package jdbc_hikaricp.service;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc_hikaricp.AbstractTest;
import jdbc_hikaricp.dto.Department;

public class DepartmentServiceTest extends AbstractTest {
	private static DepartmentService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = DepartmentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testSelectDepartmentAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDepartment() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department newDept = new Department(4, "마케팅", 40);
		service.createDepartment(newDept);
	}

}
