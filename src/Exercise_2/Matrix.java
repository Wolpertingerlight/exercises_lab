package Exercise_2;

public class Matrix {
    private int size;
    private int[][] matrix;

    public Matrix(int size) {
        this.size = size;
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) this.matrix[i][j] = 1;
                else this.matrix[i][j] = 0;
            }
        }
    }

    public int getSize() {
        return this.size;
    }


    public void setElement(int row, int column, int value) {
        this.matrix[row][column] = value;
    }

    public int getElement(int row, int column) {
        return this.matrix[row][column];
    }

    public Matrix sum(Matrix matrix) {
        if (this.size != matrix.size) throw new RuntimeException("Размеры матриц не равны");
        else {
            Matrix temp = new Matrix(matrix.size);
            for (int i = 0; i < matrix.size; i++) {
                for (int j = 0; j < matrix.size; j++) {
                    temp.setElement(i, j, this.matrix[i][j] + matrix.getElement(i, j));
                }
            }
            return temp;
        }
    }

    public Matrix product(Matrix matrix) {
        if (this.size != matrix.size) throw new RuntimeException("Размеры матриц не равны");
        else {
            Matrix temp = new Matrix(matrix.size);
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < matrix.size; j++) {
                    int sum = 0;
                    for (int k = 0; k < matrix.size; k++) {
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
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                sb.append(' ').append(this.getElement(i, j)).append('\t');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
