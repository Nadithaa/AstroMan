package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

/**
 * Created by TOSHIBA on 26-Aug-17.
 */
public class MenuState extends state {

    private Texture playbutton;
    private Texture background;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, MyGdxGame.WIDTH / 2,MyGdxGame.HEIGHT / 2);
        background= new Texture("astroids.jpg");
        playbutton= new Texture("play-button.png");

    }

    @Override
    public void handleinput() {
    if(Gdx.input.justTouched()){
        gsm.set(new playState(gsm));
    }
    }

    @Override
    public void update(float dt) {
     handleinput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
    sb.begin();
        sb.draw(background,0,0);
        sb.draw(playbutton,cam.position.x-playbutton.getWidth()/2 ,cam.position.y) ;
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbutton.dispose();
        System.out.println("Menustate disposed ");
    }
}
