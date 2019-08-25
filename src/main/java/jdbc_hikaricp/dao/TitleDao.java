package jdbc_hikaricp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc_hikaricp.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll(Connection con) throws SQLException;
	int insertTitle(Connection con, Title title) throws SQLException;
	int deleteTitle(Connection con, Title title) throws SQLException;
	int updateTitle(Connection con, Title title) throws SQLException;
	Title selectTitleByCode(Connection con, Title title) throws SQLException;
}
