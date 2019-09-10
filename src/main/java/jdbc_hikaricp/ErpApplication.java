package jdbc_hikaricp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_hikaricp.ui.DepartmentFrameUI;
import jdbc_hikaricp.ui.EmployeeFrameUI;
import jdbc_hikaricp.ui.TitleFrameUI;

@SuppressWarnings("serial")
public class ErpApplication extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnTitle;
	private JButton btnDepartment;
	private JButton btnEmp;
	private Map<ErpType, JFrame> map;
	
	public ErpApplication() {
		createFrame();
		initComponents();
	}

	private void createFrame() {
		map = new HashMap<>();
		map.put(ErpType.TITLE, new TitleFrameUI(ErpType.TITLE.getValue()));
		map.put(ErpType.DEPT, new DepartmentFrameUI());
		map.put(ErpType.EMP, new EmployeeFrameUI(ErpType.EMP.getValue()));
	}

	private void initComponents() {
		setTitle("ERP 관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 85);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 0));

		btnTitle = new JButton(ErpType.TITLE.getValue());
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);

		btnDepartment = new JButton(ErpType.DEPT.getValue());
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);

		btnEmp = new JButton(ErpType.EMP.getValue());
		btnEmp.addActionListener(this);
		contentPane.add(btnEmp);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmp) {
			actionPerformedBtnEmp(e);
		}
		if (e.getSource() == btnDepartment) {
			actionPerformedBtnDepartment(e);
		}
		if (e.getSource() == btnTitle) {
			actionPerformedBtnTitle(e);
		}
	}

	protected void actionPerformedBtnTitle(ActionEvent e) {
		map.get(ErpType.TITLE).setVisible(true);
	}

	protected void actionPerformedBtnDepartment(ActionEvent e) {
		map.get(ErpType.DEPT).setVisible(true);
	}

	protected void actionPerformedBtnEmp(ActionEvent e) {
		map.get(ErpType.EMP).setVisible(true);
	}

}
