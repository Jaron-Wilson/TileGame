package io.github.tilegame.entities.statics;

import io.github.tilegame.Handler;
import io.github.tilegame.gfx.Assets;
import io.github.tilegame.tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y){
        super(handler, x,y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

        bounds.x = 10;
        bounds.y = 28;
        bounds.width = 20;
        bounds.height = 17;


    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int)(x- handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width,height,null);
    }
}
