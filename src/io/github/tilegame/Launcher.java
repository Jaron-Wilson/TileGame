package io.github.tilegame;

public class Launcher {

    public static void main(String[] args) {
       Game game = new Game("/res/worlds/world1.txt", 640,360);
       game.start();
    }

}
