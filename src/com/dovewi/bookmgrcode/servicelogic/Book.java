package com.dovewi.bookmgrcode.servicelogic;
//ͼ����Ϣ��,����ʵ�����ݿ��������������ȥ
public class Book {
	public String bkISBN;
	public String bkName;
	public String bkAuthor;
	public float bkPrice;
	public int bkAmount;//�ڹ�����
	public int bkSum;//�ܹ�����
	public String bkInfo;//ͼ����
	
	Book(){
		//�չ��캯��
	}
	
	//��ֵ���캯��
	Book(String bkISBN,String bkName,String bkAuthor,float bkPrice,int bkAmount,int bkSum,String bkInfo){
		this.bkISBN=bkISBN;
		this.bkName=bkName;
		this.bkAuthor=bkAuthor;
		this.bkPrice=bkPrice;
		this.bkAmount=bkAmount;
		this.bkSum=bkSum;
		this.bkInfo=bkInfo;
	}
}
