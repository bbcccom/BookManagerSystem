package com.dovewi.bookmgrcode.ui;

import javax.swing.*;

public class LendBookPanelUI extends JPanel {
	public static JTextField tf_readerNum;
	public static JTextField tf_bookNum;
	public static JTextArea ta_readerInfo;
	public static JTextArea ta_bookInfo;
	public static JButton bt_commit;
	public static JButton bt_getInfo;
	public static JButton bt_clear;
	//����Ľ����д
	LendBookPanelUI(){
		JLabel label_readerNum=new JLabel("����֤��");
		JLabel label_bookNum=new JLabel("ͼ����");
		JLabel label_readerInfo=new JLabel("������Ϣ");
		JLabel label_bookInfo=new JLabel("ͼ����Ϣ");
		JLabel label_tip=new JLabel("��ʾ�����������Ϣ��ͼ����Ϣ�����ȡ�����Բ鿴���ݿ����Ϣ�˶�");
		JTextField tf_readerNum=new JTextField(13);
		JTextField tf_bookNum=new JTextField(15);
		JTextArea ta_readerInfo=new JTextArea();
		JTextArea ta_bookInfo=new JTextArea();
		JButton bt_commit=new JButton("�ύ");
		JButton bt_getInfo=new JButton("��ȡ");
		JButton bt_clear=new JButton("���");
		JScrollPane jsp1=new JScrollPane(ta_readerInfo);
		JScrollPane jsp2=new JScrollPane(ta_bookInfo);
		//���ò��ַ�ʽ
		this.setLayout(null);
		//��ӱ�ǩ
		add(label_readerNum);
		add(label_bookNum);
		add(label_readerInfo);
		add(label_bookInfo);
		add(label_tip);
		label_readerNum.setBounds(30,30,53,16);
		label_bookNum.setBounds(426,30,53,16);
		label_readerInfo.setBounds(30,104,53,16);
		label_bookInfo.setBounds(426,104,53,16);
		label_tip.setBounds(30,444,410,16);
		//����ı����
		add(tf_readerNum);
		add(tf_bookNum);
		add(jsp1);
		add(jsp2);
		tf_readerNum.setBounds(30,65,330,25);
		tf_bookNum.setBounds(426,65,320,25);
		jsp1.setBounds(30,140,330,290);
		jsp2.setBounds(426,140,320,290);
		//��Ӱ�ť
		add(bt_commit);
		add(bt_getInfo);
		add(bt_clear);
		bt_commit.setBounds(425,490,100,25);
		bt_getInfo.setBounds(535,490,100,25);
		bt_clear.setBounds(645,490,100,25);
	}
}
