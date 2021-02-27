package io.github.tilegame.entities.creatures;

import io.github.tilegame.Handler;
import io.github.tilegame.gfx.Animation;
import io.github.tilegame.gfx.Assets;
import io.github.tilegame.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Creature{

    //Animations
    private Animation animDown, animUp, animLeft,animRight, animStill_Up,animStill_Down,animStill_Right, animStill_Left;

    private java.util.List<Animation> animations = new ArrayList<>();

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);


        bounds.x = 10;
        bounds.y = 28;
        bounds.width = 20;
        bounds.height = 17;

        //Animations can change 500 is half a second
        animations.add(animDown = new Animation(200, Assets.player_down));
        animations.add(animUp = new Animation(200, Assets.player_up));
        animations.add(animLeft = new Animation(200, Assets.player_left));
        animations.add(animRight = new Animation(200, Assets.player_right));


    }

    @Override
    public void tick() {
        //Animations

        for(Animation a : animations){
            a.tick();
        }

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput(){
        if(yMove != 0){ lastYMove = yMove;}
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//        (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }

    private float lastYMove;

    private BufferedImage getCurrentAnimationFrame() {
//       if (xMove < 0){
//           return animLeft.getCurrentFrame();
//       }else if (xMove >0){
//           return animRight.getCurrentFrame();
//       }

        if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else if (yMove > 0) {
            return animDown.getCurrentFrame();

        }else if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove == 0) {
            return (lastYMove < 0 ? Assets.player_still_up : Assets.player_still_down);
        }

        return Assets.player_still_left;

    }

}
