package jdbc_hikaricp.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc_hikaricp.dao.DepartmentDao;
import jdbc_hikaricp.dao.TitleDao;
import jdbc_hikaricp.daoimpl.DepartmentDaoImpl;
import jdbc_hikaricp.daoimpl.TitleDaoImpl;
import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.dto.Title;
import jdbc_hikaricp.exception.TransactionException;
import jdbc_hikaricp.jdbc.ConnectionFactory;
import jdbc_hikaricp.jdbc.LogUtil;

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

	public void addTitleDeparment(Title title, Department department)  {
		Connection con = null;
		int res = 0;
		try {
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			res += deptDao.insertDepartment(con, department);
			res += titleDao.insertTitle(con, title);
			LogUtil.prnLog("addTitleDeparment() res : " + res);
			if (res == 2) con.commit();
			else new SQLException();
		} catch (SQLException e) {
			rollback(con);
			throw new RuntimeException(e.getCause());
		} finally {
			close(con);
		}
	}

	public void removeTitleDeparment(Title title, Department department) {
		Connection con = null;
		int res = 0;
		try {
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			res += deptDao.deleteDepartment(con, department);
			res += titleDao.deleteTitle(con, title);
			LogUtil.prnLog("removeTitleDeparment() res : " + res);
			if (res == 2) con.commit();
			else throw new SQLException();
		} catch (SQLException e) {
			rollback(con);
			throw new TransactionException("삭제 익셉션");
		} finally {
			close(con);
		}
	}

	public void close(Connection con) {
		try {
			con.setAutoCommit(true);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollback(Connection con) {
		try {
			LogUtil.prnLog("rollback()");
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
