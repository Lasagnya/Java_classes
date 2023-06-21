package org.example;

public class RockMusic implements Music{
	public void myInitMethod() {
		System.out.println("Rock initialization");
	}

	public void myDestroyMethod() {
		System.out.println("Rock destruction");
	}
	@Override
	public String getSong() {
		return "Wind cries Mary";
	}
}
