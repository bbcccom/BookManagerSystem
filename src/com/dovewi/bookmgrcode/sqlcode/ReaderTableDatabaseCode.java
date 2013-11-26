package com.dovewi.bookmgrcode.sqlcode;

import java.sql.*;
import com.dovewi.bookmgrcode.vo.Reader;

public class ReaderTableDatabaseCode {
	private static Connection con;
	private static PreparedStatement stat = null;
	private static String sql;

	// ��ѯ����(�ַ���)
	// ���Ӷ���(���߶���)
	// ɾ������(���߱��)
	// �޸Ķ���(�޸Ķ�����,�޸���Ŀ,�޸�ֵ)
	// ���������޸Ķ���
	public static boolean addReader(Reader rd) {
		sql = "insert into bm_reader (readernum,readername,readersex,maxlend,borrownum,renegue,readerphone,other) values (?,?,?,?,?,?,?,?)";
		int flag = 0;
		try {
			con = DatabaseConnection.getMyDatabaseConnection();
			stat = con.prepareStatement(sql);
			stat.setString(1, rd.getReaderNum());
			stat.setString(2, rd.getReaderName());
			stat.setString(3, rd.getReaderSex());
			stat.setInt(4, rd.getMaxLend());
			stat.setInt(5, rd.getBorrowNum());
			stat.setInt(6, rd.getRenegue());
			stat.setString(7, rd.getReaderPhone());
			stat.setString(8, rd.getOther());
			flag = stat.executeUpdate();
			stat.close();
			con.close();
		} catch (Exception e) {
			System.out.println("���ִ���:" + e.getMessage());
		}
		if (flag > 0)
			return true;
		else
			return false;
	}

	public static boolean delReader(String num) {
		sql = "DELETE FROM bm_reader WHERE readernum=" + num;
		int flag = 0;
		try {
			con = DatabaseConnection.getMyDatabaseConnection();
			stat = con.prepareStatement(sql);
			flag = stat.executeUpdate();
			stat.close();
			con.close();
		} catch (Exception e) {
			System.out.println("ɾ������:" + e.getMessage());
		}
		if (flag > 0)
			return true;
		else
			return false;
	}

	public static boolean updateReader(String num, String item, String value) {
		sql = "UPDATE bm_reader SET "+item+"=? WHERE readernum=?;";
		int flag = 0;
		try {
			con = DatabaseConnection.getMyDatabaseConnection();
			stat = con.prepareStatement(sql);
			stat.setString(1, value);
			stat.setString(2, num);
			flag = stat.executeUpdate();
			stat.close();
			con.close();
		} catch (Exception e) {
			System.out.println("���³���" + e.getMessage());
		}
		if (flag > 0)
			return true;
		else
			return false;
	}
	
	//ͨ�ò�ѯ
	public static ResultSet queryReader(String item){
		ResultSet rs=null;
		sql="SELECT FROM bm_reader WHERE readername='"+item+"' or readernum='"+item+"' or readerphone='"+item+"';";
		try{
			con=DatabaseConnection.getMyDatabaseConnection();
			stat=con.prepareStatement(sql);
			rs=stat.executeQuery();
			stat.close();
			con.close();
		}catch(Exception e){
			System.out.println("��ѯ����"+e.getMessage());
		}
		return rs;
	}
}
