package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml"
		);
//		Music music = context.getBean("rockMusic", Music.class);
//		Music music2 = context.getBean("classicalMusic", Music.class);
//		MusicPlayer musicPlayer = new MusicPlayer(music);
//		MusicPlayer musicPlayer2 = new MusicPlayer(music2);
//		musicPlayer.playMusic();
//		musicPlayer2.playMusic();

//		MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//		musicPlayer.playMusic();

		MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(musicPlayer.getName());
		System.out.println(musicPlayer.getVolume());

		ClassicalMusic cm1 = context.getBean("classicalMusic", ClassicalMusic.class);
		ClassicalMusic cm2 = context.getBean("classicalMusic", ClassicalMusic.class);
		System.out.println(cm1 == cm2);
		context.close();
	}
}
