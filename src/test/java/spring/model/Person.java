package spring.model;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 8959494067353504538L;
	private String name;
	private String gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Person(){}
	public Person(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + "]";
	}
	
	
}
