package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width=MyGdxGame.WIDTH;   //height and width changer in desktop mode
		config.height=MyGdxGame.HEIGHT;

		config.title=MyGdxGame.TITELE;

		new LwjglApplication(new MyGdxGame(), config);
	}
}
