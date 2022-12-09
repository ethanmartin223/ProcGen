package com.lethan.procgen;

import java.util.HashMap;
import java.util.Random;

public class WorldGenerator {
    private final int CHUNK_RENDER_DISTANCE = 12;
    private final int SEED = 120821;
    private Random rng;
    private HashMap<Integer, HashMap<Integer, Chunk>> worldMap;

    public WorldGenerator() {
        rng = new Random(SEED);
        worldMap= new HashMap<>();
    }

    private Chunk yieldNext(int x, int y) {
        Chunk nextChunk = new Chunk(x, y, (int)(rng.nextDouble()+.5));
        if (!worldMap.containsKey(x)) worldMap.put(x, new HashMap<Integer, Chunk>());
        worldMap.get(x).put(y, nextChunk);
        return nextChunk;
    }

    public Chunk getChunk(int x, int y) {
        if (worldMap.containsKey(x) && worldMap.get(x).containsKey(y))
            return worldMap.get(x).get(y);
        else return yieldNext(x,y);
    }

    public HashMap<Integer, HashMap<Integer, Chunk>> getChunkMap() {
        return worldMap;
    }

}
