package jdbc_hikaricp.daoimpl;

import java.sql.Connection;
import java.util.List;

import jdbc_hikaricp.dao.EmployeeDao;
import jdbc_hikaricp.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> selectEmployeeByAll(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertEmployee(Connection con, Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(Connection con, Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmployee(Connection con, Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee selectEmployeeByCode(Connection con, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	

}










