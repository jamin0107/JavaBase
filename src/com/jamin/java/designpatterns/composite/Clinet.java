package com.jamin.java.designpatterns.composite;

public class Clinet {
	
	
	
	    public static void main(String[] args) {  
	        // TODO Auto-generated method stub  
	        Company root = new CompanyGroup();  
	        root.setName("�����ܹ�˾");  
	        root.add(new HRDepartment("�ܹ�˾������Դ��"));  
	        root.add(new FinanceDepartment("�ܹ�˾����"));  
	        
	        Company shandongCom = new CompanyGroup("ɽ���ֹ�˾");  
	        shandongCom.add(new HRDepartment("ɽ���ֹ�˾������Դ��"));  
	        shandongCom.add(new FinanceDepartment("ɽ���ֹ�˾����"));  
	        Company zaozhuangCom = new CompanyGroup("��ׯ���´�");  
	        zaozhuangCom.add(new FinanceDepartment("��ׯ���´�����"));  
	        zaozhuangCom.add(new HRDepartment("��ׯ���´�������Դ��"));  
	        Company jinanCom = new CompanyGroup("���ϰ��´�");  
	        jinanCom.add(new FinanceDepartment("���ϰ��´�����"));  
	        jinanCom.add(new HRDepartment("���ϰ��´�������Դ��"));   
	        shandongCom.add(jinanCom);  
	        shandongCom.add(zaozhuangCom);  
	        
	        Company huadongCom = new CompanyGroup("�Ϻ������ֹ�˾");  
	        huadongCom.add(new HRDepartment("�Ϻ������ֹ�˾������Դ��"));  
	        huadongCom.add(new FinanceDepartment("�Ϻ������ֹ�˾����"));  
	        Company hangzhouCom = new CompanyGroup("���ݰ��´�");  
	        hangzhouCom.add(new FinanceDepartment("���ݰ��´�����"));  
	        hangzhouCom.add(new HRDepartment("���ݰ��´�������Դ��"));  
	        Company nanjingCom = new CompanyGroup("�Ͼ����´�");  
	        nanjingCom.add(new FinanceDepartment("�Ͼ����´�����"));  
	        nanjingCom.add(new HRDepartment("�Ͼ����´�������Դ��"));  
	        huadongCom.add(hangzhouCom);  
	        huadongCom.add(nanjingCom);   
	        
	        root.add(shandongCom);  
	        root.add(huadongCom);  
	        root.display(0);  
	    }  
	  
	}  