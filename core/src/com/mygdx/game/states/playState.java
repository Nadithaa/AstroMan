package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Tube;
import com.mygdx.game.sprites.astroman;

/**
 * Created by TOSHIBA on 26-Aug-17.
 */
public class playState extends state {

    private static final int TUBE_Spacing=125;
    private static final int TUBE_count=4;
    private static final int GROUND_Y_OFFSET=-50;


    private astroman astro;
    private Texture bg;
    private Texture ground;
    private Vector2 groundpos1,groundpos2;

  // private Tube tube;

     private Array<Tube> tubes;


    public playState(GameStateManager gsm) {
        super(gsm);
        astro=new astroman(50,300);
        cam.setToOrtho(false, MyGdxGame.WIDTH / 2,MyGdxGame.HEIGHT / 2);
        bg= new Texture("bg.jpg");
        ground=new Texture("ground.JPG");
        groundpos1=new Vector2(cam.position.x - cam.viewportWidth/2,GROUND_Y_OFFSET);
        groundpos2=new Vector2((cam.position.x-cam.viewportWidth/2)+ground.getWidth(),GROUND_Y_OFFSET);
     //tube =new Tube(100);

        tubes =new Array<Tube>();

        for(int i=1;i<=TUBE_count;i++){
            tubes.add(new Tube(i*(TUBE_Spacing+Tube.TUBE_Width)));
        }
    }

    @Override
    protected void handleinput() {
        if(Gdx.input.justTouched())
            astro.jump();


    }

    @Override
    public void update(float dt) {
        handleinput();
        updateGround();
        astro.update(dt);
        cam.position.x=astro.getPosition().x+80;


        for(int i=0;i<tubes.size;i++)                            // for (Tube tube:tubes)
        {
            Tube tube= tubes.get(i);

            if (cam.position.x-(cam.viewportWidth/2)>tube.getPosToptube().x+ tube.getTopTube().getWidth()){
                //if tube off the camara it willl repostion the tube in to middle of the camra

            tube.repositation(tube.getPosToptube().x   + ((Tube.TUBE_Width+TUBE_Spacing)  * TUBE_count ));

            }

            if(tube.collides(astro.getBounds()))
                gsm.set(new playState(gsm));
        }


        if(astro.getPosition().y<=ground.getHeight()+GROUND_Y_OFFSET)
            gsm.set(new playState(gsm));
        cam.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);//game screen is zoomed in to the game character and redude teh drawing length of the game
        sb.begin();
       sb.draw(bg,cam.position.x-(cam.viewportWidth/2),0);

        sb.draw(astro.getTexture(),astro.getPosition().x,astro.getPosition().y);
    for (Tube tube:tubes) {
        sb.draw(tube.getTopTube(), tube.getPosToptube().x, tube.getPosToptube().y);
        sb.draw(tube.getBotTube(), tube.getPosBottomtube().x, tube.getPosBottomtube().y);
    }
        sb.draw(ground, groundpos1.x,groundpos1.y);
        sb.draw(ground, groundpos2.x,groundpos2.y);
        sb.end();
    }

    @Override
    public void dispose() {

        bg.dispose();
        astro.dispose();
        ground.dispose();
        for(Tube tube:tubes)
            tube.dispose();
        System.out.println("play state disposed ");
    }
    private void updateGround(){
        if(cam.position.x-(cam.viewportWidth/2)>groundpos1.x+ground.getWidth())
            groundpos1.add(ground.getWidth()*2,0);
        if(cam.position.x-(cam.viewportWidth/2)>groundpos2.x+ground.getWidth())
            groundpos2.add(ground.getWidth()*2,0);
    }

}
