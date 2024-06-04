package com.DAY_24;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Person1{
	private String name;
	private int age;
	public Person1(String name, int age) {
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String toString() {
		return "Person{name='"+name+"',age="+age+"}";
	}
}
public class PersonSortLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Person1> people=new ArrayList<>();
people.add(new Person1("DDA",21));
people.add(new Person1("Chinni",21));
people.add(new Person1("Daddy",21));
people.sort(Comparator.comparingInt(Person1::getAge));
people.forEach(System.out::println);
	}

}
