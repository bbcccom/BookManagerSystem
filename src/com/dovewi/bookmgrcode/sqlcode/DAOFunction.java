package com.dovewi.bookmgrcode.sqlcode;
/*
 * ����ʵ�����ݿ��д�����ȱ��뺯��
 * ���ݿ��й���db4free
 * ���ݿ��û�����iidove
 * ���ݿ����룺mytestserver
 * ��������������ݿ����������
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
	private static Connection conne;
	private static Statement state;

	public static Connection ConnectDatabase(){
		Connection con = null;  //���������������ݿ��Connection����  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://db4free.net:3306/dovewibmg", "iidove", "mytestserver");// ������������  
            System.out.println("���ݿ����ӳɹ�");              
        } catch (Exception e) {  
            System.out.println("���ݿ�����ʧ��" + e.getMessage());  
        }  
        return con;
	}

	//���ͼ�麯��
	public static int AddBook(){
		int tmp=1;
		String sql="";
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
		ResultSet tmp=null;
		String sql="select * from bm_book where 1";
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
		ResultSet tmp=null;
		String sql="select * from bm_book where bookname="+bookName+"or isbnnumber="+bookISBN+"or author="+bookAuthor;
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
		//TODO ���麯����ֱ����д��ź�ѧ��,��Ҫ���ѧ���Ƿ�����Ȿ��,����ɹ����ݿ�����ڹ�����һ,ѧ������������Ӧ��Ŀ,���ʱ��ΥԼ��ѧ����ΥԼ������һ
	}
	
	
	//���´������ڴ����Ϊ����������Ŀ��ɾ����Ŀ���޸���Ŀ�����ṩ����,�ɶ�Ӧ���д����
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
