package com.lethan.procgen;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class World {

    private WorldGenerator gen;
    private float scrolledX, scrolledY;

    public World() {
        gen = new WorldGenerator();
        for (int y=-180; y<180; y++) {
            for (int x=-180; x<180; x++) {
                gen.getChunk(x,y);
            }
        }
        gen.getChunk(0,0);
        scrolledX = 0;
        scrolledY = 0;
    }

    public void render(ShapeRenderer shapeRenderer) {
        for (Chunk c: gen.getChunkRenderList()) {
            c.render(shapeRenderer);
        }
    }
}
