package com.technova.dms.commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class DmsCommonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmsCommonsApplication.class, args);

		test();
		test1();
	}

	public static void loopThrough() {
		List<String>  list = Arrays.asList("Ashmin", "prajawal", "siddhant", "Anushil");
		System.out.println("Before-------");
		System.out.println(list);

		try{
			for(String name: list) {
				list.remove("Ashmin");
			}
		} catch (ArithmeticException aex) {
			System.out.println(aex.getMessage());
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println("After---------");
		System.out.println(list);
	}

	private static void test() {
		List<String>  list = Arrays.asList("Ashmin", "prajawal", "siddhant", "Anushil");
		list
				.stream()
				.map(String::toLowerCase)
				.forEach(System.out::println);
	}

	private static void test1() {
		List<String>  list = Arrays.asList("Ashmin", "prajawal", "siddhant", "Anushil");
		list
				.stream()
				.map(name -> String.valueOf(name).toLowerCase())
				.forEach(lowerCaseName -> System.out.println(lowerCaseName));
	}



}
