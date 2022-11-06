package Exercise_5;

public interface IMatrix {
    void setElement(int row, int column, int value);

    int getElement(int row, int column);

    IMatrix sum(IMatrix a);

    IMatrix product(IMatrix a);

    IMatrix subtraction(IMatrix a);

    int getRowCount();

    int getColumnCount();

    String toString();

    boolean equals(Object obj);

    int hashCode();
}
