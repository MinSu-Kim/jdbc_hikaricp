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

import jdbc_hikaricp.ui.content.AbstractPanel;
import jdbc_hikaricp.ui.list.AbstractList;

@SuppressWarnings("serial")
public abstract class AbstractFrameUI<T> extends JFrame implements ActionListener {
	private JButton btnAdd;
	protected AbstractPanel<T> pContent;
	protected List<T> itemList;
	protected AbstractList<T> pList;
	private JButton btnCancel;

	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;

	public AbstractFrameUI(String title) {
		initService();
		initComponents(title);
	}

	protected abstract void initService();

	private void initComponents(String title) {
		setTitle(title);
		setBounds(200, 100, 450, 450);
		JPanel pMain = new JPanel();
		getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));

		pContent = createContentPanel();

		pMain.add(pContent, BorderLayout.CENTER);

		JPanel pBtns = new JPanel();
		pMain.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);

		pList = createListPanel();
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

	protected void reloadList() {
		pList.setItemList();
		pList.reloadData();
	}

	protected void refreshUI() {
		reloadItemList();
		reloadList();
		clearContent();
	}

	protected abstract void reloadItemList();

	private void actionPerformedBtnUpdate(ActionEvent e) throws SQLException {
		T updateDept = pContent.getItem();
		updateItem(updateDept);
		refreshUI();
		btnAdd.setText("추가");
	}
	
	private void actionPerformedMntmUpdate(ActionEvent e) {
		T updateDept = pList.getSelectedItem();
		pContent.setItem(updateDept);
		btnAdd.setText("수정");
	}

	private void actionPerformedMntmDelete(ActionEvent e) throws SQLException {
		T delDept = pList.getSelectedItem();
		deleteItem(delDept);
		refreshUI();
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) throws SQLException {
		T insertDepartment = pContent.getItem();
		insertItem(insertDepartment);
		refreshUI();
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		clearContent();
	}
	
	protected abstract AbstractList<T> createListPanel();
	protected abstract AbstractPanel<T> createContentPanel();
	
	protected abstract void updateItem(T item) throws SQLException;
	protected abstract void clearContent();
	protected abstract void deleteItem(T item) throws SQLException;
	protected abstract void insertItem(T item) throws SQLException;

}
