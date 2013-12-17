package com.dovewi.bookmgrcode.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.dovewi.bookmgrcode.sqlcode.BookTableDatabaseCode;

public class BrowserUI extends JPanel implements ActionListener {
	private JButton brwBtn;
	private JScrollPane jscp;
	//private JTextField txtField;

	BrowserUI() {
		brwBtn = new JButton("��ȡ����");
		brwBtn.addActionListener(this);
		//txtField = new JTextField(20);
		this.setLayout(null);
		this.add(brwBtn);
		//this.add(txtField);
		brwBtn.setBounds(330, 25, 100, 30);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.brwBtn) {
			Object[] columName = { "ISBN", "����", "����", "�۸�", "�ڹ�����", "����", "���" };
			ResultSet rs = BookTableDatabaseCode.queryAllBook();
			int rownum=0;
			try {
				rs.last();//�ƶ�����ָ�뵽��β����ȡĩβ����
				rownum = rs.getRow();
				rs.beforeFirst();;//�Ƶ���ͷ����ֹ�������������
			} catch (SQLException e1) {
				System.out.println("��ȡ��¼����ʧ��");
			}
			Object[][] rowData = new Object[rownum][7];
			int i = 0;
			try {
				while (rs.next()) { // ������ѯ���
					rowData[i][0] = rs.getString("isbnnumber"); // ��ʼ����������
					rowData[i][1] = rs.getString("bookname");
					rowData[i][2] = rs.getString("author");
					rowData[i][3] = rs.getString("price");
					rowData[i][4] = rs.getString("amount");
					rowData[i][5] = rs.getString("sum");
					rowData[i][6] = rs.getString("bookinfo");
					i++;
				}
				JTable myTable = new JTable(rowData, columName);
				jscp=new JScrollPane(myTable);
				jscp.setBounds(30, 80, 730, 430);
				this.add(jscp);
				jscp.setVisible(true);
			} catch (SQLException e) {
				System.out.println("���������ִ���" + e.getMessage());
			}
		} else {
			JOptionPane.showConfirmDialog(null, "δ֪����", "����",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
