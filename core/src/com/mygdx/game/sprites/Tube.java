package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by TOSHIBA on 05-Oct-17.
 */
public class Tube {

    public static final int TUBE_Width=52;

    public static final int FLUCTUATION =130;
    public static final int TUBE_GAP=100;
    public static final int LOWEST_OPENING=120;


    private Texture topTube,botTube;
    private Vector2 posToptube,posBottomtube;
    private Rectangle boundsTop,boundsbot;
    private Random rand;



    public Tube(float x){
        topTube=new Texture("toptube.png");
        botTube=new Texture("bottube.png");

        rand= new Random();

        posToptube = new Vector2(x,rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENING );
        posBottomtube= new Vector2(x,posToptube.y - TUBE_GAP - botTube.getHeight());


        boundsTop= new Rectangle(posToptube.x,posToptube.y,topTube.getWidth(),topTube.getHeight());
        boundsbot= new Rectangle(posBottomtube.x,posBottomtube.y,botTube.getWidth(),botTube.getHeight());

    }


    public Vector2 getPosBottomtube() {
        return posBottomtube;
    }

    public Vector2 getPosToptube() {
        return posToptube;
    }

    public Texture getBotTube() {
        return botTube;
    }

    public Texture getTopTube() {
        return topTube;
    }

    public  void repositation(Float x){
        posToptube.set(x,rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENING );
        posBottomtube.set(x,posToptube.y - TUBE_GAP - botTube.getHeight());
        boundsTop.setPosition(posToptube.x, posToptube.y);
        boundsbot.setPosition(posBottomtube.x,posBottomtube.y);
    }
    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsbot);
    }

    public void dispose(){
        topTube.dispose();
        botTube.dispose();
    }
}
