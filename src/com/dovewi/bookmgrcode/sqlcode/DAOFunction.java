package com.dovewi.bookmgrcode.sqlcode;
/*
 * ����ʵ�����ݿ��д�����ȱ��뺯��
 * ���ݿ��й���db4free
 * ���ݿ��û�����
 * ���ݿ����룺
 * add by dovewi
*/
/*����Ŀ��Ҫ�õ��ı�
 * ѧ����
 * ͼ���
 * �����
 * ����Ա��
*/
import java.sql.*;

public class DAOFunction {
	//��������������Ҫmysql�������뵽mysql�ٷ�����
	private static Connection conne;
	private static Statement state;

	public static Connection ConnectDatabase(){
		//TODO ��ȡ���ݿ����Ӷ���
		//TODO ����ʹ�õĲ��Է�����Ϊ�ϴ�ͨѶ¼����ϵͳ�����ݿ�������������޸�
		Connection conTemp = null;
		try {
			Class.forName("java.mysql.jdbc.Driver");
			conTemp = DriverManager.getConnection(
					"jdbc:mysql://db4free.net:3306", "dovewi",
					"mytestserver");
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��" + e.getMessage());
		}
		return conTemp;
	}

	//���ͼ�麯��
	public static int AddBook(String bkName){
		int tmp=1;
		String sql="";//������Ҫִ�еĲ�ѯ��䣬�ȴ�����
		try{
			conne=ConnectDatabase();
			state=conne.createStatement();
			tmp=state.executeUpdate(sql);
		}catch(SQLException e){
			System.out.println("���ִ���"+e.getMessage());
		}
		return tmp;
	}

/*	//ͼ���𻵺�ɾ��ͼ��ĺ���
	public static ResultSet DelBook(,){
		//TODO ��дͼ��ɾ������
	}*/

	public static ResultSet ListBook(){
		//TODO �鿴ͼ���б�
		ResultSet tmp=null;
		String sql="";//������Ҫִ�еĲ�ѯ��䣬�ȴ�����
		try{
			conne=ConnectDatabase();
			state=conne.createStatement();
			tmp=state.executeQuery(sql);
		}catch(SQLException e){
			System.out.println("���ִ���"+e.getMessage());
		}
		return tmp;//���ؽ������ҵ���߼�����
	}

	public static ResultSet SelectBook(String bookISBN,String bookName,String bookAuthor){
		//TODO ��ѯͼ����Ϣ,������������
		ResultSet tmp=null;
		String sql="";//������Ҫִ�еĲ�ѯ��䣬�ȴ�����
		try{
			conne=ConnectDatabase();
			state=conne.createStatement();
			tmp=state.executeQuery(sql);
		}catch(SQLException e){
			System.out.println("���ִ���"+e.getMessage());
		}
		return tmp;
	}

	public static ResultSet LendBooks(String bookISBN,String stuNumber){
		return null;
		//TODO ����ֱ������ţ�Ϊ�˱�����ֲ�޸ģ�����Ŀ���ݿⲻ������������������޸���Ҫͬ������Ĳ���
		
	}

	public static ResultSet ReturnBooks(String bookISBN,String stuNumber){
		return null;
		//TODO ���麯����ֱ����д���
	}
	
	
	//���´������ڴ����Ϊ����������Ŀ��ɾ����Ŀ���޸���Ŀ�����ṩ����
	private static int AddItem(){
		return 0;
	}
	
	private static int DelItem(){
		return 0;
	}
	
	private static int UpdateItem(){
		return 0;
	}
}
