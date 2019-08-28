package jdbc_hikaricp.ui;

import java.sql.SQLException;

import javax.swing.JFrame;

import jdbc_hikaricp.dto.Employee;
import jdbc_hikaricp.service.EmployeeService;
import jdbc_hikaricp.ui.content.AbstractPanel;
import jdbc_hikaricp.ui.content.PanelEmployee;
import jdbc_hikaricp.ui.list.AbstractList;
import jdbc_hikaricp.ui.list.EmployeeList;

@SuppressWarnings("serial")
public class EmployeeFrameUI extends AbstractFrameUI<Employee> {
	private EmployeeService service;
	
	public EmployeeFrameUI(String title) {
		super(title);
		setBounds(100, 100, 550, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	protected AbstractList<Employee> createListPanel() {
		return new EmployeeList();
	}

	@Override
	protected AbstractPanel<Employee> createContentPanel() {
		PanelEmployee empPanel = new PanelEmployee();
		try {
			empPanel.setDeptList(service.selectDeptAll());
			empPanel.setTitleList(service.selectTitleAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empPanel;
	}

	@Override
	protected void updateItem(Employee item) throws SQLException {
		service.updateEmpoyee(item);
	}

	@Override
	protected void clearContent() {
		pContent.clearComponent(itemList == null ? 1 : itemList.size() + 1);
	}

	@Override
	protected void deleteItem(Employee item) {
		service.deleteEmp(item);
	}

	@Override
	protected void insertItem(Employee item) {
		service.createItem(item);
	}

	@Override
	protected void initService() {
		service = EmployeeService.getInstance();		
	}

	@Override
	protected void reloadItemList() {
		itemList = pList.getItemList();		
	}

}
