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
        while (a.getValue() <= 1000){
            a = a.add(a);
            count++;
        }
        while (a.getValue() != 1000){
            a.decrement();
            count++;
        }
        System.out.println("Значение а: " + a.getValue());
        System.out.println("Всего операций " + count);
//        for (int i = 0; i < 49; i++) {
//            if (a.getValue() <= 1000){
//                count++;
//                a = a.add(a);
//            }
//            System.out.println(a.getValue());
//        }
    }
}
