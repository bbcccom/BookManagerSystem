package com.dovewi.bookmgrcode.servicelogic;
//��д�������Ϊ�����ݿ�����ı��
//���õĹ��캯������Ϊ(��������������)
public class Reader {
	private String rNum;
	private String rName;
	private String rSex;
	private int rMaxLend;
	private int rBorrow;
	private int rRenegue;
	private String rPhone;
	private String rOther;
	
	Reader(){
		this.rName="";
		this.rNum="";
		this.rSex="";
		this.rMaxLend=0;
		this.rBorrow=0;
		this.rRenegue=0;
		this.rPhone="";
		this.rOther="";
	}
	
	Reader(String rNum,String rName,String rSex,int rMaxLend,int rBorrow,int rRenegue,String rPhone,String rOther){
		this.rNum=rNum;
		this.rName=rName;
		this.rSex=rSex;
		this.rMaxLend=rMaxLend;
		this.rBorrow=rBorrow;
		this.rRenegue=rRenegue;
		this.rPhone=rPhone;
		this.rOther=rOther;
	}
}
