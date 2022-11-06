package Exercise_8;

public class Test8 {
    public static void testExercise8() {
        System.out.println("---------------------\n" +
                "| Решение задания 8 |\n" +
                "---------------------");
        long timeParallel = System.currentTimeMillis();
        ParallelMatrixProduct p = new ParallelMatrixProduct(700);
        UsualMatrix a = new UsualMatrix(700, 700);
        UsualMatrix b = new UsualMatrix(700, 700);
        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 700; j++) {
                a.setElement(i, j, 1);
                b.setElement(j, i, 1);
            }
        }
        p.productParallel(a, b);
        long t = System.currentTimeMillis();
        timeParallel = t - timeParallel;
        System.out.print("Время при многопоточном произведении матриц: " + timeParallel + "\n");
        long timeUsual = System.currentTimeMillis();
        UsualMatrix c = new UsualMatrix(700, 700);
        UsualMatrix d = new UsualMatrix(700, 700);
        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 700; j++) {
                c.setElement(i, j, 1);
                d.setElement(j, i, 1);
            }
        }
        c.product(d);
        long s = System.currentTimeMillis();
        timeUsual = s - timeUsual;
        System.out.println("Время при обычном произведении матриц: " + timeUsual + "\n");
    }
}
