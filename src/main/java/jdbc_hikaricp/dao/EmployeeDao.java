package jdbc_hikaricp.dao;

import java.sql.Connection;
import java.util.List;

import jdbc_hikaricp.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll(Connection con);
	int insertEmployee(Connection con, Employee employee);
	int deleteEmployee(Connection con, Employee employee);
	int updateEmployee(Connection con, Employee employee);
	Employee selectEmployeeByCode(Connection con, Employee employee);
	
}
