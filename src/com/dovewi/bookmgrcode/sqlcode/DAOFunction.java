package com.dovewi.bookmgrcode.sqlcode;
/*
 * ����ʵ�����ݿ��д�����ȱ��뺯��
 * ���ݿ��й���db4free
 * ���ݿ��û�����
 * ���ݿ����룺
 * add by dovewi
 */

import java.sql.*;

public class DAOFunction {
	//��������������Ҫmysql�������뵽mysql�ٷ�����
	private Connection conne;
	private Statement State;
	
	public static Connection ConnectDatabase(){
		//TODO ��ȡ���ݿ����Ӷ���
		//TODO ����ʹ�õĲ��Է�����Ϊ�ϴ�ͨѶ¼����ϵͳ�����ݿ�������������޸�
		Connection conTemp = null;
		try {
			Class.forName("java.mysql.jdbc.Driver");
			conTemp = DriverManager.getConnection(
					"jdbc:mysql://db4free.net:3306/dovewicontacts", "dovewi",
					"mytestserver");
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��" + e.getMessage());
		}
		return conTemp;
	}
	
	//���ͼ�麯��
	public static ResultSet AddBook(,){
		//TODO ���ͼ�鵽���ݿ�ĺ���
	}
	
	//ͼ���𻵺�ɾ��ͼ��ĺ���
	public static ResultSet DelBook(,){
		//TODO ��дͼ��ɾ������
	}
	
	public static ResultSet ListBook(){
		//TODO �鿴ͼ���б�
	}
	
	public static ResultSet SelectBook(,,){
		//TODO ��ѯͼ����Ϣ,��д����
	}
	
	public static ResultSet LendBooks(){
		//TODO ����ֱ�������
	}
	
	public static ResultSet ReturnBooks(){
		//TODO ���麯����ֱ����д���
	}
}
