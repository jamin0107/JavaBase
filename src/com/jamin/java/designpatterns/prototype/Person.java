package com.jamin.java.designpatterns.prototype;

import java.util.ArrayList;

/**
 * OkHttpClient Intent
 * ԭ��ģʽ
 * @author Jamin
 *
 */
public class Person implements Cloneable {

	private String name;
	private int age;
	private double weight;
	private double height;
	private ArrayList<String> hobbies = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + ", height=" + height + ", hobbies="
				+ hobbies + "]";
	}

	@Override
	protected Object clone() {
		Person person = null;
		try {
			person = (Person) super.clone();
			person.name = this.name;
			person.weight = this.weight;
			person.height = this.height;
			person.age = this.age;
			//���¡
			person.hobbies = (ArrayList<String>) this.hobbies.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return person;
	}

	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(18);
		p.setName("����");
		p.setHeight(178);
		p.setWeight(65);
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("����");
		hobbies.add("���");
		hobbies.add("����");
		p.setHobbies(hobbies);
		System.out.println(p);

		Person p1 = (Person) p.clone();
		System.out.println(p1);

		p1.setName("����");
		p1.getHobbies().add("��Ӿ");
		System.out.println(p);
		System.out.println(p1);
	}
}
