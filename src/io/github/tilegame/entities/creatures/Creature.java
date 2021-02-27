package io.github.tilegame.entities.creatures;

import io.github.tilegame.Game;
import io.github.tilegame.Handler;
import io.github.tilegame.entities.Entity;
import io.github.tilegame.tiles.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 50,
                            DEFAULT_CREATURE_HEIGHT = 50;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        moveX();
        moveY();
    }

    public void moveX(){
        int tx;

        if(xMove > 0){//Moving right
            tx = (int) Math.floor((x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH);

            if(!collisionWithTile(tx, (int)Math.floor((y + bounds.y) / Tile.TILEHEIGHT)) &&
                    !collisionWithTile(tx, (int)Math.floor((y + bounds.y + bounds.height) / Tile.TILEHEIGHT))) {
                x += xMove;
            }else {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }
        }else if(xMove < 0){//Moving left
            tx = (int) Math.floor((x + xMove + bounds.x) / Tile.TILEWIDTH);

            if(!collisionWithTile(tx, (int)Math.floor((y + bounds.y) / Tile.TILEHEIGHT)) &&
                    !collisionWithTile(tx, (int)Math.floor((y + bounds.y + bounds.height) / Tile.TILEHEIGHT))) {
                x += xMove;
            }else {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;// + 1;
            }
        }
    }

    public void moveY(){
        int ty;

        if(yMove < 0){//Up
            ty = (int) Math.floor((y + yMove + bounds.y) / Tile.TILEHEIGHT);

            if(!collisionWithTile((int)Math.floor((x + bounds.x) / Tile.TILEWIDTH), ty) &&
                    !collisionWithTile((int)Math.floor((x + bounds.x + bounds.width) / Tile.TILEWIDTH), ty)) {
                y += yMove;
            }else {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;// + 1;
            }
        }else if(yMove > 0){//Down
            ty = (int) Math.floor((y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT);

            if(!collisionWithTile((int)Math.floor((x + bounds.x) / Tile.TILEWIDTH), ty) &&
                    !collisionWithTile((int)Math.floor((x + bounds.x + bounds.width) / Tile.TILEWIDTH), ty)) {
                y += yMove;
            }else {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }

    //getters and setters

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
