package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by TOSHIBA on 26-Aug-17.
 */
public class astroman {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT =100;

    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Animation manAnimation;

    //private Texture astroman;
    private Texture texture;
    private Sound flap;







    public astroman(int x, int y){  //constractor of class
        position = new Vector3(x,y,0);
        velocity =new Vector3(0,0,0);
        //astroman =new Texture("astroman.png");

        texture=new Texture("astroAnim.png");
        manAnimation = new Animation(new TextureRegion(texture),3,0.5f);
        bounds = new Rectangle(x,y,texture.getWidth()/3,texture.getHeight());
        flap= Gdx.audio.newSound(Gdx.files.internal("pack.mp3"));

    }

    public void update(float dt)
    {
        manAnimation.update(dt);
        if(position.y>0) //so by this if only posdition is greather than 0 he will add gravity
            velocity.add(0,GRAVITY,0);//adding gravity to space man on y axis so if he was idle he will fall to ground
        velocity.scl(dt);
        position.add(MOVEMENT*dt,velocity.y,0);// when moving velocity changes in y axis

        if(position.y<0)//by this thing  if man hits the bottom the (position=0) then he will stop flying
            position.y=0;

        velocity.scl(1/dt); //velocity scales
        bounds.setPosition(position.x,position.y);

    }

    public Vector3 getPosition() //thesse are getters
    {
        return position;
    }

    public TextureRegion getTexture()//thesse are getters
    {
        return manAnimation.getFreme();
    }

    public void jump(){
        velocity.y=250;
        flap.play(0.5f);
    }

    public Rectangle getBounds(){

        return bounds;
    }

    public void dispose(){
        texture.dispose();
        flap.dispose();

    }


}


