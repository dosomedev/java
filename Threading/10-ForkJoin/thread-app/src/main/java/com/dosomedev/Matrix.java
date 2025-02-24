package com.dosomedev;

public class Matrix {
    private final int[][] matrix;

    public Matrix(int nrows, int ncols) {
        matrix = new int[nrows][ncols];
    }

    public int getCols() {
        return matrix[0].length;
    }

    public int getRows() {
        return matrix.length;
    }

    public int getValue(int row, int col) {
        return matrix[row][col];
    }

    public void setValue(int row, int col, int value) {
        matrix[row][col] = value;
    }
    
    public static void dump(Matrix m) {
        for (int i=0; i<m.getRows(); i++) {
            for (int j=0; j<m.getCols(); j++) {
                System.out.printf("%d ", m.getValue(i, j));
            }
            System.out.println();
        }
        System.out.println();
    }
}
