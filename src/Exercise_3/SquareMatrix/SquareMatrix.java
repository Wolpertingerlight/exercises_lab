package Exercise_3.SquareMatrix;

import Exercise_3.Matrix.Matrix;
import Exercise_3.MyException;

public class SquareMatrix extends Matrix {
    public SquareMatrix(int rowCount, int columnCount) {
        super(rowCount, columnCount);
        if (rowCount <= 0 || columnCount <= 0 || rowCount != columnCount) {
            throw new MyException("Невозможно создать квадратную матрицу " + rowCount + "x" + columnCount);
        } else {
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    if (i == j) this.setElement(i, j, 1);
                    else this.setElement(i, j, 0);
                }
            }
        }
    }

    public SquareMatrix sum(SquareMatrix matrix) {
        if (super.getRowCount() != matrix.getRowCount() || super.getColumnCount() != matrix.getColumnCount())
            throw new MyException("Нельзя складывать матрицы разных размерностей");
        else {
            SquareMatrix temp = new SquareMatrix(matrix.getRowCount(), matrix.getColumnCount());
            for (int i = 0; i < matrix.getRowCount(); i++) {
                for (int j = 0; j < matrix.getColumnCount(); j++) {
                    temp.setElement(i, j, super.getElement(i, j) + matrix.getElement(i, j));
                }
            }
            return temp;
        }
    }
}
