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
	
	public List<Title> selectTitleAll() throws SQLException{
		return dao.selectTitleByAll(ConnectionFactory.getConnection());
	}
	
	public void createTitle(Title title) throws SQLException {
		dao.insertTitle(ConnectionFactory.getConnection(), title);
	}
	
	public void removeTitle(Title title) throws SQLException {
		dao.deleteTitle(ConnectionFactory.getConnection(), title);
	}

	public void updateTitle(Title item) throws SQLException {
		dao.updateTitle(ConnectionFactory.getConnection(), item);
	}

}
