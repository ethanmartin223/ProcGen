package com.lethan.procgen;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class World {

    private WorldGenerator gen;

    public World() {
        gen = new WorldGenerator();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                gen.getChunk(x, y);
            }
        }
    }

    public void render(ShapeRenderer shapeRenderer) {
        for (Chunk c: gen.getChunkRenderList()) {
            c.render(shapeRenderer);
        }
    }
}
