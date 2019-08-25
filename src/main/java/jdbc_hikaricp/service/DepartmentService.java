package jdbc_hikaricp.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_hikaricp.daoimpl.DepartmentDaoImpl;
import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.jdbc.ConnectionFactory;

public class DepartmentService {
	private static DepartmentService instance = new DepartmentService();
	
	public static DepartmentService getInstance() {
		return instance;
	}

	public static void setInstance(DepartmentService instance) {
		DepartmentService.instance = instance;
	}

	public List<Department> selectDepartmentAll() {
		List<Department> list = null;
		try {
			list= DepartmentDaoImpl.getInstance().selectDepartmentByAll(ConnectionFactory.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void createDepartment(Department department) throws SQLException {
		DepartmentDaoImpl.getInstance().insertDepartment(ConnectionFactory.getConnection(), department);
	}
	
}
