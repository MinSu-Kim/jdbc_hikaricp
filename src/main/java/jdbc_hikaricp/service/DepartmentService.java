package jdbc_hikaricp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc_hikaricp.dao.DepartmentDao;
import jdbc_hikaricp.daoimpl.DepartmentDaoImpl;
import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.jdbc.ConnectionFactory;

public class DepartmentService {
	private static DepartmentService instance = new DepartmentService();
	private DepartmentDao dao;
	
	public static DepartmentService getInstance() {
		return instance;
	}

	private DepartmentService() {
		dao = DepartmentDaoImpl.getInstance();
	}

	public static void setInstance(DepartmentService instance) {
		DepartmentService.instance = instance;
	}

	public List<Department> selectDepartmentAll() {
		List<Department> list = null;
		try {
			list= dao.selectDepartmentByAll(ConnectionFactory.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void createDepartment(Department department) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		con.setAutoCommit(false);
		int res = dao.insertDepartment(con, department);
		if (res == 1) {
			con.commit();
		}
		else throw new RuntimeException();
	}
	
	public void removeDepartment(Department department) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		con.setAutoCommit(false);
		int res = dao.deleteDepartment(ConnectionFactory.getConnection(), department);
		if (res == 1) {
			con.commit();
		}
		else throw new RuntimeException();
	}
}
