package com.example.Something.graph;

public class DirectedGraphMatrixMatrix implements GraphMatrix {

    int size;
    int[][] g;

    public DirectedGraphMatrixMatrix(int size) {
        this.size = size;
        this.g = new int[size][size];
    }

    public void insetEdge(int start, int end) {
        if (start >= size || end >= size) {
            // 없는 정점
            return;
        }

        g[start][end] = 1;
    }
}
