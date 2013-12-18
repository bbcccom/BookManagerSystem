package com.dovewi.bookmgrcode.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.dovewi.bookmgrcode.sqlcode.ReaderTableDatabaseCode;
import com.dovewi.bookmgrcode.vo.Reader;

public class ReaderManagerUI extends JPanel {
	ReaderManagerUI() {
		this.setLayout(null);
		JTabbedPane tb = new JTabbedPane();
		tb.addTab("��Ӷ���", new AddReaderPane());
		tb.addTab("�޸���Ϣ", new UpdateReaderPane());
		tb.addTab("ɾ������", new DeleteReaderPane());
		//tb.addTab("�����ѯ", new QueryReaderPane());
		tb.setVisible(true);
		tb.setBounds(20, 20, 750, 500);
		this.add(tb);
	}
}

class AddReaderPane extends JPanel implements ActionListener {
	private JTextField tf_stuNum;
	private JTextField tf_stuName;
	private JTextField tf_stuSex;
	private JTextField tf_phone;
	private JTextArea ta_other;
	private JButton bt_commit;
	private JButton bt_clear;

	// �������
	AddReaderPane() {
		tf_stuNum = new JTextField(40);
		tf_stuName = new JTextField(15);
		tf_stuSex = new JTextField(30);
		tf_phone = new JTextField(15);
		ta_other = new JTextArea();
		// ������
		JScrollPane scp = new JScrollPane(ta_other);
		// ��ǩ
		JLabel label_stuNum = new JLabel("ѧ��");
		JLabel label_stuName = new JLabel("����");
		JLabel label_stuSex = new JLabel("�Ա�");
		JLabel label_phone = new JLabel("�绰");
		JLabel label_other = new JLabel("����");
		// ��ť
		bt_commit = new JButton("�ύ");
		bt_clear = new JButton("���");
		// ��ʼ���촰��
		setLayout(null);
		this.add(label_stuNum);
		label_stuNum.setBounds(230, 20, 60, 16);
		this.add(label_stuName);
		label_stuName.setBounds(230, 90, 60, 16);
		this.add(label_stuSex);
		label_stuSex.setBounds(230, 160, 60, 16);
		this.add(label_phone);
		label_phone.setBounds(230, 230, 60, 16);
		this.add(label_other);
		label_other.setBounds(230, 300, 60, 16);
		// ����ı��򵽴���
		this.add(tf_stuNum);
		tf_stuNum.setBounds(230, 40, 271, 30);
		this.add(tf_stuName);
		tf_stuName.setBounds(230, 110, 271, 30);
		this.add(tf_stuSex);
		tf_stuSex.setBounds(230, 180, 271, 30);
		this.add(tf_phone);
		tf_phone.setBounds(230, 250, 271, 30);
		this.add(scp);
		scp.setBounds(230, 320, 271, 70);
		// ���������ť,���������õ�ҵ���߼�����
		this.add(bt_commit);
		bt_commit.setBounds(250, 410, 100, 25);
		bt_commit.addActionListener(this);
		this.add(bt_clear);
		bt_clear.setBounds(370, 410, 100, 25);
		bt_clear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bt_clear) {
			this.tf_phone.setText("");
			this.tf_stuName.setText("");
			this.tf_stuNum.setText("");
			this.tf_stuSex.setText("");
		} else if (arg0.getSource() == this.bt_commit) {
			String numtmp = "";
			String nametmp = "";
			String sextmp = "";
			String other = "";
			int mltmp = 5;
			int brwtmp = 0;
			int reneguetmp = 0;
			String phonetmp = "";
			numtmp = this.tf_stuNum.getText();
			nametmp = this.tf_stuName.getText();
			sextmp = this.tf_stuSex.getText();
			phonetmp = this.tf_phone.getText();
			other = this.ta_other.getText();
			Reader rdtmp = new Reader();
			rdtmp.setBorrowNum(brwtmp);
			rdtmp.setMaxLend(mltmp);
			rdtmp.setOther(other);
			rdtmp.setReaderName(nametmp);
			rdtmp.setReaderNum(numtmp);
			rdtmp.setReaderPhone(phonetmp);
			rdtmp.setReaderSex(sextmp);
			rdtmp.setRenegue(reneguetmp);
			boolean flag = ReaderTableDatabaseCode.addReader(rdtmp);
			if (flag == true) {
				JOptionPane.showConfirmDialog(null, "��ӳɹ�", "��ʾ",
						JOptionPane.OK_OPTION);
			} else {
				JOptionPane.showConfirmDialog(null, "���ʧ��", "��ʾ",
						JOptionPane.OK_OPTION);
			}
		}
	}
}

class DeleteReaderPane extends JPanel implements ActionListener {
	private JButton btTrue;
	private JTextField tf_stuNum;

	DeleteReaderPane() {
		btTrue=new JButton("ɾ������");
		tf_stuNum=new JTextField(20);
		this.add(btTrue);
		this.add(tf_stuNum);
		this.setLayout(null);
		btTrue.setBounds(420, 210, 100, 25);
		tf_stuNum.setBounds(215, 210, 200, 25);
		btTrue.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String rdnum=this.tf_stuNum.getText();
		boolean flag=false;
		try{
			flag=ReaderTableDatabaseCode.delReader(rdnum);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, "ɾ��ʧ�ܣ������Ƿ���ڴ��û�","��ʾ",JOptionPane.OK_OPTION);
		}finally{
			if(flag==true){
				JOptionPane.showConfirmDialog(null, "ɾ���ɹ�","��ʾ",JOptionPane.OK_OPTION);
			}
		}
	}
}

class UpdateReaderPane extends JPanel implements ActionListener {
	private JTextField tf_stuNum;
	private JTextField tf_stuName;
	private JTextField tf_stuSex;
	private JTextField tf_phone;
	private JTextArea ta_other;
	private JButton bt_commit;
	private JButton bt_get;
	private String a="";
	private String b="";
	private String c="";
	private String d="";
	private String e="";
	UpdateReaderPane() {
		tf_stuNum = new JTextField(40);
		tf_stuName = new JTextField(15);
		tf_stuSex = new JTextField(30);
		tf_phone = new JTextField(15);
		ta_other = new JTextArea();
		// ������
		JScrollPane scp = new JScrollPane(ta_other);
		// ��ǩ
		JLabel label_stuNum = new JLabel("ѧ��");
		JLabel label_stuName = new JLabel("����");
		JLabel label_stuSex = new JLabel("�Ա�");
		JLabel label_phone = new JLabel("�绰");
		JLabel label_other = new JLabel("����");
		// ��ť
		bt_commit = new JButton("�ύ");
		bt_get = new JButton("��ȡ");
		// ��ʼ���촰��
		setLayout(null);
		this.add(label_stuNum);
		label_stuNum.setBounds(230, 20, 60, 16);
		this.add(label_stuName);
		label_stuName.setBounds(230, 90, 60, 16);
		this.add(label_stuSex);
		label_stuSex.setBounds(230, 160, 60, 16);
		this.add(label_phone);
		label_phone.setBounds(230, 230, 60, 16);
		this.add(label_other);
		label_other.setBounds(230, 300, 60, 16);
		// ����ı��򵽴���
		this.add(tf_stuNum);
		tf_stuNum.setBounds(230, 40, 271, 30);
		this.add(tf_stuName);
		tf_stuName.setBounds(230, 110, 271, 30);
		this.add(tf_stuSex);
		tf_stuSex.setBounds(230, 180, 271, 30);
		this.add(tf_phone);
		tf_phone.setBounds(230, 250, 271, 30);
		this.add(scp);
		scp.setBounds(230, 320, 271, 70);
		// ���������ť,���������õ�ҵ���߼�����
		this.add(bt_commit);
		bt_commit.setBounds(250, 410, 100, 25);
		bt_commit.addActionListener(this);
		this.add(bt_get);
		bt_get.setBounds(370, 410, 100, 25);
		bt_get.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0){
		if (arg0.getSource() == this.bt_get) {
			ResultSet rs=ReaderTableDatabaseCode.queryReader(this.tf_stuNum.getText());
			try{
				
				while(rs.next()){
					a=rs.getString("readerphone");
					b=rs.getString("readername");
					c=rs.getString("readernum");
					d=rs.getString("readersex");
					e=rs.getString("other");
				}
				this.tf_phone.setText(a);
				this.tf_stuName.setText(b);
				this.tf_stuNum.setText(c);
				this.tf_stuSex.setText(d);
				this.ta_other.setText(e);
			}catch(SQLException e){
				System.out.println(e.getMessage());
				JOptionPane.showConfirmDialog(null, "��ȡ��Ϣ����","��ʾ",JOptionPane.ERROR_MESSAGE);
			}
		} else if (arg0.getSource() == this.bt_commit) {
			boolean t1=false,t2=false,t3=false,t4=false;
			try{
				t1=ReaderTableDatabaseCode.updateReader(this.tf_stuNum.getText(), "readername", this.tf_stuName.getText());
				t2=ReaderTableDatabaseCode.updateReader(this.tf_stuNum.getText(), "readersex", this.tf_stuSex.getText());
				t3=ReaderTableDatabaseCode.updateReader(this.tf_stuNum.getText(), "readerphone", this.tf_phone.getText());
				t4=ReaderTableDatabaseCode.updateReader(this.tf_stuNum.getText(), "other", this.ta_other.getText());
			}catch(Exception e2){
				JOptionPane.showConfirmDialog(null, "�޸ĳ���","��ʾ",JOptionPane.CLOSED_OPTION);
			}finally{
				if(t1==true&&t2==true&&t3==true&&t4==true){
					JOptionPane.showConfirmDialog(null, "�޸ĳɹ�","��ʾ",JOptionPane.CLOSED_OPTION);
				}
			}
		}
	}
}

/*class QueryReaderPane extends JPanel {
	QueryReaderPane() {

	}
}*/
