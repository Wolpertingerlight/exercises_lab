package Exercise_5;

import java.util.Iterator;
import java.util.LinkedList;

public class SparseMatrix extends AbstractMatrix{
    private int sizeX;
    private int sizeY;
    private LinkedList<ElementMatrix> MyList;

    public SparseMatrix(int rowCount, int columnCount){
        super(rowCount,columnCount);
        MyList = new LinkedList<>();
        sizeX = rowCount;
        sizeY = columnCount;
    }

    @Override
    public void setElement(int row, int column, int value) {
        ElementMatrix el = new ElementMatrix(row,column,value);

        Iterator<ElementMatrix> it = MyList.listIterator();
        while (it.hasNext()) {
            ElementMatrix i = it.next();
            if(i.getY() == el.getY() && i.getX() == el.getX()){
                it.remove();
            }
        }
        if(value != 0)
            MyList.add(el);
    }

    @Override
    public int getElement(int row, int column) {
        for(ElementMatrix i : MyList) {
            if(i.getX() == row && i.getY() == column)
                return i.getValue();
        }
        return 0;
    }

    @Override
    public IMatrix sum(IMatrix a) {
        if (this.sizeX != a.getRowCount() || this.sizeY != a.getColumnCount())
            throw new RuntimeException("Нельзя складывать матрицы разных размерностей");
        else {
            IMatrix temp = new SparseMatrix(a.getRowCount(), a.getColumnCount());
            for (int i = 0; i < a.getRowCount(); i++) {
                for (int j = 0; j < a.getColumnCount(); j++) {
                    temp.setElement(i, j, this.getElement(i, j) + a.getElement(i, j));
                }
            }
            return temp;
        }
    }
}
