package org.example;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClassicalMusic implements Music{
	List<String> musicList = Arrays.asList("Moonlight Sonata",
			"Prelude in C major", "The Four Seasons - SPRING");
	@Override
	public List<String> getSongs() {
		return musicList;
	}
}
