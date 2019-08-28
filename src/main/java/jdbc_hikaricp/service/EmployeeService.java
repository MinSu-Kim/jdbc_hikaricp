package jdbc_hikaricp.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_hikaricp.dao.DepartmentDao;
import jdbc_hikaricp.dao.EmployeeDao;
import jdbc_hikaricp.dao.TitleDao;
import jdbc_hikaricp.daoimpl.DepartmentDaoImpl;
import jdbc_hikaricp.daoimpl.EmployeeDaoImpl;
import jdbc_hikaricp.daoimpl.TitleDaoImpl;
import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.dto.Employee;
import jdbc_hikaricp.dto.Title;
import jdbc_hikaricp.jdbc.ConnectionFactory;

public class EmployeeService {
	private static final EmployeeService instance = new EmployeeService();
	
	public static EmployeeService getInstance() {
		return instance;
	}

	private EmployeeDao empDao;
	private DepartmentDao deptDao;
	private TitleDao titleDao;
	
	private EmployeeService() {
		empDao = EmployeeDaoImpl.getInstance();
		deptDao = DepartmentDaoImpl.getInstance();
		titleDao = TitleDaoImpl.getInstance();
	}

	public List<Department> selectDeptAll() throws SQLException {
		return deptDao.selectDepartmentByAll(ConnectionFactory.getConnection());
	}

	public List<Title> selectTitleAll() throws SQLException {
		return titleDao.selectTitleByAll(ConnectionFactory.getConnection());
	}

	public void updateEmpoyee(Employee item) throws SQLException {
		empDao.updateEmployee(ConnectionFactory.getConnection(), item);
	}

	public List<Employee> selectEmpAll() {
		return empDao.selectEmployeeByAll(ConnectionFactory.getConnection());
	}

	public void deleteEmp(Employee item) {
		empDao.deleteEmployee(ConnectionFactory.getConnection(), item);
	}

	public void createItem(Employee item) {
		empDao.insertEmployee(ConnectionFactory.getConnection(), item);
	}
	
	
}
