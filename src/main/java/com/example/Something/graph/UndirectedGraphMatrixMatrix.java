package com.example.Something.graph;

public class UndirectedGraphMatrixMatrix implements GraphMatrix {

    int size;
    int[][] graph;

    public int[][] getGraph() {
        return graph;
    }

    public UndirectedGraphMatrixMatrix(int size) {
        this.size = size;
        this.graph = new int[size][size];
    }

    public void insetEdge(int start, int end) {
        if (start >= size || end >= size) {
            // 없는 정점
            return;
        }

        graph[start][end] = 1;
        graph[end][start] = 1;
    }

    public int calcDegree(int vertex) {
        int degree = 0;

        for (int i = 0; i < size; i++) {
            degree += graph[vertex][i];
        }

        return degree;
    }
}
