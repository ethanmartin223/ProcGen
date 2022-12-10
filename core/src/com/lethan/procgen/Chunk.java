package com.lethan.procgen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chunk {
    private final int x, y;
    private final WorldGenerator generator;
    private final Random rng;

    public Chunk(WorldGenerator gen, int x, int y, Random rng) {
        this.rng = rng;
        this.x = x;
        this.y = y;
        generator = gen;
        int s = generator.getChunkRenderSize();
    }


    private void calculateDistance() {}

    void render(ShapeRenderer shapeRenderer) {
        int s = generator.getChunkRenderSize();
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(x*s,y*s,s,s);
    }
}
