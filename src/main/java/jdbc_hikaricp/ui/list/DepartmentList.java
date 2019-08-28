package jdbc_hikaricp.ui.list;

import java.sql.SQLException;

import javax.swing.SwingConstants;

import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.service.DepartmentService;

@SuppressWarnings("serial")
public class DepartmentList extends AbstractList<Department> {

	public DepartmentList(String title) {
		super(title);
	}

	@Override
	protected void tableAlignmentAndWidth() {
		// 직책번호, 직책명은 가운데 정렬
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		// 직책번호, 직책명의 폭을 (100, 200)으로 가능하면 설정
		tableSetWidth(100, 250, 100);
	}

	@Override
	protected Object[] toArray(int idx) {
		Department department = itemList.get(idx);
		return department.toArray();
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "부서번호", "부서명", "위치" };
	}

	@Override
	public void setItemList() {
		try {
			itemList = DepartmentService.getInstance().selectDepartmentAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
