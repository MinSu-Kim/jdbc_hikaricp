package jdbc_hikaricp.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_hikaricp.AbstractTest;
import jdbc_hikaricp.LogUtil;
import jdbc_hikaricp.daoimpl.DepartmentDaoImpl;
import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.jdbc.ConnectionFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest extends AbstractTest {
	DepartmentDao dao = DepartmentDaoImpl.getInstance();
	
	@After
	public void tearDown() throws Exception {
		List<Department> list = dao.selectDepartmentByAll(ConnectionFactory.getConnection());
		LogUtil.prnLog(list);
	}
	
	@Test
	public void testSelect01DepartmentByAll() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Department> list = dao.selectDepartmentByAll(ConnectionFactory.getConnection());
		LogUtil.prnLog(list);
		Assert.assertNotNull(list);
	}

	@Test
	public void test02InsertDepartment() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department newDept = new Department(4, "마케팅", 40);
		try {
			dao.insertDepartment(ConnectionFactory.getConnection(), newDept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test03UpdateDepartment() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department newDept = new Department(4, "마케팅2", 60);
		try {
			dao.updateDepartment(ConnectionFactory.getConnection(), newDept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test04DeleteDepartment() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department newDept = new Department(4);
		try {
			dao.deleteDepartment(ConnectionFactory.getConnection(), newDept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test05SelectDepartmentByCode() {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Department dto = new Department(1);
		
		Department selDept;
		try {
			selDept = dao.selectDepartmentByCode(ConnectionFactory.getConnection(), dto);
			LogUtil.prnLog(selDept);
			Assert.assertNotNull(selDept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
