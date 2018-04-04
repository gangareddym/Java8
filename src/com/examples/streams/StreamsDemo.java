package com.examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Ganga", "Musku", 38),
				new Person("Charles", "Dickens", 42),
				new Person("George", "Clooney", 50),
				new Person("Donald", "Trump", 65),
				new Person("Barrak", "Obama", 60),
				new Person("Bill", "Clinton", 75),
				new Person("Elliot", "Ester", 42),
				new Person("Fulbabu", "Sinha", 50));
		
		// Filter the persons with first name starting with B
		List<Person> personsWithFNB = persons.stream().filter(p->p.getFirstName().startsWith("B")).collect(Collectors.toList());
		
		//Filter persons with age >=50
		List<Person> personsWithAge50 = persons.stream().filter(p->p.getAge()>=50).collect(Collectors.toList());
		
		// Find average age of all the persons
		Double avgAge = persons.stream().collect(Collectors.averagingInt(p->p.getAge()));
				
		//Group Persons by age
		Map<Integer, List<Person>> personsGrpByAge = persons.stream().collect(Collectors.groupingBy(p->p.getAge()));
		//personsGrpByAge.forEach((k,v)->System.out.println(k + "::" + v));
		
		//Sort them by age
		persons.sort((p1, p2)-> p1.getAge()-p2.getAge());
		persons.forEach(System.out::println);
	}

}
