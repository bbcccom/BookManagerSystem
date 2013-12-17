package com.dovewi.bookmgrcode.servicelogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import com.dovewi.bookmgrcode.sqlcode.BookTableDatabaseCode;
import com.dovewi.bookmgrcode.sqlcode.LendTableDatabaseCode;
import com.dovewi.bookmgrcode.sqlcode.ReaderTableDatabaseCode;
import com.dovewi.bookmgrcode.ui.AddBookUI;
import com.dovewi.bookmgrcode.ui.LendBookPanelUI;
import com.dovewi.bookmgrcode.ui.ReturnBookUI;
import com.dovewi.bookmgrcode.vo.Book;
import com.dovewi.bookmgrcode.vo.LendBook;

public class ActionManager implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// ���ͼ�����İ�ť����¼���Ӧ
		if (arg0.getSource() == AddBookUI.bt_commit) {
			String a = "";
			String b = "";
			String c = "";
			String d = "";
			String e = "";
			String f = "";
			String g = "";
			a = AddBookUI.tf_bookISBN.getText();
			b = AddBookUI.tf_bookSum.getText();
			c = AddBookUI.tf_bookName.getText();
			d = AddBookUI.tf_bookPrice.getText();
			e = AddBookUI.ta_bookInfo.getText();
			f = AddBookUI.tf_bookSum.getText();
			g = AddBookUI.tf_bookAuthor.getText();
			Book bktmp = new Book();
			bktmp.setISBN(a);
			bktmp.setBookSum(b);
			bktmp.setBookName(c);
			bktmp.setBookPrice(d);
			bktmp.setBookInfo(e);
			bktmp.setBookAmount(f);
			bktmp.setBookAuthor(g);
			boolean flag = BookTableDatabaseCode.addBook(bktmp);
			if (flag == true) {
				System.out.println("����ͼ��ɹ�-������");
			} else
				System.out.println("����ͼ��ʧ��-������");
		}

		else if (arg0.getSource() == AddBookUI.bt_clear) {
			AddBookUI.tf_bookName.setText("");
			AddBookUI.tf_bookISBN.setText("");
			AddBookUI.tf_bookAuthor.setText("");
			AddBookUI.tf_bookPrice.setText("");
			AddBookUI.tf_bookSum.setText("");
			AddBookUI.ta_bookInfo.setText("");
		}

		// �������İ�ť�¼���Ӧ
		else if (arg0.getSource() == LendBookPanelUI.bt_commit) {
			String rn = LendBookPanelUI.tf_readerNum.getText();
			String bn = LendBookPanelUI.tf_bookNum.getText();

			// ��������ȷ���Ƿ���Խ���
			ResultSet rs2 = ReaderTableDatabaseCode.queryReader(rn);
			int ldnum = 0;
			int mxnum = 0;
			try {
				while (rs2.next()) {
					ldnum = rs2.getInt("borrownum");
					mxnum = rs2.getInt("maxlend");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (ldnum >= mxnum) {
				System.out.println("���Ľ�����������");
			} else {

				// ����book��ʹ������1
				ResultSet rs1 = BookTableDatabaseCode.queryBook(bn, false);
				int bknum = 0;
				try {
					while (rs1.next()) {
						bknum = rs1.getInt("amount");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				bknum--;
				BookTableDatabaseCode.updateBook(bn, "amount",
						String.valueOf(bknum));

				// �������߱�ʹ����������1
				ldnum++;
				ReaderTableDatabaseCode.updateReader(rn, "borrownum",
						String.valueOf(ldnum));

				// ��������ӽ����¼
				Date dt = new Date();
				java.sql.Date sqldt = new java.sql.Date(dt.getTime());
				Calendar cld = Calendar.getInstance();
				cld.setTime(dt);
				cld.add(Calendar.MONTH, 1);
				Date dtreturn = cld.getTime();
				java.sql.Date sqldtreturn = new java.sql.Date(
						dtreturn.getTime());

				LendBook lbk = new LendBook();
				lbk.setISBN(bn);
				lbk.setReaderNum(rn);
				lbk.setLendTime(sqldt);
				lbk.setShouldReturnTime(sqldtreturn);
				boolean flag = LendTableDatabaseCode.addLendBook(lbk);
				if (flag == true)
					System.out.println("����ɹ�");
				else
					System.out.println("����ʧ��");
			}
		}

		else if (arg0.getSource() == LendBookPanelUI.bt_getInfo) {
			String rn = LendBookPanelUI.tf_readerNum.getText();
			String bn = LendBookPanelUI.tf_bookNum.getText();
			ResultSet rs1 = ReaderTableDatabaseCode.queryReader(rn);
			ResultSet rs2 = BookTableDatabaseCode.queryBook(bn, false);
			String rdInfo = "";
			String bkInfo = "";
			try {
				while (rs1.next()) {
					rdInfo = "������" + rs1.getString("readername") + "\n" + "�Ա�"
							+ rs1.getString("readersex") + "\n" + "�绰��"
							+ rs1.getString("readerphone") + "\n" + "�ڽ�������"
							+ rs1.getString("borrownum") + "\n";
				}
			} catch (SQLException e) {
				System.out.println("���ִ�����ActionManager�ࣺ" + e.getMessage());
			}
			LendBookPanelUI.ta_readerInfo.setText(rdInfo);
			try {
				while (rs2.next()) {
					bkInfo = "������" + rs2.getString("bookname") + "\n" + "���ߣ�"
							+ rs2.getString("author") + "\n" + "�۸�"
							+ rs2.getString("price") + "\n" + "�ڹ�������"
							+ rs2.getString("amount") + "\n" + "��飺"
							+ rs2.getString("bookinfo");
				}
			} catch (SQLException e) {
				System.out.println("���ִ�����ActionManager�ࣺ" + e.getMessage());
			}
			LendBookPanelUI.ta_bookInfo.setText(bkInfo);
		}

		else if (arg0.getSource() == LendBookPanelUI.bt_clear) {
			LendBookPanelUI.ta_bookInfo.setText("");
			LendBookPanelUI.ta_readerInfo.setText("");
			LendBookPanelUI.tf_bookNum.setText("");
			LendBookPanelUI.tf_readerNum.setText("");
		}

		// ��������¼���Ӧ
		else if (arg0.getSource() == ReturnBookUI.btnGet) {
			String readerNum = ReturnBookUI.tfReaderNum.getText();
			String lendList = "";
			ResultSet rs = LendTableDatabaseCode.queryBook(readerNum);
			try {
				while (rs.next()) {
					lendList = lendList + rs.getString("readernum") + "\t\t"
							+ rs.getString("isbnnumber") + "\t"
							+ rs.getString("lendtime") + "\t\t"
							+ rs.getString("shouldreturntime") + "\n";
				}
			} catch (SQLException e) {
				System.out.println("��ѯ�����б���ʾ���ִ���" + e.getMessage());
			}
			ReturnBookUI.taBookList.setText("���ߺ�\t\t���\t\t����ʱ��\t\tӦ��ʱ��\n"
					+ lendList);
		} else if (arg0.getSource() == ReturnBookUI.btnTrue) {
			String bookNum = ReturnBookUI.tfBookNum.getText();
			String readerNum = ReturnBookUI.tfReaderNum.getText();
			// ��ѯ�Ƿ��н����¼
			boolean rs1 = LendTableDatabaseCode.delLendBook(bookNum, readerNum);
			if (rs1 == true) {
				ResultSet rs2 = BookTableDatabaseCode.queryBook(bookNum, false);
				int bn = 0;
				try {
					while (rs2.next()) {
						bn = rs2.getInt("amount");
					}
				} catch (SQLException e) {
					System.out.println("��ѯ���ڹݼ�¼ʧ�ܣ�" + e.getMessage());
				}
				bn++;
				boolean rs3 = BookTableDatabaseCode.updateBook(bookNum,
						"amount", String.valueOf(bn));
				ResultSet rs4 = ReaderTableDatabaseCode.queryReader(readerNum);
				int ln = 0;
				try {
					while (rs4.next()) {
						ln = rs4.getInt("borrownum");
					}
				} catch (SQLException e) {
					System.out.println("�޸Ķ��߽�����ʧ��" + e.getMessage());
				}
				ln--;
				boolean rs5 = ReaderTableDatabaseCode.updateReader(readerNum,
						"borrownum", String.valueOf(ln));
				if (rs3 == true && rs5 == true) {
					JOptionPane.showConfirmDialog(null, "����ɹ�", "ϵͳ��Ϣ",
							JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showConfirmDialog(null, "����ʧ�ܣ����ݿ����ʧ�ܣ�����", "ϵͳ��Ϣ",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showConfirmDialog(null, "����ʧ�ܣ������¼������", "ϵͳ��Ϣ",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (arg0.getSource() == ReturnBookUI.btnClear) {
			ReturnBookUI.taBookList.setText("");
			ReturnBookUI.tfBookNum.setText("");
			ReturnBookUI.tfReaderNum.setText("");
		}
	}
}
