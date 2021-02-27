package io.github.tilegame.tiles;

import io.github.tilegame.gfx.Assets;

public class RockTile extends Tile{

    public RockTile(int id) {

        super(Assets.blue, id);
    }

       @Override
        public boolean isSolid(){
            return true;
    }
}
