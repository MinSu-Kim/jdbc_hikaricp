package jdbc_hikaricp.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_hikaricp.AbstractTest;
import jdbc_hikaricp.LogUtil;
import jdbc_hikaricp.daoimpl.TitleDaoImpl;
import jdbc_hikaricp.dto.Title;
import jdbc_hikaricp.jdbc.ConnectionFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest extends AbstractTest {
	private static TitleDao dao = TitleDaoImpl.getInstance();
	
	@After
	public void tearDown() throws Exception {
		List<Title> list = dao.selectTitleByAll(ConnectionFactory.getConnection());
		LogUtil.prnLog(list);
	}

	@Test
	public void test01SelectTitleByAll() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Title> list = dao.selectTitleByAll(ConnectionFactory.getConnection());
		LogUtil.prnLog(list);
		Assert.assertNotNull(list);
	}

	@Test
	public void test02InsertTitle() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleCode(7);
		title.setTitleName("계약");
		dao.insertTitle(ConnectionFactory.getConnection(), title);
	}

	@Test
	public void test05DeleteTitle() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title(7);
		dao.deleteTitle(ConnectionFactory.getConnection(), title);
	}

	@Test
	public void test03UpdateTitle() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleCode(7);
		title.setTitleName("임시계약");
		dao.updateTitle(ConnectionFactory.getConnection(), title);
	}

	@Test
	public void test04SelectTitleByCode() throws SQLException {
		logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title(7);
		dao.selectTitleByCode(ConnectionFactory.getConnection(), title);
	}

}
