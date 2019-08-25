package jdbc_hikaricp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_hikaricp.dao.DepartmentDao;
import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.jdbc.LogUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	private static DepartmentDaoImpl instance = new DepartmentDaoImpl();
	
	public static DepartmentDaoImpl getInstance() {
		return instance;
	}

	public static void setInstance(DepartmentDaoImpl instance) {
		DepartmentDaoImpl.instance = instance;
	}

	private DepartmentDaoImpl() {}

	@Override
	public List<Department> selectDepartmentByAll(Connection con) throws SQLException {
		List<Department> lists = null;
		String sql = "select dept_code, dept_name, floor from department";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			LogUtil.prnLog(pstmt);
			if (rs.next()) {
				lists = new ArrayList<Department>();
				do {
					lists.add(getDepartment(rs));
				}while(rs.next());
			}
		}	
		return lists;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("dept_code"), 
				              rs.getString("dept_name"), 
				              rs.getInt("floor"));
	}

	@Override
	public void insertDepartment(Connection con, Department dept) throws SQLException {
		String sql = "insert into department(dept_code, dept_name, floor) values(?, ?, ?)";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, dept.getDeptCode());
			pstmt.setString(2, dept.getDeptName());
			pstmt.setInt(3, dept.getFloor());
			LogUtil.prnLog(pstmt);
			pstmt.executeUpdate();
		} 
	}

	@Override
	public void deleteDepartment(Connection con, Department dept) throws SQLException {
		String sql = "delete from department where dept_code=?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, dept.getDeptCode());
			LogUtil.prnLog(pstmt);
			pstmt.executeUpdate();
		}
	}

	@Override
	public void updateDepartment(Connection con, Department dept) throws SQLException {
		String sql = "update department set dept_name=?, floor=? where dept_code=?;";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, dept.getDeptName());
			pstmt.setInt(2, dept.getFloor());
			pstmt.setInt(3, dept.getDeptCode());
			LogUtil.prnLog(pstmt);
			pstmt.executeUpdate();
		}		
	}

	@Override
	public Department selectDepartmentByCode(Connection con, Department dept) throws SQLException {
		String sql = "select dept_code, dept_name, floor from department where dept_code = ?";
		Department selDept = null;
		try (PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, dept.getDeptCode());
			LogUtil.prnLog(pstmt);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					selDept = getDepartment(rs);
				}
			}
		} 		
		return selDept;
	}


}
