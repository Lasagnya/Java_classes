package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
	private RockMusic rockMusic;
	private ClassicalMusic classicalMusic;

	@Autowired
	public MusicPlayer(RockMusic rockMusic, ClassicalMusic classicalMusic) {
		this.rockMusic = rockMusic;
		this.classicalMusic = classicalMusic;
	}

	public String playMusic(MusicGenre musicGenre) {
		switch (musicGenre) {
			case ROCK:
				return rockMusic.getSongs().get(new Random().nextInt(3));
			case CLASSICAL:
				return classicalMusic.getSongs().get(new Random().nextInt(3));
			default:
				return "Unsigned genre";
		}
	}
}
