package jdbc_hikaricp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_hikaricp.dao.TitleDao;
import jdbc_hikaricp.dto.Title;
import jdbc_hikaricp.jdbc.LogUtil;

public class TitleDaoImpl implements TitleDao {
	private static TitleDaoImpl instance = new TitleDaoImpl();

	public static TitleDaoImpl getInstance() {
		return instance;
	}

	private TitleDaoImpl() {}

	@Override
	public List<Title> selectTitleByAll(Connection con) throws SQLException {
		List<Title> lists = null;
		String sql = "select title_code, title_name from title";

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			LogUtil.prnLog(pstmt);
			if (rs.next()) {
				lists = new ArrayList<>();
				do {
					lists.add(getTitle(rs));
				} while (rs.next());
			}
		}
		return lists;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		return new Title(rs.getInt("title_code"), rs.getString("title_name"));
	}

	@Override
	public void insertTitle(Connection con, Title title) throws SQLException {
		String sql = "insert into title(title_code, title_name) values(?, ?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, title.getTitleCode());
			pstmt.setString(2, title.getTitleName());
			LogUtil.prnLog(pstmt);
			pstmt.executeUpdate();
		}
	}

	@Override
	public void deleteTitle(Connection con, Title title) throws SQLException {
		String sql = "delete from title where title_code=?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, title.getTitleCode());
			LogUtil.prnLog(pstmt);
			pstmt.executeUpdate();
		}
	}

	@Override
	public void updateTitle(Connection con, Title title) throws SQLException {
		String sql = "update title set title_name=? where title_code=?;";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, title.getTitleName());
			pstmt.setInt(2, title.getTitleCode());
			LogUtil.prnLog(pstmt);
			pstmt.executeUpdate();
		}
	}

	@Override
	public Title selectTitleByCode(Connection con, Title title) throws SQLException {
		String sql = "select title_code, title_name from title where title_code = ?";
		Title selTitle = null;
		try (PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, title.getTitleCode());
			LogUtil.prnLog(pstmt);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					selTitle = getTitle(rs);
				}
			}
		} 		
		return selTitle;
	}

}
