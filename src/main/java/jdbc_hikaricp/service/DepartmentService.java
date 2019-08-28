package jdbc_hikaricp.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_hikaricp.dao.DepartmentDao;
import jdbc_hikaricp.daoimpl.DepartmentDaoImpl;
import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.jdbc.ConnectionFactory;

public class DepartmentService {
	private static final DepartmentService instance = new DepartmentService();
	private DepartmentDao dao;
	
	public static DepartmentService getInstance() {
		return instance;
	}

	private DepartmentService() {
		dao = DepartmentDaoImpl.getInstance();
	}

	public List<Department> selectDepartmentAll() throws SQLException {
		return dao.selectDepartmentByAll(ConnectionFactory.getConnection());
	}

	public void createDepartment(Department department) throws SQLException {
		dao.insertDepartment(ConnectionFactory.getConnection(), department);
	}
	
	public void removeDepartment(Department department) throws SQLException {
		dao.deleteDepartment(ConnectionFactory.getConnection(), department);
	}

	public void updateDepartment(Department updateDept) throws SQLException {
		dao.updateDepartment(ConnectionFactory.getConnection(), updateDept);
	}
}
