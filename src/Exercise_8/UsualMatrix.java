package Exercise_8;

public class UsualMatrix implements Comparable<UsualMatrix> {
    protected int[][] array;
    protected int rowCount;
    protected int columnCount;

    public UsualMatrix(int row, int column) {
        array = new int[row][column];
        rowCount = row;
        columnCount = column;
        for (int i = 0; i < rowCount; i++)
            for (int j = 0; j < columnCount; j++)
                array[i][j] = 0;
    }

    public UsualMatrix sum(UsualMatrix usualMatrix) {
        if (rowCount == usualMatrix.getRowCount() && columnCount == usualMatrix.getColumnCount()) {
            UsualMatrix resultMatrix = new UsualMatrix(rowCount, columnCount);
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    int temp = usualMatrix.getElement(i, j) + this.getElement(i, j);
                    resultMatrix.setElement(i, j, temp);
                }
            }
            return resultMatrix;
        }
        return null;
    }

    public UsualMatrix product(UsualMatrix usualMatrix) {
        if (columnCount == usualMatrix.getRowCount()) {
            UsualMatrix res = new UsualMatrix(rowCount, usualMatrix.getColumnCount());
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < usualMatrix.getColumnCount(); j++) {
                    res.setElement(i, j, 0);
                    for (int k = 0; k < columnCount; k++) {
                        res.setElement(i, j, res.getElement(i, j) + (this.getElement(i, k) * usualMatrix.getElement(k, j)));
                    }
                }
            }
            return res;
        }
        return null;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setElement(int row, int column, int value) {
        array[row][column] = value;
    }

    public int getElement(int row, int column) {
        return array[row][column];
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++)
                res.append(" ").append(getElement(i, j));
            res.append("\n");
        }
        return res.toString();
    }

    public boolean equals(Object obj) {
        boolean res = false;

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UsualMatrix))
            return false;

        UsualMatrix a = (UsualMatrix) obj;
        if (rowCount != a.getRowCount() || columnCount != a.getColumnCount())
            return false;
        int flag = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (this.getElement(i, j) != a.getElement(i, j))
                    flag++;
            }
        }
        if (flag == 0)
            res = true;
        return res;
    }

    @Override
    public int compareTo(UsualMatrix usualMatrix) {

        int sum1 = 0;
        for (int i = 0; i < this.getRowCount(); i++)
            for (int j = 0; j < this.getColumnCount(); j++)
                sum1 += this.getElement(i, j);
        int sum2 = 0;
        for (int i = 0; i < usualMatrix.getRowCount(); i++)
            for (int j = 0; j < usualMatrix.getColumnCount(); j++)
                sum2 += usualMatrix.getElement(i, j);

        if (sum1 == sum2)
            return 0;
        if (sum1 > sum2)
            return 1;
        return -1;
    }
}
