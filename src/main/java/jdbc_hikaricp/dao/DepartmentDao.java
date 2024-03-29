package jdbc_hikaricp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc_hikaricp.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll(Connection con) throws SQLException ;
	int insertDepartment(Connection con, Department dept) throws SQLException ;
	int deleteDepartment(Connection con, Department dept) throws SQLException ;
	int updateDepartment(Connection con, Department dept) throws SQLException ;
	Department selectDepartmentByCode(Connection con, Department dept) throws SQLException ;
}
