package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Naditha on 14-Aug-17.
 */
public abstract class state {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    protected state(GameStateManager gsm)//*this is a constractor */
    {
        this.gsm=gsm;
        cam= new OrthographicCamera();
        mouse =new Vector3();

    }
    protected abstract void handleinput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
