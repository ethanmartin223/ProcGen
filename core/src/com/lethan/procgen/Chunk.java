package com.lethan.procgen;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Chunk {
    private final int chuckContents;
    private final int x, y;
    private final WorldGenerator generator;

    public Chunk(WorldGenerator gen, int x, int y, int v) {
        chuckContents = v;
        this.x = x;
        this.y = y;
        generator = gen;
    }

    @Override
    public String toString() {
        return String.valueOf(chuckContents);
    }

    private void calculateDistance() {}

    void render(ShapeRenderer shapeRenderer) {
        int s = generator.getChunkRenderSize();
        if (chuckContents == 1) shapeRenderer.rect(x*s, y*s, s, s);
    }
}
