package com.dovewi.bookmgrcode.sqlcode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.dovewi.bookmgrcode.vo.Book;
import com.dovewi.bookmgrcode.vo.LendBook;
import com.dovewi.bookmgrcode.vo.Reader;

@SuppressWarnings("unused")
public class TestDAO {
	
	public static void main(String args[])throws Exception{
		//��Ա�����
		//reader�����Ӳ���
		/*Reader rd=new Reader();
		rd.setReaderName("ϲ����");
		rd.setReaderNum("1108060205");
		rd.setReaderSex("M");
		rd.setMaxLend(5);
		rd.setBorrowNum(0);
		rd.setRenegue(0);
		rd.setReaderPhone("18285121312");
		rd.setOther("0");
		boolean flag=ReaderTableDatabaseCode.addReader(rd);
		if(flag==true)
			System.out.println("����ɹ�-������");
		else
			System.out.println("����ʧ��-������");*/
		
		//ɾ������
		/*boolean flag=UserTableDatabaseCode.delReader("1108060204");
		if(flag==true)
			System.out.println("ɾ���ɹ�-������");
		else
			System.out.println("ɾ��ʧ��-������");*/
		
		//�޸Ĳ���
		/*boolean flag=ReaderTableDatabaseCode.updateReader("1108060204", "readername", "�й��ƶ�");
		if (flag==true)
			System.out.println("�޸ĳɹ�-������");
		else
			System.out.println("�޸�ʧ��-������");*/
		
		
		
		//ͼ����Ĳ���
		/*Book bk=new Book();
		bk.setISBN("9787040182545");
		bk.setBookName("����ѧ(������²�)");
		bk.setBookAuthor("����ε&��ϣ˳&������");
		bk.setBookInfo("�����Ϊ��������,�²���Ҫ�����𶯺Ͳ���,��ѧ,��ѧ��");
		bk.setBookPrice("38.00");
		bk.setBookSum(100);
		bk.setBookAmount(100);
		boolean flag=BookTableDatabaseCode.addBook(bk);
		if(flag==true){
			System.out.println("����ͼ��ɹ�-������");
		}
		else
			System.out.println("����ͼ��ʧ��-������");*/
		//�޸�ͼ��
		/*boolean flag =BookTableDatabaseCode.updateBook("302275138", "bookname", "ë��ϯ��¼");
		if (flag==true)
			System.out.println("�޸ĳɹ�-������");
		else
			System.out.println("�޸�ʧ��-������");*/
		//ɾ��ͼ��
		/*boolean flag=BookTableDatabaseCode.delBook("302275138");
		if(flag==true)
			System.out.println("ɾ���ɹ�-������");
		else
			System.out.println("ɾ��ʧ��-������");*/
		
		
		//���������
		/*Date dt=new Date();
		java.sql.Date sqldt=new java.sql.Date(dt.getTime());
		Calendar cld=Calendar.getInstance();
		cld.setTime(dt);
		cld.add(Calendar.MONTH,1);
		Date dtreturn=cld.getTime();
		java.sql.Date sqldtreturn=new java.sql.Date(dtreturn.getTime());
		
		LendBook lbk=new LendBook();
		lbk.setISBN("9787040195835");
		lbk.setReaderNum("1108060204");
		lbk.setLendTime(sqldt);
		lbk.setShouldReturnTime(sqldtreturn);
		boolean flag=LendTableDatabaseCode.addLendBook(lbk);
		if(flag==true)
			System.out.println("����ɹ�-������");
		else
			System.out.println("����ʧ��-������");*/
		//ɾ��������Ŀ
		/*boolean flag=LendTableDatabaseCode.delLendBook("9787040182545","1108060204");
		if(flag==true)
			System.out.println("ɾ���ɹ�-������");
		else
			System.out.println("ɾ��ʧ��-������");*/
		
	}
}
