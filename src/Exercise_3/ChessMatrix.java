package Exercise_3;

import Exercise_3.Matrix.Matrix;

public class ChessMatrix extends Matrix {
    private final int realRowCount;
    private final int realColumnCount;

    public ChessMatrix(int realRowCount, int realColumnCount) {

        super((int) Math.ceil(realRowCount*0.5), (int) Math.ceil(realColumnCount*0.5));

        this.realRowCount = realRowCount;
        this.realColumnCount = realColumnCount;
        for (int i = 0; i <  Math.ceil(realRowCount*0.5); i++) {
            for (int j = 0; j < Math.ceil(realColumnCount*0.5); j++) {
                  this.setElement(i, j, 1);
            }
        }
    }

    @Override
    public int getColumnCount() {
        return realColumnCount;
    }

    @Override
    public int getRowCount() {
        return realRowCount;
    }

    public Matrix getMatrix(){
        Matrix chMatrix = new Matrix(realRowCount, realColumnCount);

        for (int i = 0; i < this.realRowCount; i++) {
            for (int j = 0; j < this.realColumnCount; j++) {
                chMatrix.setElement(i, j, j%2 == i%2 ? this.getElement((int) Math.round(i*0.5), (int) Math.round(j*0.5)) : 0);
            }
        }
        return chMatrix;
    }

    @Override
    public Matrix sum(Matrix matrix) {
        return this.getMatrix().sum(matrix);
    }

    @Override
    public Matrix product(Matrix matrix) {
        return this.getMatrix().product(matrix);
    }
    @Override
    public String toString() {
        return this.getMatrix().toString();
    }

    @Override
    public boolean equals(Object object){
        return this.getMatrix().equals(object);
    }


}
