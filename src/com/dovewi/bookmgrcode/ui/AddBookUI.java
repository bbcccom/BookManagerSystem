package com.dovewi.bookmgrcode.ui;
/*
 * @ͼ������ǩui����
 * 
 * @������ť���¼�������com.dovewi.bookmgrcode.servicelogic����
 * 
 * @by dovewi
 * 
 * @2013.11.16
 */
import javax.swing.*;
import com.dovewi.bookmgrcode.servicelogic.ActionManager;

public class AddBookUI extends JPanel {
	//��ҪActionManager�ܹ�������Щ�ֶ�ȡ��ֵ
	public static JTextField tf_bookName=new JTextField(40);
	public static JTextField tf_bookISBN=new JTextField(15);
	public static JTextField tf_bookAuthor=new JTextField(30);
	public static JTextField tf_bookPrice=new JTextField(5);
	public static JTextField tf_bookSum=new JTextField(6);
	public static JTextArea ta_bookInfo=new JTextArea();
	public static JButton bt_commit;
	public static JButton bt_clear;
	//�������
	AddBookUI(){
		//��ǩ
		JLabel label_bookName=new JLabel("����");
		JLabel label_bookISBN=new JLabel("ISBN");
		JLabel label_bookAuthor=new JLabel("����");
		JLabel label_bookPrice=new JLabel("���");
		JLabel label_bookSum=new JLabel("����");
		JLabel label_bookInfo=new JLabel("ͼ����");
		//���ӹ�������岢���ta_bookinfo
		JScrollPane jspl=new JScrollPane(ta_bookInfo);
		//��ť
		bt_commit=new JButton("�ύ");
		bt_clear=new JButton("���");
		//��ʼ���촰��
		setLayout(null);
		this.add(label_bookISBN);
		label_bookISBN.setBounds(40, 40, 60, 16);
		this.add(label_bookName);
		label_bookName.setBounds(40,130,60,16);
		this.add(label_bookAuthor);
		label_bookAuthor.setBounds(40,223,60,16);
		this.add(label_bookPrice);
		label_bookPrice.setBounds(40,314,60,16);
		this.add(label_bookSum);
		label_bookSum.setBounds(40,394,60,16);
		this.add(label_bookInfo);
		label_bookInfo.setBounds(340,40,60,16);
		//����ı��򵽴���
		this.add(tf_bookISBN);
		tf_bookISBN.setBounds(40, 70, 271, 30);
		this.add(tf_bookName);
		tf_bookName.setBounds(40,155,271,30);
		this.add(tf_bookAuthor);
		tf_bookAuthor.setBounds(40,249,271,30);
		this.add(tf_bookPrice);
		tf_bookPrice.setBounds(40,338,271,30);
		this.add(tf_bookSum);
		tf_bookSum.setBounds(40,420,271,30);
		this.add(jspl);
		jspl.setBounds(340,70,400,380);//��ӵĹ��������
		//���������ť,���������õ�ҵ���߼�����
		this.add(bt_commit);
		bt_commit.setBounds(530,470,100,25);
		bt_commit.addActionListener(new ActionManager());
		this.add(bt_clear);
		bt_clear.setBounds(640,470,100,25);
		bt_clear.addActionListener(new ActionManager());
	}
}
