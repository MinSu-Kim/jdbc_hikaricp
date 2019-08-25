package jdbc_hikaricp.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_hikaricp.dao.TitleDao;
import jdbc_hikaricp.daoimpl.TitleDaoImpl;
import jdbc_hikaricp.dto.Title;
import jdbc_hikaricp.jdbc.ConnectionFactory;

public class TitleService {
	private static TitleService instance = new TitleService();
	private TitleDao dao;
	
	public static TitleService getInstance() {
		return instance;
	}

	private TitleService() {
		dao = TitleDaoImpl.getInstance();
	}
	
	public List<Title> selectTitleAll(){
		List<Title> list = null;
		try {
			list= dao.selectTitleByAll(ConnectionFactory.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void createTitle(Title title) throws SQLException {
		dao.insertTitle(ConnectionFactory.getConnection(), title);
	}
	
	public void removeTitle(Title title) throws SQLException {
		dao.deleteTitle(ConnectionFactory.getConnection(), title);
	}
	
}
