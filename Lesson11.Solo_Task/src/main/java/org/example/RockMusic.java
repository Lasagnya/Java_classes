package org.example;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RockMusic implements Music{
	List<String> musicList = Arrays.asList("Under the bridge",
			"Immigrant Song", "Song 2");
	@Override
	public List<String> getSongs() {
		return musicList;
	}
}
