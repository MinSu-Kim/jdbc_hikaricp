package jdbc_hikaricp.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import jdbc_hikaricp.dto.Department;
import jdbc_hikaricp.service.DepartmentService;
import jdbc_hikaricp.ui.content.AbstractPanel;
import jdbc_hikaricp.ui.content.PanelDepartment;
import jdbc_hikaricp.ui.list.AbstractList;
import jdbc_hikaricp.ui.list.DepartmentList;

@SuppressWarnings("serial")
public class DepartmentFrameUI extends JFrame implements ActionListener {
	private JButton btnAdd;
	private AbstractPanel<Department> pContent;
	private List<Department> deptList;
	private AbstractList<Department> pList;
	private JButton btnCancel;

	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;

	private DepartmentService deptService;

	public DepartmentFrameUI() {
		deptService = DepartmentService.getInstance();
		initComponents();
	}

	private void initComponents() {
		setTitle("직책관리");
		setBounds(200, 100, 450, 450);
		JPanel pMain = new JPanel();
		getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));

		pContent = new PanelDepartment("부서");

		pMain.add(pContent, BorderLayout.CENTER);

		JPanel pBtns = new JPanel();
		pMain.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);

		pList = new DepartmentList("부서");
		getContentPane().add(pList, BorderLayout.SOUTH);

		popupMenu = new JPopupMenu();

		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);

		mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu.add(mntmDelete);

		pList.setPopupMenu(popupMenu);

		reloadList();
		clearContent();
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == mntmDelete) {
				actionPerformedMntmDelete(e);
			}
			if (e.getSource() == mntmUpdate) {
				actionPerformedMntmUpdate(e);
			}
			if (e.getSource() == btnCancel) {
				actionPerformedBtnCancel(e);
			}
			if (e.getSource() == btnAdd) {
				if (e.getActionCommand().equals("추가")) {
					actionPerformedBtnAdd(e);
				}
				if (e.getActionCommand().equals("수정")) {
					actionPerformedBtnUpdate(e);
				}
			}
		}catch(SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	private void clearContent() {
		pContent.clearComponent(deptList == null ? 1 : deptList.size() + 1);
	}

	private void reloadList() {
		pList.setItemList();
		pList.reloadData();
	}

	private void refreshUI() throws SQLException {
		reloadList();
		clearContent();
	}

	private void actionPerformedBtnUpdate(ActionEvent e) throws SQLException {
		Department updateDept = pContent.getItem();
		deptService.updateDepartment(updateDept);
		refreshUI();
		btnAdd.setText("추가");
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) throws SQLException {
		Department insertDepartment = pContent.getItem();
		deptService.createDepartment(insertDepartment);
		refreshUI();
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		clearContent();
	}

	private void actionPerformedMntmUpdate(ActionEvent e) {
		Department updateDept = pList.getSelectedItem();
		pContent.setItem(updateDept);
		btnAdd.setText("수정");
	}

	private void actionPerformedMntmDelete(ActionEvent e) throws SQLException {
		Department delDept = pList.getSelectedItem();
		deptService.removeDepartment(delDept);
		refreshUI();
	}

}
