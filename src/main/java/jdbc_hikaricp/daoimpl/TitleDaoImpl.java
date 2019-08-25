package jdbc_hikaricp.daoimpl;

import java.sql.Connection;
import java.util.List;

import jdbc_hikaricp.dao.TitleDao;
import jdbc_hikaricp.dto.Title;

public class TitleDaoImpl implements TitleDao {

	@Override
	public List<Title> selectTitleByAll(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTitle(Connection con, Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTitle(Connection con, Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTitle(Connection con, Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Title selectTitleByCode(Connection con, Title title) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
