package Exercise_5;

public class Test5 {
    public static void testExercise5() {
        System.out.println("---------------------\n" +
                "| Решение задания 5 |\n" +
                "---------------------");

        UsualMatrix a = new UsualMatrix(5000, 5000);
        SparseMatrix c = new SparseMatrix(5000, 5000);
        for (int i = 0; i < a.getRowCount(); i++) {
            for (int j = 0; j < a.getColumnCount(); j++) {
                if (j == 0) {
                    a.setElement(i, j, i + j + 1);
                    c.setElement(i, j, i + j + 1);
                }
            }
        }
        UsualMatrix firstUsual = new UsualMatrix(4, 4);
        UsualMatrix secondUsual = new UsualMatrix(4, 4);
        SparseMatrix firstSparse = new SparseMatrix(4, 4);
        SparseMatrix secondSparse = new SparseMatrix(4, 4);
        for (int i = 0; i < firstUsual.getRowCount(); i++) {
            for (int j = 0; j < firstUsual.getColumnCount(); j++) {
                if (j == 0) {
                    firstUsual.setElement(i, j, j + 1);
                    secondUsual.setElement(i, j, j + 1);
                    firstSparse.setElement(i, j, j + 1);
                    secondSparse.setElement(i, j, j + 1);
                }
            }
        }
        System.out.println("Первая матрица класса Usual: ");
        System.out.println(firstUsual);
        System.out.println("Вторая матрица класса Usual: ");
        System.out.println(secondUsual);
        System.out.println("Первая матрица класса Sparse: ");
        System.out.println(firstSparse);
        System.out.println("Вторая матрица класса Sparse: ");
        System.out.println(secondSparse);
        IMatrix resultSparseSum = firstSparse.sum(secondSparse);
        IMatrix resultUsualSum = firstUsual.sum(secondUsual);
        System.out.println("Сумма двух матриц класса Sparse: ");
        System.out.println(resultSparseSum);
        System.out.println("Сумма двух матриц класса Usual: ");
        System.out.println(resultUsualSum);
        System.out.println("Сравнение двух матриц классов Sparse и Usual после сложения: " + resultSparseSum.equals(resultUsualSum));
        resultSparseSum = firstSparse.product(secondSparse);
        resultUsualSum = firstUsual.product(secondUsual);
        System.out.println("Сравнение двух матриц классов Sparse и Usual после умножения: " + resultSparseSum.equals(resultUsualSum));
    }
}
