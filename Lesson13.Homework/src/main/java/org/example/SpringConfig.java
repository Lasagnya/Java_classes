package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
	@Bean
	public ClassicalMusic classicalMusic() {
		return new ClassicalMusic();
	}

	@Bean
	public RockMusic rockMusic() {
		return new RockMusic();
	}

	@Bean
	public ShitMusic shitMusic() {
		return new ShitMusic();
	}

	@Bean
	public List<Music> musicList() {
		List<Music> list = new ArrayList<>();
		list.add(rockMusic());
		list.add(classicalMusic());
		list.add(shitMusic());
		return list;
		//return Arrays.asList(classicalMusic(), rockMusic(), shitMusic());
	}

	@Bean
	public MusicPlayer musicPlayer() {
		return new MusicPlayer(musicList());
	}

	@Bean
	public Computer computer() {
		return new Computer(musicPlayer());
	}
}
