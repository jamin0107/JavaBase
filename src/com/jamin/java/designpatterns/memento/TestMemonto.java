package com.jamin.java.designpatterns.memento;

public class TestMemonto {

	public static void main(String[] args) {

		// ����ԭʼ��
		OriginData origi = new OriginData("Jamin");

		// ��������¼
		Storage storage = new Storage(origi.createMemento());

		// �޸�ԭʼ���״̬
		System.out.println("��ʼ��״̬Ϊ��" + origi.getValue());
		origi.setValue("Lee");
		System.out.println("�޸ĺ��״̬Ϊ��" + origi.getValue());

		// �ظ�ԭʼ���״̬
		origi.restoreMemento(storage.getMemento());
		System.out.println("�ָ����״̬Ϊ��" + origi.getValue());
	}
	
}
