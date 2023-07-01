package org.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
@Scope("singleton")
public class ClassicalMusic implements Music{
	@PostConstruct
	public void init() {						//нужно подключить javax.annotation
		System.out.println("Initialization");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destruction");
	}

	@Override
	public String getSong() {
		return "Rhapsody";
	}
}
