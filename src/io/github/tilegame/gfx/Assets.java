package io.github.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 30, height = 30;

    public static BufferedImage box, box1,sand,stone,nbox,tnt,water,blue,bad, redsand,grass, stonebox, bluelava,triangle, player, tree;

    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static BufferedImage player_still_up, player_still_down, player_still_left, player_still_right;

    public static void init(){
    SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/io/github/tilegame/res/textures/L.png"));

        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_right = new BufferedImage[2];

        player_up[0] = sheet.crop(width * 2+3, height *2, width, height);
        player_up[1] = sheet.crop(width+3, height *2, width, height);

        player_left[0] = sheet.crop(width, height *3, width, height);
        player_left[1] = sheet.crop(width *2, height *3, width, height);

        player_right[0] = sheet.crop(width, height *4, width, height);
        player_right[1] = sheet.crop(width*2, height *4, width, height);

        player_down[0] = sheet.crop(width * 2 +6, height, width, height);
        player_down[1] = sheet.crop(width +3, height, width, height);

        player_still_up = sheet.crop(0, height*2, width, height);//up
        player_still_down = sheet.crop(0, height , width, height);//down

//        player_still_right = sheet.crop(width *6, height *4, width, height);//left
//        player_still_left = sheet.crop(width* 6, height *3, width, height);//right


        box = sheet.crop(0,0,width,height);
        box1 = sheet.crop(width ,0,width,height);
        sand = sheet.crop(width*2, 0,width,height);
        stone = sheet.crop(width*3 ,0,width,height);
        nbox = sheet.crop(width*4 ,0,width,height);
        tnt = sheet.crop(width*5 ,0,width,height);
        water = sheet.crop(width*6 ,0,width,height);
        blue = sheet.crop(width*7 ,0,width,height);
        bad = sheet.crop(width*8 ,0,width,height);
        redsand = sheet.crop(width*9 ,0,width,height);
        grass = sheet.crop(width*10 ,0,width,height);
        stonebox = sheet.crop(width*11 ,0,width,height);
        bluelava = sheet.crop(width*12 ,0,width,height);
        triangle = sheet.crop(width*13 ,0,width,height);
        player = sheet.crop(width*14 ,0,width,height);
        tree = sheet.crop(width*15, 0, width,height);

    }
}
