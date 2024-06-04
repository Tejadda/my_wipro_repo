package com.DAY_24;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Person2 {
	private String name;
	private int age;

	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "Person{name='" + name + "',age=" + age + "}";
	}
}

public class PersonFunctionalInterfaces {
	public static void main(String[] args) {
		Person2 person = new Person2("DDA", 21);
		Predicate<Person2> isAdult = p -> p.getAge() >= 18;
		System.out.println("is Adult:" + isAdult.test(person));
		Function<Person2, String> getName = Person2::getName;
		System.out.println("Name:" + getName.apply(person));
		Consumer<Person2> printPerson2 = p -> System.out.println("Personal Details:" + p);
		printPerson2.accept(person);
		Supplier<Person2> createPerson2 = () -> new Person2("Daddy", 21);
		Person2 newPerson = createPerson2.get();
		System.out.println("New Person:" + newPerson);
	}
}
