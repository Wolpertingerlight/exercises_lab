package Exercise_1;

public class Test1 {
    public static void testExercise1() {
        System.out.println("---------------------\n" +
                "| Решение задания 1 |\n" +
                "---------------------");
        Int a = new Int();
        a.increment(); // 1 операция
        a.increment(); // 2 операция
        int count = 2;
        while (a.getValue() <= 1000) {
            a = a.add(a);
            count++;
        }
        while (a.getValue() != 1000) {
            a.decrement();
            count++;
        }
        System.out.println("Значение а: " + a.getValue());
        System.out.println("Всего операций " + count);
        Int first = new Int(-1);
        Int second = new Int(-1);
        System.out.println("Произведение (" + first + ") x (" + second + ") = " + first.multiply(second));
        second = new Int(-3);
        System.out.println("Произведение (" + first + ") x (" + second + ") = " + first.multiply(second));
    }
}
