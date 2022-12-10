package com.lethan.procgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class WorldGenerator {
    private final int CHUNK_RENDER_DISTANCE = 12;
    private final int SEED = 12082;
    private final int chunkRenderSize = 16;
    private Random rng;
    private HashMap<Integer, HashMap<Integer, Chunk>> worldMap;
    private List<Chunk> chunkRenderList;

    public WorldGenerator() {
        worldMap= new HashMap<>();
        chunkRenderList = new ArrayList<>();
    }

    private Chunk yieldNext(int x, int y) {
        rng = new Random(SEED*x+y);
        Chunk nextChunk = new Chunk(this, x, y, new Random());
        if (!worldMap.containsKey(x)) worldMap.put(x, new HashMap<Integer, Chunk>());
        worldMap.get(x).put(y, nextChunk);
        chunkRenderList.add(nextChunk);
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

    public List<Chunk> getChunkRenderList() {
        return chunkRenderList;
    }

    public int getChunkRenderSize() {
        return chunkRenderSize;
    }
}
