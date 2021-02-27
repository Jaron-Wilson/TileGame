package io.github.tilegame.entities.statics;

import io.github.tilegame.Handler;
import io.github.tilegame.entities.Entity;

                       // Static means it does not move like tree or rock!
public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }

}
