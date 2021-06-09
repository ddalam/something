package com.example.Something.graph;

import org.junit.jupiter.api.Test;


class UndirectedGraphMatrixMatrixTest {

    @Test
    void 무방향_그래프_생성하기() {
        UndirectedGraphMatrixMatrix matrix = new UndirectedGraphMatrixMatrix(4);
        matrix.insetEdge(0, 1);
        matrix.insetEdge(0, 2);
        matrix.insetEdge(0, 3);
        matrix.insetEdge(1, 2);
        matrix.insetEdge(3, 2);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix.getGraph()[i][j]);
            }
            System.out.println();
        }
    }
}