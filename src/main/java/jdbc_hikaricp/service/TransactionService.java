package jdbc_hikaricp.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc_hikaricp.dao.DepartmentDao;
import jdbc_hikaricp.dao.TitleDao;
import jdbc_hikaricp.daoimpl.DepartmentDaoImpl;
import jdbc_hikaricp.daoimpl.TitleDaoImpl;
import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.dto.Title;
import jdbc_hikaricp.jdbc.ConnectionFactory;

public class TransactionService {
	private static TransactionService instance = new TransactionService();
	private DepartmentDao deptDao;
	private TitleDao titleDao;
	
	public static TransactionService getInstance() {
		return instance;
	}

	private TransactionService() {
		deptDao = DepartmentDaoImpl.getInstance();
		titleDao = TitleDaoImpl.getInstance();
	}

	public void addTitleDeparment(Title title, Department department) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			deptDao.insertDepartment(con, department);
			titleDao.insertTitle(con, title);
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e.getCause());
			}
		} finally {
			try {
				con.setAutoCommit(true);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeTitleDeparment(Title title, Department department) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			deptDao.deleteDepartment(con, department);
			titleDao.deleteTitle(con, title);
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1.getCause());
			}
		} finally {
			try {
				con.setAutoCommit(true);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
