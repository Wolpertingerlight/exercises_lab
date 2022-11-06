package Exercise_2;

public class Test2 {
    public static void testExercise2() {
        Matrix a = new Matrix(2);
        for (int i = 0; i < a.getSize(); i++) {
            for (int j = 0; j < a.getSize(); j++) {
                if (i == j) a.setElement(i, j, 0);
                else a.setElement(i, j, 1);
            }
        }
        a.setElement(0, 0, 1);
        Matrix c = new Matrix(2);
        for (int i = 0; i < 10; i++) {
            c = c.product(a);
        }
        System.out.println("---------------------\n" +
                "| Решение задания 2 |\n" +
                "---------------------");
        System.out.print(c);
    }
}
