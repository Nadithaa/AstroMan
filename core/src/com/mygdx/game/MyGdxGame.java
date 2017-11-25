package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH=400;// changing in window size
	public static final int HEIGHT=800;

	public static final String TITELE = " Bumping Astronaut "; //putting anew titele. we can change the titele from here

	private GameStateManager gsm;
	private SpriteBatch batch;
	private Music music;
	//Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		music= Gdx.audio.newMusic(Gdx.files.internal("bgmusic.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();

		//img = new Texture("badlogic.jpg"); i can change the bad logic image from here
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));

	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);// cler every thing on the screen and re draw every thing
										//		batch.begin();        position of the image
										//		batch.draw(img, 0, 0);
										//		batch.end();
		gsm.update(Gdx.graphics.getDeltaTime()); //tell the diffirence betrween the delata time
		gsm.render(batch);



	}//naditha100
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
		super.dispose();
		music.dispose();
	}
}
