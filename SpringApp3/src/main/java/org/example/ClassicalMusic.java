package org.example;

public class ClassicalMusic implements Music{
	public void doMyInit() {	//любой модификатор доступа, аргументов не должно быть
		System.out.println("Doing my initialization");
	}

	public void doMyDestroy() {		//любой модификатор доступа, аргументов не должно быть
		System.out.println("Doing my destruction");
	}

	@Override
	public String getSong() {
		return "Rhapsody";
	}
}
