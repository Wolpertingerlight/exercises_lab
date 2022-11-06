package Exercise_3.Matrix;

import Exercise_3.MyException;
import Exercise_3.SquareMatrix.SquareMatrix;

public class Matrix {
    private final int[][] matrix;
    private final int columnCount;
    private final int rowCount;

    public Matrix(int rowCount, int columnCount) {
        if (rowCount <= 0 || columnCount <= 0) {
            throw new MyException("Невозможно создать матрицу " + rowCount + "x" + columnCount);
        } else {
            this.columnCount = columnCount;
            this.rowCount = rowCount;
            this.matrix = new int[rowCount][columnCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    this.matrix[i][j] = 0;
                }
            }
        }

    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }


    public void setElement(int row, int column, int value) {
        if (row > this.rowCount || row < 0 || column > this.columnCount || column < 0)
            throw new MyException("Нет такого элемента");
        this.matrix[row][column] = value;
    }

    public int getElement(int row, int column) {
        if (row > this.rowCount || row < 0 || column > this.columnCount || column < 0)
            throw new MyException("Нет такого элемента");
        return this.matrix[row][column];
    }

    public Matrix sum(Matrix matrix) {
        if (this.rowCount != matrix.rowCount || this.columnCount != matrix.columnCount)
            throw new MyException("Нельзя складывать матрицы разных размерностей");
        else {
            Matrix temp = new Matrix(matrix.rowCount, matrix.columnCount);
            for (int i = 0; i < matrix.rowCount; i++) {
                for (int j = 0; j < matrix.columnCount; j++) {
                    temp.setElement(i, j, this.matrix[i][j] + matrix.getElement(i, j));
                }
            }
            return temp;
        }
    }

    public Matrix product(Matrix matrix) {
        if (this.columnCount != matrix.rowCount)
            throw new MyException("Умножение матриц невозможно! Количество столбцов первой матрицы не соответствует количеству строк второй");
        else {
            Matrix temp = new Matrix(this.rowCount, matrix.columnCount);
            for (int i = 0; i < temp.rowCount; i++) {
                for (int j = 0; j < temp.columnCount; j++) {
                    int sum = 0;
                    for (int k = 0; k < matrix.rowCount; k++) {
                        sum += getElement(i, k) * matrix.getElement(k, j);
                    }
                    temp.setElement(i, j, sum);
                }
            }
            return temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                sb.append(' ').append(this.getElement(i, j)).append('\t');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Matrix temp) {
            if (this.rowCount != temp.rowCount || this.columnCount != temp.columnCount)
                throw new MyException("Невозможно сравнить матрицы разных размерностей");
            else {
                for (int i = 0; i < this.rowCount; i++) {
                    for (int j = 0; j < this.columnCount; j++) {
                        if (this.matrix[i][j] != temp.getElement(i, j))
                            return false;
                    }
                }
                return true;
            }
        } else {
            if (object instanceof SquareMatrix temp){
                if (this.rowCount != temp.getRowCount() || this.columnCount != temp.getColumnCount())
                    throw new MyException("Невозможно сравнить матрицы разных размерностей");
                else {
                    for (int i = 0; i < this.rowCount; i++) {
                        for (int j = 0; j < this.columnCount; j++) {
                            if (this.matrix[i][j] != temp.getElement(i, j))
                                return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
