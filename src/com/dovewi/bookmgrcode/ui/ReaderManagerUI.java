package com.dovewi.bookmgrcode.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ReaderManagerUI extends JPanel{
	ReaderManagerUI(){
		this.setLayout(null);
		JTabbedPane tb=new JTabbedPane();
		tb.addTab("�������֤", new AddReaderPane());
		tb.addTab("�޸���Ϣ",new UpdateReaderPane());
		tb.addTab("ɾ������",new DeleteReaderPane());
		tb.addTab("�����ѯ", new QueryReaderPane());
		tb.setVisible(true);
		tb.setBounds(20,20,750,500);
		this.add(tb);
	}
}

class AddReaderPane extends JPanel{
	
	AddReaderPane(){
		
		JButton btt=new JButton("����");
		add(arp);
		add(btt);
	}
	
}

class DeleteReaderPane extends JPanel{
	DeleteReaderPane(){
		
	}
}

class UpdateReaderPane extends JPanel{
	UpdateReaderPane(){
		
	}
}

class QueryReaderPane extends JPanel{
	QueryReaderPane(){
		
	}
}
