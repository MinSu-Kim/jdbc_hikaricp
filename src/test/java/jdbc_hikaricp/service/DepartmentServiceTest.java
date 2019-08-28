package jdbc_hikaricp.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_hikaricp.AbstractTest;
import jdbc_hikaricp.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentServiceTest extends AbstractTest {
	private static DepartmentService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = DepartmentService.getInstance();
	}

	@Test
	public void test2SelectDepartmentAll() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Department> list = service.selectDepartmentAll();
		Assert.assertNotNull(list);
	}

	@Test
	public void test1CreateDepartment() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department newDept = new Department(5, "총무", 40);
		service.createDepartment(newDept);
	}

	@Test
	public void test3RemoveDepartment() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department newDept = new Department(5);
		service.removeDepartment(newDept);
	}
}
