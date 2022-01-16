package io.github.tilegame.state;

import io.github.tilegame.Game;
import io.github.tilegame.Handler;
import io.github.tilegame.entities.creatures.Creature;
import io.github.tilegame.entities.statics.Tree;
import io.github.tilegame.worlds.World;
import io.github.tilegame.entities.creatures.Player;
import java.awt.*;
import java.util.ArrayList;

public class GameState extends State {

    private Player player;
    private World world;
    private Tree tree;


    public GameState(Handler handler){
        super(handler);
//        Check in World class line 77
        world = new World(handler,".\\src\\io\\github\\tilegame\\res\\worlds\\world2.txt");
        handler.setWorld(world);
         //640, 1000 center of circle for map
    }

    @Override
    public void tick() {
        world.tick();

    }

    @Override
    public void render(Graphics g) {
        world.render(g);

    }
}
