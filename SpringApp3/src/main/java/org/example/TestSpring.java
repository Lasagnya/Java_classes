package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml"
		);
		//Music music = context.getBean("musicBean", Music.class);

		//MusicPlayer musicPlayer = new MusicPlayer(music);

//		MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//		MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
//		System.out.println(musicPlayer == musicPlayer1);
//		musicPlayer1.setVolume(20);
//		musicPlayer.playMusic();
//		System.out.println(musicPlayer.getName());
//		System.out.println(musicPlayer.getVolume());
//		System.out.println(musicPlayer1.getVolume());
		ClassicalMusic music1 = context.getBean("musicBean", ClassicalMusic.class);
		music1.getSong();
		RockMusic music2 = context.getBean("testBean", RockMusic.class);
		music2.getSong();
		RockMusic music3 = context.getBean("testBean", RockMusic.class);
		music3.getSong();
		context.close();
	}
}
