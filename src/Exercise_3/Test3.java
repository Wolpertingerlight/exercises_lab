package Exercise_3;

import Exercise_3.Matrix.Matrix;
import Exercise_3.SquareMatrix.SquareMatrix;

public class Test3 {
    public static void testExercise3() {
        System.out.println("---------------------\n" +
                "| Решение задания 3 |\n" +
                "---------------------");
        Matrix a = new Matrix(5, 5);
        SquareMatrix b = new SquareMatrix(5, 5);
        System.out.println("Проверка на равенство двух квадратный матриц из разных классов с разными значениями: " + a.equals(b));
        for (int i = 0; i < a.getRowCount(); i++) {
            for (int j = 0; j < a.getColumnCount(); j++) {
                if (i == j) a.setElement(i, j, 1);
            }
        }
        System.out.println("Проверка на равенство двух квадратный матриц из разных классов с одинаковыми значениями: " + a.equals(b));
        System.out.println("Сложение двух квадратных матриц одинаковой размерности, но разных классов:");
        Matrix c = a.sum(b);
        System.out.print(c);
    }
}
