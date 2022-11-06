package Exercise_5;

import java.util.Arrays;

public class AbstractMatrix implements IMatrix {
    private final int rowCount;
    private final int columnCount;
    private final int[][] matrix;

    public AbstractMatrix(int rowCount, int columnCount) {
        if (rowCount <= 0 || columnCount <= 0) {
            throw new RuntimeException("Невозможно создать матрицу " + rowCount + "x" + columnCount);
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

    @Override
    public void setElement(int row, int column, int value) {
        if (row > this.rowCount || row < 0 || column > this.columnCount || column < 0)
            throw new RuntimeException("Нет такого элемента");
        this.matrix[row][column] = value;
    }

    @Override
    public int getElement(int row, int column) {
        if (row > this.rowCount || row < 0 || column > this.columnCount || column < 0)
            throw new RuntimeException("Нет такого элемента");
        return this.matrix[row][column];
    }

    @Override
    public IMatrix sum(IMatrix a) {
        if (this.rowCount != a.getRowCount() || this.columnCount != a.getColumnCount())
            throw new RuntimeException("Нельзя складывать матрицы разных размерностей");
        else {
            IMatrix temp = new AbstractMatrix(a.getRowCount(), a.getColumnCount());
            for (int i = 0; i < a.getRowCount(); i++) {
                for (int j = 0; j < a.getColumnCount(); j++) {
                    temp.setElement(i, j, this.matrix[i][j] + a.getElement(i, j));
                }
            }
            return temp;
        }
    }

    @Override
    public IMatrix product(IMatrix a) {
        if (this.columnCount != a.getRowCount())
            throw new RuntimeException("Умножение матриц невозможно! Количество столбцов первой матрицы не соответствует количеству строк второй");
        else {
            IMatrix temp = new AbstractMatrix(this.rowCount, a.getColumnCount());
            for (int i = 0; i < temp.getRowCount(); i++) {
                for (int j = 0; j < temp.getRowCount(); j++) {
                    int sum = 0;
                    for (int k = 0; k < a.getRowCount(); k++) {
                        sum += getElement(i, k) * a.getElement(k, j);
                    }
                    temp.setElement(i, j, sum);
                }
            }
            return temp;
        }
    }

    @Override
    public IMatrix subtraction(IMatrix a) {
        if (this.rowCount != a.getRowCount() || this.columnCount != a.getColumnCount())
            throw new RuntimeException("Нельзя складывать матрицы разных размерностей");
        else {
            IMatrix temp = new AbstractMatrix(a.getRowCount(), a.getColumnCount());
            for (int i = 0; i < a.getRowCount(); i++) {
                for (int j = 0; j < a.getColumnCount(); j++) {
                    temp.setElement(i, j, this.matrix[i][j] - a.getElement(i, j));
                }
            }
            return temp;
        }
    }

    @Override
    public int getRowCount() {
        return this.rowCount;
    }

    @Override
    public int getColumnCount() {
        return this.columnCount;
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
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof IMatrix))
            return false;

        IMatrix a = (IMatrix) obj;
        if (rowCount != a.getRowCount() || columnCount != a.getColumnCount())
            return false;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (this.getElement(i, j) != a.getElement(i, j)) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(this.matrix);
    }
}
