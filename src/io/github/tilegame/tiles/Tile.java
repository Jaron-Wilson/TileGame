package io.github.tilegame.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //STATIC STUFF HERE

    public static Tile[] tiles = new Tile[250];
    public static Tile grassTile = new GrassTile(0);
    public static Tile waterTile = new WaterTile(1);
    public static Tile rockTile = new RockTile(2);
    public static Tile stoneTile = new StoneTile(3);
    public static Tile sandTile = new SandTile(4);
    public static Tile redSandTile = new RedSandTile(5);

    //CLASS
    // Mini Square big body 30 x 30, double the normal squares 60 x 60
//change the size of board here V        V       V        V
    public static final int TILEWIDTH = 60, TILEHEIGHT = 60;


    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g , int x, int y){
        g.drawImage(texture, x ,y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }

}
