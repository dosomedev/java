package com.dosomedev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MatrixMultiplicationForkJoin extends RecursiveAction {
    private final Matrix a, b, c;
    private final int row;

    public MatrixMultiplicationForkJoin(Matrix a, Matrix b, Matrix c) {
        this(a, b, c, -1);
    }

    public MatrixMultiplicationForkJoin(Matrix a, Matrix b, Matrix c, int row) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("Rows and columns mismatch!");
        }

        this.a = a;
        this.b = b;
        this.c = c;
        this.row = row;
    }

    @Override
    protected void compute() {
        if (row == -1) {
            List<MatrixMultiplicationForkJoin> tasks = new ArrayList<>();

            for (int row=0; row<a.getRows(); row++) {
                tasks.add(new MatrixMultiplicationForkJoin(a, b, c, row));
            }
            
            invokeAll(tasks);
        } else {
            multiplyRowByColumn(a, b, c, row);
        }
    }

    private void multiplyRowByColumn(Matrix a, Matrix b, Matrix c, int row) {
        for (int j=0; j<b.getCols(); j++) {
            for (int k=0; k<a.getCols(); k++) {
                c.setValue(row, j, c.getValue(row, j) + a.getValue(row, k) * b.getValue(k, j));
            }
        }
    }
}
