package Exercise_7;

import java.io.IOException;

public class Test7 {
    public static void testExercise7() {
        System.out.println("---------------------\n" +
                "| Решение задания 7 |\n" +
                "---------------------");
        Settings s1 = new Settings();
        Settings s2 = new Settings();

        s1.put("AAA", 1);
        s2.put("AAA", 1);
        s1.put("BBB", 1);
        s2.put("BBB", 1);
        s1.put("CCC", 2);
        s2.put("CCC", 2);
        s1.put("AAA", 0);
        s2.put("AAA", 0);
        System.out.println("Первый HashMap");
        System.out.print(s1);
        System.out.println("Второй HashMap");
        System.out.print(s2);
        System.out.println("Проверка на равенство двух HashMap. Результат: " + s1.equals(s2));
        String path = "src/Exercise_7/output.txt";
        try {
            s2.saveToTextFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s1.loadFromTextFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Сохранение в файл второго HashMap и загрузка из файла в первый HashMap");
        System.out.println("Результат:");
        System.out.print(s1);
    }
}
