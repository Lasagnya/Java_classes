package org.example;

import org.springframework.stereotype.Component;

public class ClassicalMusic implements Music{
	@Override
	public String getSong() {
		return "Rhapsody";
	}
}
