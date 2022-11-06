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

    @Override
    public Matrix sum(Matrix matrix) {
        return super.sum(matrix);
    }
}
