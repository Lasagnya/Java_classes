package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
	private Music classicalMusic;

	@Autowired
	public MusicPlayer(ClassicalMusic classicalMusic) {
		this.classicalMusic = classicalMusic;
	}

	public void playMusic() {
		System.out.println("Playing: " + classicalMusic.getSong());
	}
}
