package jdbc_hikaricp.dao;

import java.sql.Connection;
import java.util.List;

import jdbc_hikaricp.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll(Connection con);
	int insertTitle(Connection con, Title title);
	int deleteTitle(Connection con, Title title);
	int updateTitle(Connection con, Title title);
	Title selectTitleByCode(Connection con, Title title);
}
