package com.lethan.procgen;

public class Chunk {
    private final int chuckContents;
    private final int x, y;

    public Chunk(int x, int y, int v) {
        chuckContents = v;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.valueOf(chuckContents);
    }

    private void calculateDistance() {}

    private void render() {

    }
}
