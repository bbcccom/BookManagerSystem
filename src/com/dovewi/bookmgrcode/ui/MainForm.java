package com.dovewi.bookmgrcode.ui;

/* 
 * ͼ�����ϵͳ
 * 
 * ʵ��������
 * 
 * Ҫ��ϳ����ʵ��
 * 
 * add by dovewi
*/

import java.awt.event.*;
import javax.swing.*;

public class MainForm extends JFrame {
	//TODO ʵ�������壬ͨ�����캯��������ʵ��
	//TODO ʵ�ֱ�ǩ��ʽ���棬�����ڹ�ͼ���ѯ�����飬���飬������ͼ��
	//TODO ��ϸ�������ͼ��ľ�����
	MainForm(){
		super("ͼ�����ϵͳ");
		setSize(800,600);
		setVisible(true);
		JTabbedPane MJTP=new JTabbedPane();
		MJTP.addTab("����", new LendBookPanelUI());
		MJTP.addTab("����",new ReturnBookUI());
		MJTP.addTab("����", new RenewUI());
		MJTP.addTab("���",new AddBookUI());
		getContentPane().add(MJTP);
		validate();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
