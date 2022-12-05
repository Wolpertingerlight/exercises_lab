package Exercise_3;
import Exercise_3.Matrix.Matrix;

public class Test3 {
    public static void testExercise3() {
        System.out.println("---------------------\n" +
                "| Решение задания 3 |\n" +
                "---------------------");
//        SquareMatrix a = new SquareMatrix(5, 5);
//        SquareMatrix b = new SquareMatrix(5, 5);
//        System.out.println("Проверка на равенство двух квадратный матриц с одинаковыми значениями: " + a.equals(b));
//        System.out.println("Сложение двух квадратных матриц одинаковой размерности:");
//        SquareMatrix c = a.sum(b);
//        System.out.print(c);
        ChessMatrix ch = new ChessMatrix(3,3);
        System.out.println(ch);
        Matrix m = new Matrix(3,1);
        Matrix c = ch.product(m);
        System.out.println(m);
    }
}
