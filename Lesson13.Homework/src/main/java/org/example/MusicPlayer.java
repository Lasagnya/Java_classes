package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
	private final List<Music> musicList;

	@Autowired
	public MusicPlayer(List<Music> musicList) {
		this.musicList = musicList;
	}

	public String playMusic() {
		return "Playing: " + musicList.get(new Random().nextInt(musicList.size())).getSong();
	}
}
