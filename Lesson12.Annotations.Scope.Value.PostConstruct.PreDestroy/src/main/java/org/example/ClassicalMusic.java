package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClassicalMusic implements Music{
	@Override
	public String getSong() {
		return "Rhapsody";
	}
}
